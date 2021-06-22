package com.chris.pokedex.ui.fragment.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.chris.pokedex.model.PokemonBasicModel

class ListPokemonAdapter(private val clickItemPokemon: ClickItemPokemon) :
    ListAdapter<PokemonBasicModel, ListPokemonViewHolder>(PokemonBasicModel.DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPokemonViewHolder {
        return ListPokemonViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ListPokemonViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(
            pokemon,
            clickItemPokemon
        )
    }

}