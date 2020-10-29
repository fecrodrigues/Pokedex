package br.com.creativedevmind.pokedex.ui.pesquisa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.creativedevmind.pokedex.R
import br.com.creativedevmind.pokedex.domain.entity.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btPesquisar
import kotlinx.android.synthetic.main.activity_pesquisa.*

class PesquisaActivity : AppCompatActivity(), PesquisaContract.PesquisaView {

    private lateinit var pesquisaPresenter: PesquisaPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)

        pesquisaPresenter = PesquisaPresenter(this)

        btPesquisar.setOnClickListener {
            pesquisaPresenter.pesquisar(etPokemon.text.toString())
        }
    }

    override fun exibePokemon(pokemon: Pokemon?) {
        tvNomePokemon.text = pokemon?.nome
        Picasso.get().load(pokemon?.urlImagem).into(ivPokemon)
    }

    override fun exibeErro(mensagem: String?) {
        Toast.makeText(this@PesquisaActivity, mensagem ,Toast.LENGTH_SHORT).show()
    }
}