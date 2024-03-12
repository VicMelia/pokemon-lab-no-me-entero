package es.uji.al415395.pokeuji

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import es.uji.al415395.pokeuji.databinding.ActivityMainBinding
import models.Pokemon
import es.uji.al415395.pokeuji.PokemonView
import models.AbilityModel


class MainActivity : AppCompatActivity(), PokemonView {
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

            buttonAbilities.setOnClickListener {
                val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
                builder.setMessage("I am the message")
                builder.setTitle("I am the title")
                builder.setPositiveButton("Cerrar"){ dialog, which ->
                    //función cerrar
                }
                builder.setPositiveButton("No se"){ dialog, which ->
                    //función no se
                }

                builder.setTitle("Abilities")
                val dialog: AlertDialog = builder.create()
                dialog.show()

                //https://developer.android.com/develop/ui/views/components/dialogs

            }
            buttonTypes.setOnClickListener {
                //FUNCIÓN TIPOS
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.view = this
    }

    override fun onPause() {
        super.onPause()
        viewModel.view = null
    }

    override fun showPokemonData(pokemon: Pokemon) {
        pokemon.let {
            with (binding) {
                pokemonResult.text = it.name //he puesto esta linea para que salga el nombre arriba de la foto
                textSpecies.text = "Species: " + it.species.specie //it = pokemon
                textWeight.text = "Weight: " + (it.weight / 10f).toString()+" kg"
                textHeight.text = "Height: " + (it.height / 10f).toString()+" m"
            }
        }
    }

    override fun showAbilities(ability: List<AbilityModel>) {



    }

    override fun showSearchError(error: Throwable) {
        Toast.makeText(this, error.message ?: "Unknown error", Toast.LENGTH_LONG).show()
    }

    override fun showImage(pokemon: PokemonViewModel) {
        TODO("Not yet implemented")
    }
}