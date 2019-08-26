package duck.develop.calculator.data.source.local

import duck.develop.calculator.data.model.entity.Keyboard
import duck.develop.calculator.data.model.query.SelectKeyboardJoinKeyAll
import duck.develop.calculator.data.source.KeyboardDataSource
import duck.develop.calculator.data.source.local.dao.KeyboardDataAccessObj
import io.reactivex.Single

/**
 * Created by Hwang on 2019-06-28.
 *
 * Description : 키보드 관련 Local Source
 */
class KeyboardLocalDataSource(
    private val dao: KeyboardDataAccessObj
): KeyboardDataSource {
    override fun getKeyboardVersion(id: Int): Single<Long> {
        return dao.getKeyboardVersion(id)
            .switchIfEmpty(Single.just(0L))
    }
    override fun getKeyboardJoinKeyAll(id: Int): Single<SelectKeyboardJoinKeyAll> {
        return dao.getKeyboardJoinKeyAll(id)
    }
    override fun insertOrUpdateKeyboardWithKeyAll(query: SelectKeyboardJoinKeyAll): Single<SelectKeyboardJoinKeyAll> {
        return Single.just(dao).map {
            it.insert(Keyboard(query), query.keys)
            return@map query
        }
    }
}