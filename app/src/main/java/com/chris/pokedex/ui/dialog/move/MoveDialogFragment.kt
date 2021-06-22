package com.chris.pokedex.ui.dialog.move

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import com.chris.pokedex.R
import com.chris.pokedex.databinding.MoveDialogFragmentBinding
import com.chris.pokedex.model.MessageModel
import com.chris.pokedex.model.MoveBasicModel
import com.chris.pokedex.model.MoveModel
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
        binding.incDetailMove.btnCloseDialog.setOnClickListener {
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
        binding.vfDetailMove.displayedChild =
            binding.vfDetailMove.indexOfChild(binding.incLoadLayout.cnlLoadLayout)
    }

    private fun handlerSuccess(moveModel: MoveModel) {
        binding.vfDetailMove.displayedChild =
            binding.vfDetailMove.indexOfChild(binding.incDetailMove.lnlContainerMove)
        binding.incDetailMove.moveModel = moveModel
        binding.incDetailMove.executePendingBindings()
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
        binding.vfDetailMove.displayedChild =
            binding.vfDetailMove.indexOfChild(binding.incErrorLayout.cnlMessageLayout)
    }

}
