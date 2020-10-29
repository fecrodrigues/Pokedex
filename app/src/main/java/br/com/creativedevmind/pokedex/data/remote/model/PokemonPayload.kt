package br.com.creativedevmind.pokedex.data.remote.model

import com.google.gson.annotations.SerializedName

data class PokemonPayload(
    @SerializedName(value = "name") val nome: String,
    val sprites: Sprites
)

data class Sprites(
   @SerializedName(value = "front_default") val frontDefault: String,
    val other: SpritesOther
)

data class SpritesOther(
    @SerializedName(value = "dream_world") val dreamWorld: SpritesOtherDreamWorld,
    @SerializedName(value = "official_artwork") val officialArtwork: SpritesOtherOfficialArtwork
)

data class SpritesOtherDreamWorld(
    @SerializedName(value = "front_default") val frontDefault: String
)

data class SpritesOtherOfficialArtwork(
    @SerializedName(value = "front_default") val frontDefault: String
)