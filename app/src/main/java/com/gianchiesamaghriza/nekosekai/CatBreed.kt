package com.gianchiesamaghriza.nekosekai

import com.google.gson.annotations.SerializedName

class CatBreed {
    var id: String = ""
    var name: String = ""
    var description: String = ""
    var temperament: String = ""
    var adaptability: Int = 0
    var intelligence: Int = 0
    var rare: Int = 0


    @SerializedName("life_span")
    var lifespan: String = ""
    var origin: String = ""

    @SerializedName("affection_level")
    var affection: Int = 0

    @SerializedName("child_friendly")
    var childfriendly: Int = 0

    @SerializedName("cat_friendly")
    var catfriendly: Int = 0

    @SerializedName("dog_friendly")
    var dogfriendly: Int = 0

    @SerializedName("stranger_friendly")
    var stranger: Int = 0

    @SerializedName("energy_level")
    var energylevel: Int = 0

    @SerializedName("health_issues")
    var health: Int = 0

    @SerializedName("wikipedia_url")
    var wikipediaUrl: String = ""

    override fun toString(): String {
        return String.format(
            "id: %s, name: %s, description: %s, " +
                    "lifespan: %s, origin: %s, wikipediaUrl: %s",
            id, name, description, lifespan, origin, wikipediaUrl
        )
    }
}
