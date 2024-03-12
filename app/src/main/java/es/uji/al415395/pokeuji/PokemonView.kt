package es.uji.al415395.pokeuji

import models.AbilityModel
import models.Pokemon

interface PokemonView {

    fun showPokemonData(pokemon: Pokemon)
    fun showSearchError(error: Throwable)
    fun showImage(pokemon:PokemonViewModel)
    fun showAbilities(ability: List<AbilityModel>)
    //declarar el resto de funciones y overridearlas en el Main Activity

}