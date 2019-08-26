package duck.develop.calculator.data.source.remote

import duck.develop.calculator.data.model.entity.Key
import duck.develop.calculator.data.source.KeyDataSource
import duck.develop.calculator.data.source.remote.service.KeyService
import duck.develop.calculator.exception.UnimplementedFunctionException
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Hwang on 2019-07-10.
 *
 * Description : 키 관련 Local Source
 */
class KeyRemoteDataSource(
    private val service: KeyService
): KeyDataSource {
    override fun getKey(id: Int): Single<Key> {
        throw UnimplementedFunctionException()
    }
    override fun getKeys(keyboardId: Int): Single<List<Key>> {
        return service.getKeys(keyboardId)
    }
    override fun insert(keys: List<Key>): Completable {
        throw UnimplementedFunctionException()
    }
}