package br.com.creativedevmind.pokedex.ui.pesquisa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.creativedevmind.pokedex.R
import br.com.creativedevmind.pokedex.data.remote.api.APIService
import br.com.creativedevmind.pokedex.data.repository.PokemonRepositoryImpl
import br.com.creativedevmind.pokedex.domain.repository.PokemonRepository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btPesquisar
import kotlinx.android.synthetic.main.activity_pesquisa.*

class PesquisaActivity : AppCompatActivity() {

    private lateinit var pokemonRepository: PokemonRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)

        pokemonRepository = PokemonRepositoryImpl(APIService.instance)

        btPesquisar.setOnClickListener {

            pokemonRepository.pesquisar(etPokemon.text.toString(),
                {
                    tvNomePokemon.text = it?.nome
                    Picasso.get().load(it?.urlImagem).into(ivPokemon)
                },
                {
                    Toast.makeText(this@PesquisaActivity, "Pokémon não encotrando", Toast.LENGTH_SHORT).show()
                }
            )

            //tvNomePokemon.text
            //
        }
    }
}