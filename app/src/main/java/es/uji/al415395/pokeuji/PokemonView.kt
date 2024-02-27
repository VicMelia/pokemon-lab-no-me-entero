package es.uji.al415395.pokeuji

import models.Pokemon

interface PokemonView {

    fun showPokemonData(pokemon: Pokemon)
    fun showSearchError(error: Throwable)
    fun showImage(pokemon:PokemonViewModel)
    //declarar el resto de funciones y overridearlas en el Main Activity

}