package duck.develop.calculator.data.source.remote.implement

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import duck.develop.calculator.BuildConfig
import duck.develop.calculator.data.model.Const
import duck.develop.calculator.data.source.remote.service.ConfigService
import io.reactivex.Completable

/**
 * Created by Hwang on 2019-08-14.
 *
 * Description : ConfigService 구현
 */
class ConfigServiceImpl(
    private val config: FirebaseRemoteConfig
): ConfigService {
    override fun getConfig(): Completable {
        return Completable.create { emitter ->
            config.apply {
                setConfigSettingsAsync(FirebaseRemoteConfigSettings
                    .Builder()
                    .setFetchTimeoutInSeconds(30L)
                    .setMinimumFetchIntervalInSeconds(if (BuildConfig.DEBUG) 0L else (5 * 60).toLong())
                    .build())
                fetchAndActivate().addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        emitter.onComplete()
                    } else {
                        task.exception?.let { emitter.onError(it) }
                    }
                }
            }
        }
    }
    override fun getWelcomeToAndroid(): String {
        return config.getString(getKey(Const.WELCOME_TO_ANDROID))
    }
    override fun getBaseUrl(): String {
        return config.getString(getKey(Const.BASE_URL))
    }
    private fun getKey(key: String): String {
        return if (BuildConfig.FLAVOR != "calculator") { "${BuildConfig.FLAVOR}_$key" } else { key }
    }
}