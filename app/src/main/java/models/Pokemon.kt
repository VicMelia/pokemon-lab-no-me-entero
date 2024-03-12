package models

data class Pokemon(

    val id : String,
    val name: String,
    val weight: Int,
    val height: Int,
    val species: SpecieModel,
    val types: List<TypeModel>,
    val abilities: List<AbilityModel>
    //val sprites: Sprites

)
