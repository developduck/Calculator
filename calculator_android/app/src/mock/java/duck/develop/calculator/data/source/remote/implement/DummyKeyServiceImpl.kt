package duck.develop.calculator.data.source.remote.implement

import duck.develop.calculator.data.model.entity.Key
import duck.develop.calculator.data.source.remote.service.KeyService
import io.reactivex.Single

/**
 * Created by Hwang on 2019-07-25.
 *
 * Description :
 */
class DummyKeyServiceImpl: KeyService {
    override fun getKeys(keyboard_id: Int): Single<List<Key>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}