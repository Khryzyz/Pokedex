package com.chris.pokedex.layer.ui.fragment.movements

import android.os.Bundle
import android.view.View
import com.chris.pokedex.databinding.MovementsPokemonFragmentBinding
import com.chris.pokedex.layer.model.MoveBasicModel
import com.chris.pokedex.layer.model.PokemonModel
import com.chris.pokedex.layer.ui.dialog.move.MoveDialogFragment
import com.chris.pokedex.layer.ui.fragment.movements.adapter.ClickItemMove
import com.chris.pokedex.layer.ui.fragment.movements.adapter.ListMoveAdapter
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.base.BaseViewBindingFragment

class MovementsPokemonFragment :
    BaseViewBindingFragment<MovementsPokemonFragmentBinding>(MovementsPokemonFragmentBinding::inflate) {

    companion object {
        fun newInstance(pokemonModel: PokemonModel) = MovementsPokemonFragment().apply {
            arguments = Bundle().apply {
                putSerializable(Constants.BundleKeys.POKEMON_DETAIL, pokemonModel)
            }
        }
    }

    private lateinit var pokemonModel: PokemonModel

    private lateinit var adapter: ListMoveAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pokemonModel =
                it.getSerializable(Constants.BundleKeys.POKEMON_DETAIL) as PokemonModel
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setAdapter()
        adapter.submitList(pokemonModel.moveBasics)
    }

    private fun setAdapter() {
        adapter = ListMoveAdapter(clickItemMove)
        binding.rcwListMove.adapter = adapter

    }

    //region Listeners
    private var clickItemMove = object : ClickItemMove {
        override fun onClickDialogDetail(moveBasicModel: MoveBasicModel) {
            MoveDialogFragment.newInstance(moveBasicModel).show(childFragmentManager, "MoveDialog")
        }
    }
    //endregion

}