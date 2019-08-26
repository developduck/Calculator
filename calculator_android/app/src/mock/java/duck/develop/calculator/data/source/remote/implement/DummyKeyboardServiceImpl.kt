package duck.develop.calculator.data.source.remote.implement

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import duck.develop.calculator.data.model.Root
import duck.develop.calculator.data.model.entity.Keyboard
import duck.develop.calculator.data.model.query.SelectKeyboardJoinKeyAll
import duck.develop.calculator.data.source.remote.service.KeyboardService
import io.reactivex.Single

/**
 * Created by Hwang on 2019-07-25.
 *
 * Description :
 */
class DummyKeyboardServiceImpl: KeyboardService {
    override fun getKeyboard(id: Int): Single<Keyboard> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun getKeyboardJoinKeyAll(id: Int): Single<Root<SelectKeyboardJoinKeyAll>> {
        val dummyJson = "{\"data\":{\"id\":1,\"column_count\":4,\"keys\":[{\"id\":1,\"keyboard_id\":1,\"display\":\"CE\",\"order\":0},{\"id\":2,\"keyboard_id\":1,\"display\":\"C\",\"order\":1},{\"id\":3,\"keyboard_id\":1,\"display\":\"<\",\"order\":2},{\"id\":4,\"keyboard_id\":1,\"display\":\"/\",\"order\":3},{\"id\":5,\"keyboard_id\":1,\"display\":\"7\",\"order\":4}]}}"
        return Single.just(dummyJson)
            .map { Gson().fromJson(dummyJson, object: TypeToken<Root<SelectKeyboardJoinKeyAll>>() {}.type) as Root<SelectKeyboardJoinKeyAll> }
    }
}