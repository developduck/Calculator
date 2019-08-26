package duck.develop.calculator.data.source

import io.reactivex.Completable

/**
 * Created by Hwang on 2019-08-14.
 *
 * Description : 앱 환경설정 데이터 인터페이스
 */
interface ConfigDataSource {
    fun getConfig(): Completable
    fun getWelcomeToAndroid(): String
    fun getBaseUrl(): String
}