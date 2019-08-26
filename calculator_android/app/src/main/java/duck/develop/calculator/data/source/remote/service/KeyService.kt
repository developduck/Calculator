package duck.develop.calculator.data.source.remote.service

import duck.develop.calculator.data.model.entity.Key
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Hwang on 2019-07-10.
 *
 * Description :
 */
interface KeyService {
    @GET("/key/{keyboard_id}/list")
    fun getKeys(@Path("keyboard_id") keyboard_id: Int): Single<List<Key>>
}