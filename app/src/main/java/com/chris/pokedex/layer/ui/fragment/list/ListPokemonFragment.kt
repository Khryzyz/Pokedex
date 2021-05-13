package com.chris.pokedex.layer.ui.fragment.list

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.chris.pokedex.R
import com.chris.pokedex.databinding.ListPokemonFragmentBinding
import com.chris.pokedex.layer.model.PokemonBasicModel
import com.chris.pokedex.layer.ui.fragment.list.adapter.ClickItemPokemon
import com.chris.pokedex.layer.ui.fragment.list.adapter.ListPokemonAdapter
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.base.BaseViewBindingFragment
import com.chris.pokedex.utils.uiState.UIStateListPokemon

class ListPokemonFragment :
    BaseViewBindingFragment<ListPokemonFragmentBinding>(ListPokemonFragmentBinding::inflate) {

    private val viewModel: ListPokemonViewModel by viewModels { viewModelFactory }

    private lateinit var adapter: ListPokemonAdapter

    private var generation: Constants.Generation = Constants.Generation.FIRST

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            generation = it.getSerializable(Constants.BundleKeys.GENERATION) as Constants.Generation
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        getListPokemon()
        setAdapter()
        setObservers()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_top_actions, menu)
    }

    private fun getListPokemon() {
        viewModel.getListPokemon(generation)
    }

    private fun setAdapter() {
        adapter = ListPokemonAdapter(clickItemPokemon)
        binding.rcwListPokemon.adapter = adapter

    }

    private fun setObservers() {

        viewModel.generation.observe(viewLifecycleOwner, { state ->
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
        adapter.submitList(listPokemonModel)
        binding.vfListPokemon.displayedChild =
            binding.vfListPokemon.indexOfChild(binding.rcwListPokemon)
    }

    private fun handlerError(errorMessage: String) {
        binding.incErrorLayout.txvErrorMessage.text = errorMessage
        binding.vfListPokemon.displayedChild =
            binding.vfListPokemon.indexOfChild(binding.incErrorLayout.cnlErrorLayout)
    }

    private fun handlerProgressDownload(progress: Int, total: Int) {
        if (binding.vfListPokemon.displayedChild == binding.vfListPokemon.indexOfChild(binding.incLoadLayout.cnlLoadLayout)) {
            val percent = progress * 100 / total
            binding.incLoadLayout.lpiLoadPokemon.apply {
                visibility = View.VISIBLE
                setProgress(percent)
            }

            binding.incLoadLayout.txvLoadPokemon.apply {
                visibility = View.VISIBLE
                text = context?.getString(R.string.text_loading, progress, total)
            }
        }
    }

    //region Listeners
    private var clickItemPokemon = object : ClickItemPokemon {
        override fun onClickNavigateDetail(pokemonBasicModel: PokemonBasicModel) {
            findNavController().navigate(
                R.id.detailPokemonFragment,
                Bundle().apply {
                    putSerializable(
                        Constants.BundleKeys.POKEMON_ID,
                        pokemonBasicModel
                    )
                }
            )
        }
    }
    //endregion
}