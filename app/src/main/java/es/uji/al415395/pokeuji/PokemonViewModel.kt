package es.uji.al415395.pokeuji
import kotlinx.coroutines.Dispatchers
import models.Pokemon
import network.PokemonRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PokemonViewModel:ViewModel() {

    var view: PokemonView? = null
        set(value) {
            field = value
            if (value != null)
                pokemon?.let { displayPokemon(it) }
        }
    var pokemon: Pokemon? = null
        set(value) {
            field = value
            if (value != null)
                displayPokemon(value)
        }

    fun onPokemonSearchRequested(id: String) {
        viewModelScope.launch(Dispatchers.Main) {
            PokemonRepository.getPokemon(id)
                .onSuccess { pokemon = it }
                .onFailure { view?.showSearchError(it) }
        }
    }

    /*
    fun onPokemonSearchTypes(id: String) {
        viewModelScope.launch(Dispatchers.Main) {
            PokemonRepository.getTypes(id)
                .onSuccess { pokemon = it }
                .onFailure { view?.showSearchError(it) }
        }
    }
    */


    private fun displayPokemon(pokemon: Pokemon) = view ?. apply {
        showPokemonData(pokemon)
    }

}