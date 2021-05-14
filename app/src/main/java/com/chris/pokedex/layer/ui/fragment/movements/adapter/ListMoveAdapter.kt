package com.chris.pokedex.layer.ui.fragment.movements.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.chris.pokedex.layer.model.MoveBasicModel

class ListMoveAdapter(private val clickItemMove: ClickItemMove) :
    ListAdapter<MoveBasicModel, ListMoveViewHolder>(MoveBasicModel.DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMoveViewHolder {
        return ListMoveViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ListMoveViewHolder, position: Int) {
        val move = getItem(position)
        holder.bind(
            move,
            clickItemMove
        )
    }

}