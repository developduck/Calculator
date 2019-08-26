package duck.develop.calculator.task

import androidx.fragment.app.Fragment
import duck.develop.calculator.R
import duck.develop.calculator.manager.CommonDialog

/**
 * Created by Hwang on 2019-06-28.
 *
 * Description : 공통 처리를 위한 Default View
 */
open class DefaultFragment: Fragment(), BaseView {
    override fun showRetryOrCancel(title: String?, message: String,
                                   onRetry: () -> Unit, onCancel: (() -> Unit)?) {
        context?.let {
            CommonDialog.with(it, R.string.guide_failed_to_initialize_app).run {
                onPositive = onRetry
                onNegative = onCancel
                build()
            }.showRetryOrCancel()
        }
    }
}