package com.chris.pokedex.layer.repository.dialog.move

import com.chris.pokedex.layer.model.MoveBasicModel
import com.chris.pokedex.utils.uiState.UIStateDetailMove
import kotlinx.coroutines.flow.Flow

interface MoveRepository {
    suspend fun getDetailMove(moveBasicModel: MoveBasicModel): Flow<UIStateDetailMove>
}