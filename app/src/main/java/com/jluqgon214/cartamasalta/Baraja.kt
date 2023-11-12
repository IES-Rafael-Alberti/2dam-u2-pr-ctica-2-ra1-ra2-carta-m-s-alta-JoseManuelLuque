package com.jluqgon214.cartamasalta

/**
 * Métodos:
 *
 * - crearBaraja() => Generar la lista de 52 cartas de la baraja.
 * - barajar() => Desordenar las cartas de la lista de cartas de la baraja (shuffle)
 * - dameCarta() => Retorna la última carta de la lista de cartas y la elimina de la baraja.
 */
class Baraja(listaCartas: ArrayList<Carta>) {
    var listaCartas = ArrayList<Carta>()

    init {
        this.listaCartas = listaCartas
    }

    companion object {
        var listaCartas = ArrayList<Carta>()
        fun crearBaraja() {
            for (palo in Palos.values()) {
                for (numero in 1..13) {
                    val carta = Carta(Naipes.values()[numero - 1], palo, numero, asignarValor(numero), asignarImagen(numero, palo))
                    listaCartas.add(carta)
                }
            }
        }
        private fun asignarValor(numero: Int): Int {
            return when {
                numero == 1 -> 11 // As
                numero > 10 -> 10 // Figuras (Jota, Reina, Rey)
                else -> numero
            }
        }

        private fun asignarImagen(numero: Int, palo: Palos): String {
            val nombreImagen = "R.Drawable.${palo.name[0].toLowerCase()}${numero}"
            return nombreImagen
        }

        fun barajar() {
            listaCartas.shuffle()
        }

        fun dameCarta(): Carta {
            val carta = listaCartas.last()
            listaCartas.removeLast()
            return carta
        }
    }
}