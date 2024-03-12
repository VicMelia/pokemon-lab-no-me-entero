package models

data class PokemonResponse(

    val name: String,
    val weight: Int,
    val height: Int,
    val species: Species,
    val types: List<TypeResponse>,
    val abilities: List<AbilityResponse>

)

