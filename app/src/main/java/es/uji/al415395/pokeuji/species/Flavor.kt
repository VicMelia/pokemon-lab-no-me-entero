package es.uji.al415395.pokeuji.species

class Flavor(val version: String, description: String) {
    val description = convertDescription(description)

    private fun convertDescription(description: String) = description
        .replace('\n', ' ')
        .replace("\u000c", "")
}