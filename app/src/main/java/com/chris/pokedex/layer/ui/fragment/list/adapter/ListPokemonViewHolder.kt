package com.chris.pokedex.layer.ui.fragment.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chris.pokedex.databinding.ItemListPokemonBinding
import com.chris.pokedex.layer.model.PokemonModel

class ListPokemonViewHolder
    (
    private val binding: ItemListPokemonBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(
            parent: ViewGroup
        ): ListPokemonViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemListPokemonBinding.inflate(
                layoutInflater,
                parent,
                false
            )
            return ListPokemonViewHolder(binding)
        }
    }

    fun bind(
        item: PokemonModel
    ) {

        binding.apply {

            pokemon = item

            executePendingBindings()
        }

    }

}