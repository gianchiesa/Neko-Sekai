package com.gianchiesamaghriza.nekosekai

import com.google.gson.annotations.SerializedName

class CatBreed {
    var id: String = ""
    var name: String = ""
    var description = ""

    @SerializedName("life_span")
    var lifespan: String = ""
    var origin: String = ""

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
