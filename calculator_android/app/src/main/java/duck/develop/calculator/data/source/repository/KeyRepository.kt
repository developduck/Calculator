package duck.develop.calculator.data.source.repository

import duck.develop.calculator.data.model.entity.Key
import duck.develop.calculator.data.source.KeyDataSource
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Hwang on 2019-06-28.
 *
 * Description : 키보드를 참조하는 키 데이터에 대한 저장소(Repository)
 */
class KeyRepository(
    private val local: KeyDataSource,
    private val remote: KeyDataSource
): KeyDataSource {
    override fun getKey(id: Int): Single<Key> {
        return local.getKey(id)
    }
    override fun getKeys(keyboardId: Int): Single<List<Key>> {
        return local.getKeys(keyboardId)
    }
    override fun insert(keys: List<Key>): Completable {
        return local.insert(keys)
    }
}