package com.chris.pokedex.layer.ui.fragment.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.chris.pokedex.databinding.DetailPokemonFragmentBinding
import com.chris.pokedex.layer.model.PokemonBasicModel
import com.chris.pokedex.layer.model.PokemonModel
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.base.BaseViewBindingFragment
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon

class DetailPokemonFragment :
    BaseViewBindingFragment<DetailPokemonFragmentBinding>(DetailPokemonFragmentBinding::inflate) {

    private val viewModel: DetailPokemonViewModel by viewModels { viewModelFactory }

    private lateinit var pokemonBasicModel: PokemonBasicModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pokemonBasicModel =
                it.getSerializable(Constants.BundleKeys.POKEMON) as PokemonBasicModel
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getDetailPokemon()
        setObservers()
    }

    private fun getDetailPokemon() {
        viewModel.getDetailPokemon(pokemonBasicModel)
    }

    private fun setObservers() {
        viewModel.pokemon.observe(viewLifecycleOwner, { state ->
            when (state) {
                is UIStateDetailPokemon.Loading -> handlerLoading()
                is UIStateDetailPokemon.Success -> handlerSuccess(state.data)
                is UIStateDetailPokemon.Error -> handlerError(state.errorMessage)
            }
        })
    }

    private fun handlerLoading() {
        binding.vfDetailPokemon.displayedChild =
            binding.vfDetailPokemon.indexOfChild(binding.incLoadLayout.cnlLoadLayout)
    }

    private fun handlerSuccess(pokemonModel: PokemonModel) {
        binding.vfDetailPokemon.displayedChild =
            binding.vfDetailPokemon.indexOfChild(binding.incDetailPokemon.cnlDetailLayout)
        binding.incDetailPokemon.apply {
            this.pokemonModel = pokemonModel
            executePendingBindings()
        }
    }

    private fun handlerError(errorMessage: String) {
        binding.incErrorLayout.txvErrorMessage.text = errorMessage
        binding.vfDetailPokemon.displayedChild =
            binding.vfDetailPokemon.indexOfChild(binding.incErrorLayout.cnlErrorLayout)
    }

}