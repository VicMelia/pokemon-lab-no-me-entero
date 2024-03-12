package network

import models.PokemonResponse
import models.Ability
import models.AbilityResponse
import models.TypeResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface PokeAPI {

    @Headers("Accept: application/json")
    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") name: String): PokemonResponse
    suspend fun getTypes(@Path("id") name: String): TypeResponse
    suspend fun getAbilities(@Path("id") name: String): AbilityResponse
    //suspend fun getSpecies(@Path("id") name: String): Species

}