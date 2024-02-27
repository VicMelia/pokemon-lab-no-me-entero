package network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import es.uji.al415395.pokeuji.species.Species
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import models.Abilities
import models.Pokemon
import models.Types
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object PokemonRepository {

    private val api: PokeAPI
    init {
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        api = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(PokeAPI::class.java)
    }

    suspend fun getPokemon(id: String) = try {
        withContext(Dispatchers.IO) {
            val pokemonResponse = api.getPokemon(id.lowercase())
            with(pokemonResponse) {
                Result.success(Pokemon(id, name, weight, height))
            }
        }
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getTypes(id: String) = try {
        withContext(Dispatchers.IO) {
            val types = api.getTypes(id.lowercase())
            with(types) {
                Result.success(Types(id, name))
            }
        }
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getAbilities(id: String) = try {
        withContext(Dispatchers.IO) {
            val abilities = api.getAbilities(id.lowercase())
            with(abilities) {
                Result.success(Abilities(id, name, isHidden, slot))
            }
        }
    } catch (e: Exception) {
        Result.failure(e)
    }


    /*
    suspend fun getSpecies(id: String) = try {
        withContext(Dispatchers.IO) {
            val species = api.getSpecies(id.lowercase())
            with(species) {
                Result.success(Species(id, name))
            }
        }
    } catch (e: Exception) {
        Result.failure(e)
    }
    */


}