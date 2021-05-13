package com.chris.pokedex.layer.ui.fragment.movements.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chris.pokedex.databinding.ItemListMoveBinding
import com.chris.pokedex.layer.model.MoveModel

class ListMoveViewHolder(private val binding: ItemListMoveBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): ListMoveViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemListMoveBinding.inflate(
                layoutInflater,
                parent,
                false
            )
            return ListMoveViewHolder(binding)
        }
    }

    fun bind(
        item: MoveModel,
        clickListener: ClickItemMove
    ) {
        binding.apply {
            moveModel = item
            clickItemMove = clickListener
            executePendingBindings()
        }
    }

}