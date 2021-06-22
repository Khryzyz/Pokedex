package com.chris.pokedex.repository.dialog.move

import com.chris.pokedex.model.MoveBasicModel
import com.chris.pokedex.utils.uiState.UIStateDetailMove
import kotlinx.coroutines.flow.Flow

interface MoveRepository {
    suspend fun getDetailMove(moveBasicModel: MoveBasicModel): Flow<UIStateDetailMove>
}