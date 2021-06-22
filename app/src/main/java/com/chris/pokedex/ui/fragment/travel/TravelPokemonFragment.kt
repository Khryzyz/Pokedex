package com.chris.pokedex.ui.fragment.travel

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.fragment.app.viewModels
import com.chris.pokedex.R
import com.chris.pokedex.databinding.TravelPokemonFragmentBinding
import com.chris.pokedex.model.MessageModel
import com.chris.pokedex.model.PokemonModel
import com.chris.pokedex.model.TravelCardPokemonModel
import com.chris.pokedex.ui.activity.MainActivity
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.base.BaseViewBindingFragment
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon

class TravelPokemonFragment :
    BaseViewBindingFragment<TravelPokemonFragmentBinding>(TravelPokemonFragmentBinding::inflate) {

    private val viewModel: TravelPokemonViewModel by viewModels { viewModelFactory }

    private var pokemonModel: PokemonModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(viewModel)
        setObserver()
        setListener()
        (activity as MainActivity).supportActionBar?.let { actionBar ->
            with(actionBar) {
                title = resources.getString(R.string.label_pokemon_travel)
            }
        }
    }

    private fun setListener() {
        binding.incTravelLayout.mlyTravelPokemon.setTransitionListener(object :
            TransitionAdapter() {
            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                when (currentId) {
                    R.id.cnsRejectPokemonOffScreen,
                    R.id.cnsCatchPokemonOffScreen -> {
                        motionLayout.progress = 0f
                        motionLayout.setTransition(R.id.cnsInitialPosition, currentId)
                        viewModel.swipe(
                            if (currentId == R.id.cnsCatchPokemonOffScreen) Constants.TravelAction.CATCH
                            else Constants.TravelAction.REJECT,
                            pokemonModel
                        )
                    }
                }
            }
        })
    }

    private fun setObserver() {
        viewModel.pokemon.observe(viewLifecycleOwner, { state ->
            when (state) {
                is UIStateDetailPokemon.Loading -> handlerLoad()
                is UIStateDetailPokemon.Error -> handlerError(state.errorMessage)
                is UIStateDetailPokemon.Progress -> handlerProgress(
                    state.progress,
                    state.total,
                    state.pokemonModel
                )
                is UIStateDetailPokemon.Success -> Unit
            }
        })

        viewModel.listDetailPokemon.observe(viewLifecycleOwner, { list ->
            if (list != null && list.size == 0) {
                handlerEmpty()
            }
        })

        viewModel.travelCardPokemonModel.observe(viewLifecycleOwner, {
            pokemonModel = it.topCardPokemon
            bindCard(it)
        })

    }

    private fun handlerProgress(progress: Int, total: Int, pokemonModel: PokemonModel) {
        if (binding.vfTravelPokemon.displayedChild == binding.vfTravelPokemon.indexOfChild(binding.incLoadLayout.cnlLoadLayout)) {

            val percent = progress * 100 / total

            binding.incLoadLayout.lpiLoadPokemon.apply {
                visibility = View.VISIBLE
                setProgress(percent)
            }

            binding.incLoadLayout.txvLoadPokemon.apply {
                visibility = View.VISIBLE
                text = context?.getString(R.string.text_loading, progress, total)
            }

            viewModel.addItemListPokemonDetail(pokemonModel)

            if (percent == 100)
                handlerFinish()
        }

    }

    private fun handlerFinish() {
        binding.vfTravelPokemon.displayedChild =
            binding.vfTravelPokemon.indexOfChild(binding.incTravelLayout.mlyTravelPokemon)
        viewModel.updateCard()
    }

    private fun handlerLoad() {
        binding.vfTravelPokemon.displayedChild =
            binding.vfTravelPokemon.indexOfChild(binding.incLoadLayout.cnlLoadLayout)
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
        binding.vfTravelPokemon.displayedChild =
            binding.vfTravelPokemon.indexOfChild(binding.incErrorLayout.cnlMessageLayout)
    }

    private fun handlerEmpty() {
        binding.incEmptyLayout.apply {
            messageModel = MessageModel(
                messageType = Constants.MessageTypes.EMPTY,
                messageTitle = resources.getString(R.string.empty_travel_title),
                messageText = resources.getString(R.string.empty_travel_message),
                messageImage = R.mipmap.bg_pokemon_shop
            )
            animError.visibility = View.GONE
            executePendingBindings()
        }
        binding.vfTravelPokemon.displayedChild =
            binding.vfTravelPokemon.indexOfChild(binding.incEmptyLayout.cnlMessageLayout)
    }

    private fun bindCard(travelCardPokemonModel: TravelCardPokemonModel) {
        if (travelCardPokemonModel.topCardPokemon != null) {
            binding.incTravelLayout.topCardResume.apply {
                pokemonModel = travelCardPokemonModel.topCardPokemon
            }
        }

        if (travelCardPokemonModel.bottomCardPokemon != null) {
            binding.incTravelLayout.bottomCardResume.apply {
                pokemonModel = travelCardPokemonModel.bottomCardPokemon
            }
        }

        if (travelCardPokemonModel.topCardPokemon == null &&
            travelCardPokemonModel.bottomCardPokemon == null
        )
            handlerEmpty()
    }

}