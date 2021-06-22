package com.chris.pokedex.ui.fragment.info

import android.os.Bundle
import android.view.View
import com.chris.pokedex.databinding.InfoPokemonFragmentBinding
import com.chris.pokedex.model.PokemonModel
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.base.BaseViewBindingFragment

class InfoPokemonFragment :
    BaseViewBindingFragment<InfoPokemonFragmentBinding>(InfoPokemonFragmentBinding::inflate) {

    companion object {
        fun newInstance(pokemonModel: PokemonModel) = InfoPokemonFragment().apply {
            arguments = Bundle().apply {
                putSerializable(Constants.BundleKeys.POKEMON_DETAIL, pokemonModel)
            }
        }
    }

    private lateinit var pokemonModel: PokemonModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pokemonModel =
                it.getSerializable(Constants.BundleKeys.POKEMON_DETAIL) as PokemonModel
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.pokemonModel = pokemonModel
    }

}