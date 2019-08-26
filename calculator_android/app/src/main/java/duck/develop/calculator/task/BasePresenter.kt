package duck.develop.calculator.task

/**
 * Created by Hwang on 2019-06-28.
 *
 * Description : Base Presenter
 */
interface BasePresenter {
    fun attach(view: BaseView)
    fun detach()
}