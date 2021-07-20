package com.chris.pokedex.source.remote.dataSource.move

import com.chris.pokedex.model.MoveBasicModel
import com.chris.pokedex.source.remote.Api
import com.chris.pokedex.utils.toModel
import com.chris.pokedex.utils.uiState.UIStateDetailMove
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoveRemoteDataSourceImp
@Inject constructor(
    private val api: Api
) : MoveRemoteDataSource {

    override suspend fun getDetailMove(moveBasicModel: MoveBasicModel): Flow<UIStateDetailMove> {
        return flow {
            emit(UIStateDetailMove.Loading)
            val response = api.getDetailMove(moveBasicModel.id)
            if (response.isSuccessful) {
                response.body()?.let { moveResDTO ->
                    emit(UIStateDetailMove.Success(moveResDTO.toModel()))
                }
            } else {
                emit(UIStateDetailMove.Error(response.errorBody().toString()))
            }
        }.catch {
            emit(UIStateDetailMove.Error(it.message.toString()))
        }
    }
}