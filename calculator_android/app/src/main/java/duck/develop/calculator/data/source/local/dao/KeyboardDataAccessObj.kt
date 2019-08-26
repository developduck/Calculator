package duck.develop.calculator.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import duck.develop.calculator.data.model.entity.Key
import duck.develop.calculator.data.model.entity.Keyboard
import duck.develop.calculator.data.model.query.SelectKeyboardJoinKeyAll
import io.reactivex.Maybe
import io.reactivex.Single

/**
 * Created by Hwang on 2019-06-28.
 *
 * Description : 키보드 관련 DAO
 */
@Dao
interface KeyboardDataAccessObj: RelationDataAccessObj<Keyboard, Key> {
    @Query("SELECT * FROM keyboard WHERE id = :id")
    fun getKeyboard(id: Int): Single<Keyboard>
    @Query("SELECT * FROM keyboard")
    fun getKeyboards(): Single<List<Keyboard>>
    @Transaction
    @Query("SELECT version FROM keyboard WHERE id = :id")
    fun getKeyboardVersion(id: Int): Maybe<Long>
    @Transaction
    @Query("SELECT * FROM keyboard WHERE id = :id")
    fun getKeyboardJoinKeyAll(id: Int): Single<SelectKeyboardJoinKeyAll>
}