package com.chris.pokedex.layer.ui.fragment.tinder

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.fragment.app.viewModels
import com.chris.pokedex.R
import com.chris.pokedex.databinding.TinderPokemonFragmentBinding
import com.chris.pokedex.layer.model.MessageModel
import com.chris.pokedex.layer.model.PokemonModel
import com.chris.pokedex.layer.model.TinderCardPokemonModel
import com.chris.pokedex.layer.ui.activity.MainActivity
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.base.BaseViewBindingFragment
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon

class TinderPokemonFragment :
    BaseViewBindingFragment<TinderPokemonFragmentBinding>(TinderPokemonFragmentBinding::inflate) {

    private val viewModel: TinderPokemonViewModel by viewModels { viewModelFactory }

    private var pokemonModel: PokemonModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(viewModel)
        setObserver()
        setListener()
        (activity as MainActivity).supportActionBar?.let { actionBar ->
            with(actionBar) {
                title = resources.getString(R.string.tinder_label)
            }
        }
    }

    private fun setListener() {
        binding.incTinderLayout.mlyTinderPokemon.setTransitionListener(object :
            TransitionAdapter() {
            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                when (currentId) {
                    R.id.cnsRejectPokemonOffScreen,
                    R.id.cnsCatchPokemonOffScreen -> {
                        motionLayout.progress = 0f
                        motionLayout.setTransition(R.id.cnsInitialPosition, currentId)
                        viewModel.swipe(
                            if (currentId == R.id.cnsCatchPokemonOffScreen) Constants.TinderAction.CATCH
                            else Constants.TinderAction.REJECT,
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

        viewModel.tinderCardPokemonModel.observe(viewLifecycleOwner, {
            pokemonModel = it.topCardPokemon
            bindCard(it)
        })

    }

    private fun handlerProgress(progress: Int, total: Int, pokemonModel: PokemonModel) {
        if (binding.vfTinderPokemon.displayedChild == binding.vfTinderPokemon.indexOfChild(binding.incLoadLayout.cnlLoadLayout)) {

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
        binding.vfTinderPokemon.displayedChild =
            binding.vfTinderPokemon.indexOfChild(binding.incTinderLayout.mlyTinderPokemon)
        viewModel.updateCard()
    }

    private fun handlerLoad() {
        binding.vfTinderPokemon.displayedChild =
            binding.vfTinderPokemon.indexOfChild(binding.incLoadLayout.cnlLoadLayout)
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
        binding.vfTinderPokemon.displayedChild =
            binding.vfTinderPokemon.indexOfChild(binding.incErrorLayout.cnlMessageLayout)
    }

    private fun handlerEmpty() {
        binding.incEmptyLayout.apply {
            messageModel = MessageModel(
                messageType = Constants.MessageTypes.EMPTY,
                messageTitle = resources.getString(R.string.empty_tinder_title),
                messageText = resources.getString(R.string.empty_tinder_message),
                messageImage = R.mipmap.bg_pokemon_shop
            )
            animError.visibility = View.GONE
            executePendingBindings()
        }
        binding.vfTinderPokemon.displayedChild =
            binding.vfTinderPokemon.indexOfChild(binding.incEmptyLayout.cnlMessageLayout)
    }

    private fun bindCard(tinderCardPokemonModel: TinderCardPokemonModel) {
        if (tinderCardPokemonModel.topCardPokemon != null) {
            binding.incTinderLayout.topCardResume.apply {
                pokemonModel = tinderCardPokemonModel.topCardPokemon
            }
        }

        if (tinderCardPokemonModel.bottomCardPokemon != null) {
            binding.incTinderLayout.bottomCardResume.apply {
                pokemonModel = tinderCardPokemonModel.bottomCardPokemon
            }
        }

        if (tinderCardPokemonModel.topCardPokemon == null &&
            tinderCardPokemonModel.bottomCardPokemon == null
        )
            handlerEmpty()
    }

}