package com.chris.pokedex.layer.ui.fragment.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chris.pokedex.databinding.ItemListPokemonBinding
import com.chris.pokedex.layer.model.PokemonBasicModel

class ListPokemonViewHolder(private val binding: ItemListPokemonBinding) :
    RecyclerView.ViewHolder(binding.root) {

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
        item: PokemonBasicModel,
        clickListener: ClickItemPokemon
    ) {
        binding.apply {
            pokemonBasicModel = item
            clickItemPokemon = clickListener
            executePendingBindings()
        }
    }

}