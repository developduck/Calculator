package duck.develop.calculator.data.source.repository

import duck.develop.calculator.data.model.query.SelectKeyboardJoinKeyAll
import duck.develop.calculator.data.source.KeyboardDataSource
import io.reactivex.Single

/**
 * Created by Hwang on 2019-06-28.
 *
 * Description : 키를 포함하는 키보드 데이터에 대한 저장소(Repository)
 */
class KeyboardRepository(
    private val local: KeyboardDataSource,
    private val remote: KeyboardDataSource
): KeyboardDataSource {
    override fun getKeyboardVersion(id: Int): Single<Long> {
        return remote.getKeyboardVersion(id)
    }
    override fun getKeyboardJoinKeyAll(id: Int): Single<SelectKeyboardJoinKeyAll> {
        return remote.getKeyboardVersion(id)
            .flatMap { target ->
                local.getKeyboardVersion(id).map { current -> Pair(current, target) }
            }
            .flatMap { pair ->
                if (pair.first < pair.second) {
                    remote.getKeyboardJoinKeyAll(id)
                        .flatMap { local.insertOrUpdateKeyboardWithKeyAll(it) }
                } else {
                    local.getKeyboardJoinKeyAll(id)
                }
            }
    }
    override fun insertOrUpdateKeyboardWithKeyAll(query: SelectKeyboardJoinKeyAll): Single<SelectKeyboardJoinKeyAll> {
        return local.insertOrUpdateKeyboardWithKeyAll(query)
    }
}