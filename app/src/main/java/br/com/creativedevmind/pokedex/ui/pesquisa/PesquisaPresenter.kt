package br.com.creativedevmind.pokedex.ui.pesquisa

import br.com.creativedevmind.pokedex.data.remote.api.APIService
import br.com.creativedevmind.pokedex.data.repository.PokemonRepositoryImpl
import br.com.creativedevmind.pokedex.domain.repository.PokemonRepository

class PesquisaPresenter(val pesquisaView: PesquisaContract.PesquisaView): PesquisaContract.PesquisaPresenter {

    override fun pesquisar(id: String) {
        val pokemonRepository: PokemonRepository = PokemonRepositoryImpl(APIService.instance)

        pokemonRepository.pesquisar(id,
            {
                pesquisaView.exibePokemon(it)
            },
            {
                pesquisaView.exibeErro(it.message)
            }
        )

    }


}