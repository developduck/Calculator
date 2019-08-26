package duck.develop.calculator.data.source.local

import duck.develop.calculator.data.model.entity.Key
import duck.develop.calculator.data.source.KeyDataSource
import duck.develop.calculator.data.source.local.dao.KeyDataAccessObj
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Hwang on 2019-06-28.
 *
 * Description : 키 관련 Local Source
 */
class KeyLocalDataSource(
    private val dao: KeyDataAccessObj
): KeyDataSource {
    override fun getKey(id: Int): Single<Key> {
        return dao.getKey(id)
    }
    override fun getKeys(keyboardId: Int): Single<List<Key>> {
        return dao.getKeys(keyboardId)
    }
    override fun insert(keys: List<Key>): Completable {
        return Completable.fromSingle(Single.just(dao).map {
            it.insert(keys)
        })
    }
}