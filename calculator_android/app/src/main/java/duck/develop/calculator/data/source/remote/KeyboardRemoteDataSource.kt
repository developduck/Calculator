package duck.develop.calculator.data.source.remote

import duck.develop.calculator.data.model.query.SelectKeyboardJoinKeyAll
import duck.develop.calculator.data.source.KeyboardDataSource
import duck.develop.calculator.data.source.remote.service.KeyboardService
import duck.develop.calculator.exception.UnimplementedFunctionException
import io.reactivex.Single

/**
 * Created by Hwang on 2019-07-01.
 *
 * Description : 키보드 관련 Remote Source
 */
class KeyboardRemoteDataSource(
    private val service: KeyboardService
): KeyboardDataSource {
    override fun getKeyboardVersion(id: Int): Single<Long> {
        return service.getKeyboardVersion(id)
            .map { it.data.version }
    }
    override fun getKeyboardJoinKeyAll(id: Int): Single<SelectKeyboardJoinKeyAll> {
        return service.getKeyboardJoinKeyAll(id)
            .map { it.data }
    }
    override fun insertOrUpdateKeyboardWithKeyAll(query: SelectKeyboardJoinKeyAll): Single<SelectKeyboardJoinKeyAll> {
        throw UnimplementedFunctionException()
    }
}