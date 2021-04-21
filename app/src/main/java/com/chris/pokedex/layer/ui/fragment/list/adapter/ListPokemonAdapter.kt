package com.chris.pokedex.layer.ui.fragment.list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.chris.pokedex.layer.model.PokemonModel

class ListPokemonAdapter :
    ListAdapter<PokemonModel,
            ListPokemonViewHolder>(PokemonModel.DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPokemonViewHolder {
        return ListPokemonViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ListPokemonViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(
            pokemon
        )
    }

}