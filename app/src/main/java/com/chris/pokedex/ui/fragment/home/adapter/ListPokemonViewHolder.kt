package com.chris.pokedex.ui.fragment.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chris.pokedex.databinding.ItemListPokemonBinding
import com.chris.pokedex.model.PokemonBasicModel

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