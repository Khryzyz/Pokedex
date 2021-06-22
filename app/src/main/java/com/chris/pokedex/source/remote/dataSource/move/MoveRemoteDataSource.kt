package com.chris.pokedex.source.remote.dataSource.move

import com.chris.pokedex.model.MoveBasicModel
import com.chris.pokedex.utils.uiState.UIStateDetailMove
import kotlinx.coroutines.flow.Flow

interface MoveRemoteDataSource {
    suspend fun getDetailMove(moveBasicModel: MoveBasicModel): Flow<UIStateDetailMove>
}