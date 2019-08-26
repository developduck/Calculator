package duck.develop.calculator.data.source.remote.service

import io.reactivex.Completable

/**
 * Created by Hwang on 2019-08-14.
 *
 * Description :
 */
interface ConfigService {
    fun getConfig(): Completable
    fun getWelcomeToAndroid(): String
    fun getBaseUrl(): String
}