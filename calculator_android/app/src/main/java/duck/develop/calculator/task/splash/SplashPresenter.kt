package duck.develop.calculator.task.splash

import duck.develop.calculator.data.source.ConfigDataSource
import duck.develop.calculator.extensions.zip
import duck.develop.calculator.runner.SchedulerProvider
import duck.develop.calculator.task.BaseView
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import java.util.concurrent.TimeUnit

/**
 * Created by Hwang on 2019-07-05.
 *
 * Description : Splash Presenter / 앱 데이터 초기화
 */
class SplashPresenter(
    private val configRepository: ConfigDataSource,
    private val scheduler: SchedulerProvider
): SplashContract.Presenter {
    private lateinit var view: SplashContract.View
    private lateinit var disposable: CompositeDisposable

    override fun attach(view: BaseView) {
        this.view = view as SplashContract.View
        this.disposable = CompositeDisposable()
    }
    override fun detach() {
        this.disposable.clear()
    }
    override fun getConfig() {
        configRepository.getConfig()
            .subscribe({
                initialize()
                view.showToast(configRepository.getWelcomeToAndroid())
            }, {
                view.showFailedToInitializeApp()
            }).let {
                disposable.add(it)
            }
    }

    private fun initialize() {
        ArrayList<Single<out Any>>().run {
            //Splash 최소 시간 설정
            add(Single.timer(1500, TimeUnit.MILLISECONDS))
            return@run zip { Unit }
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribe(Consumer {
                    view.startCalculateActivity()
                })
        }.let {
            disposable.add(it)
        }
    }
}