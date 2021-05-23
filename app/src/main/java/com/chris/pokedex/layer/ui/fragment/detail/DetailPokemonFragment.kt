package com.chris.pokedex.layer.ui.fragment.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.chris.pokedex.R
import com.chris.pokedex.databinding.DetailPokemonFragmentBinding
import com.chris.pokedex.layer.model.MessageModel
import com.chris.pokedex.layer.model.PokemonBasicModel
import com.chris.pokedex.layer.model.PokemonModel
import com.chris.pokedex.layer.ui.activity.MainActivity
import com.chris.pokedex.layer.ui.fragment.info.InfoPokemonFragment
import com.chris.pokedex.layer.ui.fragment.movements.MovementsPokemonFragment
import com.chris.pokedex.layer.ui.fragment.sprites.SpritesPokemonFragment
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.base.BaseViewBindingFragment
import com.chris.pokedex.utils.base.BaseViewPagerAdapter
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon
import com.google.android.material.tabs.TabLayoutMediator


class DetailPokemonFragment :
    BaseViewBindingFragment<DetailPokemonFragmentBinding>(DetailPokemonFragmentBinding::inflate) {

    private val viewModel: DetailPokemonViewModel by viewModels { viewModelFactory }

    private lateinit var pokemonModel: PokemonModel

    private lateinit var pokemonBasicModel: PokemonBasicModel

    private lateinit var viewPagerAdapter: BaseViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pokemonBasicModel =
                it.getSerializable(Constants.BundleKeys.POKEMON_BASIC) as PokemonBasicModel
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getDetailPokemon()
        setObservers()
    }

    private fun setTitle() {
        (activity as MainActivity).supportActionBar?.let { actionBar ->
            with(actionBar) {
                title = pokemonModel.name
            }
        }
    }

    private fun setViewPagerAdapter() {

        viewPagerAdapter = BaseViewPagerAdapter(requireActivity())

        val fragments = mutableListOf<Fragment>()

        fragments.add(InfoPokemonFragment.newInstance(pokemonModel))
        fragments.add(MovementsPokemonFragment.newInstance(pokemonModel))
        fragments.add(SpritesPokemonFragment.newInstance(pokemonModel))

        viewPagerAdapter.addFragments(fragments)

        binding.incDetailPokemon.viewPagerPokemon.adapter = viewPagerAdapter

        TabLayoutMediator(
            binding.incDetailPokemon.tabLayout,
            binding.incDetailPokemon.viewPagerPokemon
        ) { tab, position ->
            tab.text
            when (position) {
                0 -> tab.text = resources.getString(R.string.text_info)
                1 -> tab.text = resources.getString(R.string.text_movements)
                2 -> tab.text = resources.getString(R.string.text_sprites)
            }
        }.attach()

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

        this.pokemonModel = pokemonModel

        setViewPagerAdapter()

        setTitle()

        binding.vfDetailPokemon.displayedChild =
            binding.vfDetailPokemon.indexOfChild(binding.incDetailPokemon.cnlDetailLayout)

        binding.incDetailPokemon.apply {
            this.pokemonModel = pokemonModel
            executePendingBindings()
        }

        binding.incDetailPokemon.incDetailHeaderPokemon.executePendingBindings()
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
        binding.vfDetailPokemon.displayedChild =
            binding.vfDetailPokemon.indexOfChild(binding.incErrorLayout.cnlMessageLayout)
    }
//    findNavController().popBackStack(R.id.homeFragment, false)
}