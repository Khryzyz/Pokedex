package com.chris.pokedex.layer.ui.dialog.move

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import com.chris.pokedex.R
import com.chris.pokedex.databinding.MoveDialogFragmentBinding
import com.chris.pokedex.layer.model.MoveBasicModel
import com.chris.pokedex.layer.model.MoveModel
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.base.BaseViewBindingDialogFragment
import com.chris.pokedex.utils.uiState.UIStateDetailMove

class MoveDialogFragment :
    BaseViewBindingDialogFragment<MoveDialogFragmentBinding>(MoveDialogFragmentBinding::inflate) {

    companion object {
        fun newInstance(moveBasicModel: MoveBasicModel) = MoveDialogFragment().apply {
            arguments = Bundle().apply {
                putSerializable(Constants.BundleKeys.MOVE_BASIC, moveBasicModel)
            }
        }
    }


    private lateinit var moveBasicModel: MoveBasicModel

    private val viewModel: MoveViewModel by activityViewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            moveBasicModel =
                it.getSerializable(Constants.BundleKeys.MOVE_BASIC) as MoveBasicModel
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.let {
            it.attributes.windowAnimations = R.style.DialogAnimation
            it.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }
        getDetailMove()
        setObservers()
        binding.btnCloseDialog.setOnClickListener {
            dismiss()
        }
    }

    private fun getDetailMove() {
        viewModel.getDetailMove(moveBasicModel)
    }

    private fun setObservers() {
        viewModel.move.observe(viewLifecycleOwner, { state ->
            when (state) {
                is UIStateDetailMove.Loading -> handlerLoading()
                is UIStateDetailMove.Success -> handlerSuccess(state.data)
                is UIStateDetailMove.Error -> handlerError(state.errorMessage)
            }
        })
    }

    private fun handlerLoading() {
        //TODO: Cargando
    }

    private fun handlerSuccess(moveModel: MoveModel) {
        binding.moveModel = moveModel
        binding.executePendingBindings()
    }

    private fun handlerError(errorMessage: String) {
        //TODO: Error
    }

}
