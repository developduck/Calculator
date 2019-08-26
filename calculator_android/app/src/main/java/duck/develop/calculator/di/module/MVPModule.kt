package duck.develop.calculator.di.module

import android.os.Bundle
import duck.develop.calculator.di.MVP.WITH_BUNDLE
import duck.develop.calculator.di.Repository.CONFIG_REPOSITORY
import duck.develop.calculator.di.Repository.KEYBOARD_REPOSITORY
import duck.develop.calculator.di.named
import duck.develop.calculator.task.DefaultFragment
import duck.develop.calculator.task.calculate.CalculateContract
import duck.develop.calculator.task.calculate.CalculatePresenter
import duck.develop.calculator.task.splash.SplashContract
import duck.develop.calculator.task.splash.SplashPresenter
import org.koin.dsl.module

/**
 * Created by Hwang on 2019-07-04.
 *
 * Description : MVP 모듈
 */
val mvp = module {
    factory { (clazz: Class<DefaultFragment>) -> clazz.newInstance() }
    factory(named(WITH_BUNDLE)) { (clazz: Class<DefaultFragment>, params: Bundle?) ->
        clazz.newInstance().apply { params?.let { arguments = it } }
    }

    factory<CalculateContract.Presenter> { CalculatePresenter(get(named(KEYBOARD_REPOSITORY)), get()) }
    factory<SplashContract.Presenter> { SplashPresenter(get(named(CONFIG_REPOSITORY)), get()) }
}