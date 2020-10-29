package br.com.creativedevmind.pokedex.domain.repository

import br.com.creativedevmind.pokedex.domain.entity.Pokemon

interface PokemonRepository {

    fun pesquisar(
        id: String,
        onComplete: (Pokemon?) -> Unit,
        onError: (Throwable) -> Unit
    )

}