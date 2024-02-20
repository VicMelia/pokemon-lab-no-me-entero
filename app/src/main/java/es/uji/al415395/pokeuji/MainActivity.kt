package es.uji.al415395.pokeuji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import es.uji.al415395.pokeuji.databinding.ActivityMainBinding
import models.Pokemon

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding //con esto NO HACE FALTA crear CADA VARIABLE del layout: edit text, text view, etc.
    //lateinit var editText: EditText
    //lateinit var textView: TextView
    //lateinit var textView2: TextView
    //...

    val viewModel: PokemonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //vista = binding (te ahorras las variables del layout)

        with(binding){

            buttonSearch.setOnClickListener {
                viewModel.onPokemonSearchRequested(binding.pokemonName.text.toString())

            }

            buttonAbilites.setOnClickListener {
                //FUNCIÓN HABILIDADES
            }
            buttonTypes.setOnClickListener {
                //FUNCIÓN TIPOS
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.view = null
    }

    override fun onPause() {
        super.onPause()
        viewModel.view = null
    }



    fun showPokemonData(pokemon: Pokemon) {
        pokemon.let {
            with (binding) {
                nameTextView.text = it.name
                weightTextView.text = (it.weight / 10f).toString()+" kg"
                heightTextView.text = (it.height / 10f).toString()+" m"
            }
        }
    }

    fun showSearchError(error: Throwable) {
        Toast.makeText(this, error.message ?: "Unknown error", Toast.LENGTH_LONG).show()
    }
}