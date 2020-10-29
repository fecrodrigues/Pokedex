package br.com.creativedevmind.pokedex.data.remote.mapper

import br.com.creativedevmind.pokedex.data.remote.model.PokemonPayload
import br.com.creativedevmind.pokedex.domain.entity.Pokemon

object PokemonPayloadMapper {

    fun map(pokemon: PokemonPayload) = Pokemon(
        nome = pokemon.nome,
        urlImagem = pokemon.sprites.other.officialArtwork.frontDefault
    )

    fun map(pokemons: List<PokemonPayload>) = pokemons.map { map(it) }

}