package duck.develop.calculator.task.splash

import duck.develop.calculator.task.BasePresenter
import duck.develop.calculator.task.BaseView

/**
 * Created by Hwang on 2019-07-05.
 *
 * Description : Splash Contract
 */
interface SplashContract {
    interface View: BaseView {
        fun startCalculateActivity()
        fun showFailedToInitializeApp()
        fun showToast(message: String)
        fun close()
    }
    interface Presenter: BasePresenter {
        fun getConfig()
    }
}