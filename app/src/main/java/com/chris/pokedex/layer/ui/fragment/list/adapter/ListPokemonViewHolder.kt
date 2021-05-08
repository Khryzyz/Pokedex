package com.chris.pokedex.layer.ui.fragment.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chris.pokedex.databinding.ItemListPokemonBinding
import com.chris.pokedex.layer.model.PokemonBasicModel
import com.chris.pokedex.utils.Constants

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
        item: PokemonBasicModel
    ) {

        binding.apply {

            pokemon = item

            val urlSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/${item.id}.gif"

//            val urlSprite = when (item.generation) {
//                Constants.Generation.FIRST.id -> "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/${item.id}.png"
//                Constants.Generation.SECOND.id -> "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/${item.id}.png"
//                Constants.Generation.THIRD.id -> "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/emerald/${item.id}.png"
//                Constants.Generation.FOURTH.id -> "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/diamond-pearl/${item.id}.png"
//                else -> "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white//${item.id}.png"
//            }

            Glide.with(itemView.context).load(urlSprite).into(imvSprite);

            executePendingBindings()
        }

    }

}