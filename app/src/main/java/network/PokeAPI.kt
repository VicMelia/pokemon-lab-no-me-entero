package network

import models.PokemonResponse
import models.Types
import es.uji.al415395.pokeuji.species.Species
import models.Abilities
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface PokeAPI {

    @Headers("Accept: application/json")
    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") name: String): PokemonResponse
    suspend fun getTypes(@Path("id") name: String): Types
    suspend fun getAbilities(@Path("id") name: String): Abilities
    //suspend fun getSpecies(@Path("id") name: String): Species

}