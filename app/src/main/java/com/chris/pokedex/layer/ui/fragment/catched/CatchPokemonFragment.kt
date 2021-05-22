package com.chris.pokedex.layer.ui.fragment.catched

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.chris.pokedex.R
import com.chris.pokedex.databinding.CatchPokemonFragmentBinding
import com.chris.pokedex.layer.model.PokemonBasicModel
import com.chris.pokedex.layer.ui.activity.MainActivity
import com.chris.pokedex.layer.ui.fragment.home.adapter.ClickItemPokemon
import com.chris.pokedex.layer.ui.fragment.home.adapter.ListPokemonAdapter
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.base.BaseViewBindingFragment
import com.chris.pokedex.utils.uiState.UIStateListPokemon

class CatchPokemonFragment :
    BaseViewBindingFragment<CatchPokemonFragmentBinding>(CatchPokemonFragmentBinding::inflate) {

    private val viewModel: CatchPokemonViewModel by viewModels { viewModelFactory }

    private lateinit var adapter: ListPokemonAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getListPokemon()
        setAdapter()
        setObserver()
        (activity as MainActivity).supportActionBar?.let { actionBar ->
            with(actionBar) {
                title = resources.getString(R.string.catch_label)
            }
        }
    }

    private fun getListPokemon() {
        viewModel.getListPokemon()
    }

    private fun setAdapter() {
        adapter = ListPokemonAdapter(clickItemPokemon)
        binding.rcwListPokemon.adapter = adapter
    }

    private fun setObserver() {
        viewModel.listPokemon.observe(viewLifecycleOwner, { state ->
            when (state) {
                is UIStateListPokemon.Loading -> handlerLoad()
                is UIStateListPokemon.Success -> handlerSuccess(state.data)
                is UIStateListPokemon.Error -> handlerError(state.errorMessage)
            }
        })
    }

    private fun handlerLoad() {
        binding.vfListPokemon.displayedChild =
            binding.vfListPokemon.indexOfChild(binding.incLoadLayout.cnlLoadLayout)
    }

    private fun handlerSuccess(listPokemonModel: List<PokemonBasicModel>) {
        if (listPokemonModel.isNotEmpty()) {
            adapter.submitList(listPokemonModel)
            binding.vfListPokemon.displayedChild =
                binding.vfListPokemon.indexOfChild(binding.rcwListPokemon)
        } else {
            binding.vfListPokemon.displayedChild =
                binding.vfListPokemon.indexOfChild(binding.incEmptyLayout.cnlEmptyLayout)
        }
    }

    private fun handlerError(errorMessage: String) {
        binding.incErrorLayout.txvErrorMessage.text = errorMessage
        binding.vfListPokemon.displayedChild =
            binding.vfListPokemon.indexOfChild(binding.incErrorLayout.cnlErrorLayout)
    }

    //region Listeners
    private var clickItemPokemon = object : ClickItemPokemon {
        override fun onClickNavigateDetail(pokemonBasicModel: PokemonBasicModel) {
            findNavController().navigate(
                R.id.detailPokemonFragment,
                Bundle().apply {
                    putSerializable(
                        Constants.BundleKeys.POKEMON_BASIC,
                        pokemonBasicModel
                    )
                }
            )
        }
    }
    //endregion
}