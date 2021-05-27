package com.chris.pokedex.layer.ui.fragment.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.chris.pokedex.R
import com.chris.pokedex.databinding.HomePokemonFragmentBinding
import com.chris.pokedex.layer.model.MessageModel
import com.chris.pokedex.layer.model.PokemonBasicModel
import com.chris.pokedex.layer.ui.fragment.home.adapter.ClickItemPokemon
import com.chris.pokedex.layer.ui.fragment.home.adapter.ListPokemonAdapter
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.base.BaseViewBindingFragment
import com.chris.pokedex.utils.uiState.UIStateListPokemon

class HomePokemonFragment :
    BaseViewBindingFragment<HomePokemonFragmentBinding>(HomePokemonFragmentBinding::inflate) {

    private val viewModel: HomePokemonViewModel by viewModels { viewModelFactory }

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
        setObserver()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_top_actions, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.travelPokemon -> {
                findNavController().navigate(R.id.travelPokemonFragment)
                true
            }
            R.id.catchPokemon -> {
                findNavController().navigate(R.id.catchPokemonFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getListPokemon() {
        viewModel.getListPokemon(generation)
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
        adapter.submitList(listPokemonModel)
        binding.vfListPokemon.displayedChild =
            binding.vfListPokemon.indexOfChild(binding.rcwListPokemon)
    }

    private fun handlerError(errorMessage: String) {
        binding.incErrorLayout.apply {
            messageModel = MessageModel(
                messageType = Constants.MessageTypes.ERROR,
                messageTitle = resources.getString(R.string.error_title),
                messageText = errorMessage,
                messageImage = R.mipmap.bg_digglet_cave
            )
            executePendingBindings()
        }
        binding.vfListPokemon.displayedChild =
            binding.vfListPokemon.indexOfChild(binding.incErrorLayout.cnlMessageLayout)
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