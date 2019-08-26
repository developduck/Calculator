package duck.develop.calculator.task.calculate

import duck.develop.calculator.data.model.entity.Key
import duck.develop.calculator.task.BasePresenter
import duck.develop.calculator.task.BaseView

/**
 * Created by Hwang on 2019-06-28.
 *
 * Description : Calculate Contract
 */
interface CalculateContract {
    interface View: BaseView {
        fun setColumnCount(cnt: Int)
        fun showKey(i: Int, key: Key)
    }
    interface Presenter: BasePresenter {
        fun loadKeyboard(width: Int, height: Int)
    }
}