package es.uji.al415395.pokeuji

interface PokemonView {

    fun showPokemonData(pokemon: PokemonViewModel)
    fun showSearchError(error: Throwable)
    fun showImage(pokemon:PokemonViewModel)
}