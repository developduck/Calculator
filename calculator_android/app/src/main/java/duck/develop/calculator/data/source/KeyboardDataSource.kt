package duck.develop.calculator.data.source

import duck.develop.calculator.data.model.query.SelectKeyboardJoinKeyAll
import io.reactivex.Single

/**
 * Created by Hwang on 2019-06-28.
 *
 * Description : 키보드 데이터 인터페이스
 */
interface KeyboardDataSource {
    fun getKeyboardVersion(id: Int): Single<Long>
    fun getKeyboardJoinKeyAll(id: Int): Single<SelectKeyboardJoinKeyAll>
    fun insertOrUpdateKeyboardWithKeyAll(query: SelectKeyboardJoinKeyAll): Single<SelectKeyboardJoinKeyAll>
}