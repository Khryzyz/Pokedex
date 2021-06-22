package com.chris.pokedex.repository.dialog.move

import com.chris.pokedex.model.MoveBasicModel
import com.chris.pokedex.source.remote.dataSource.move.MoveRemoteDataSource
import com.chris.pokedex.utils.uiState.UIStateDetailMove
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoveRepositoryImp
@Inject constructor(
    private val remoteDataSource: MoveRemoteDataSource
) : MoveRepository {
    override suspend fun getDetailMove(moveBasicModel: MoveBasicModel): Flow<UIStateDetailMove> {
        return remoteDataSource.getDetailMove(moveBasicModel)
    }
}