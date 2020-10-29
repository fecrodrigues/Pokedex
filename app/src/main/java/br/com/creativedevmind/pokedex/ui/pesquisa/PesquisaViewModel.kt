package br.com.creativedevmind.pokedex.ui.pesquisa

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.creativedevmind.pokedex.data.remote.api.APIService
import br.com.creativedevmind.pokedex.data.repository.PokemonRepositoryImpl
import br.com.creativedevmind.pokedex.domain.entity.Pokemon
import br.com.creativedevmind.pokedex.domain.repository.PokemonRepository

class PesquisaViewModel : ViewModel() {

    val pokemonResponse = MutableLiveData<Pokemon>()
    val mensagemErroResponse = MutableLiveData<String>()

    fun pesquisar(id: String) {
        val repository: PokemonRepository = PokemonRepositoryImpl(APIService.instance)

        repository.pesquisar(id,
            {
                pokemonResponse.value = it
            },
            {
                mensagemErroResponse.value = it.message
            }
        )
    }

}