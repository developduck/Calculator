package duck.develop.calculator.data.source

import duck.develop.calculator.data.model.entity.Key
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Hwang on 2019-06-28.
 *
 * Description : 키 데이터 인터페이스
 */
interface KeyDataSource {
    fun getKey(id: Int): Single<Key>
    fun getKeys(keyboardId: Int): Single<List<Key>>
    fun insert(keys: List<Key>): Completable
}