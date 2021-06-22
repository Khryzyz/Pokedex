package com.chris.pokedex.ui.fragment.movements.adapter

import com.chris.pokedex.model.MoveBasicModel

interface ClickItemMove {
    fun onClickDialogDetail(moveBasicModel: MoveBasicModel)
}