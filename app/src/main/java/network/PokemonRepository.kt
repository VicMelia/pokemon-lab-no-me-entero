package network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import models.Pokemon
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



}