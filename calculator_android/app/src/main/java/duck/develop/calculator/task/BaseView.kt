package duck.develop.calculator.task

/**
 * Created by Hwang on 2019-06-28.
 *
 * Description : Base View
 */
interface BaseView {
    fun showRetryOrCancel(title: String? = null, message: String, onRetry: () -> Unit, onCancel: (() -> Unit)? = null)
}