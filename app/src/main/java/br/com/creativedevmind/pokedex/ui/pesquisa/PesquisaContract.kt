package br.com.creativedevmind.pokedex.ui.pesquisa

import br.com.creativedevmind.pokedex.domain.entity.Pokemon

interface PesquisaContract {

    interface PesquisaView {

        fun exibePokemon(pokemon: Pokemon?)
        fun exibeErro(mensagem: String?)

    }

    interface PesquisaPresenter {

        fun pesquisar(id: String)

    }

}