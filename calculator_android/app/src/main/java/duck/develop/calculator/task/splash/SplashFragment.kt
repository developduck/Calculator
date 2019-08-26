package duck.develop.calculator.task.splash

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import duck.develop.calculator.R
import duck.develop.calculator.manager.CommonDialog
import duck.develop.calculator.task.DefaultFragment
import duck.develop.calculator.task.calculate.CalculateActivity
import org.koin.android.ext.android.inject

/**
 * Created by Hwang on 2019-07-05.
 *
 * Description : Splash View / 로고 출력
 */
class SplashFragment: DefaultFragment(), SplashContract.View {
    private val presenter by inject<SplashContract.Presenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attach(this)
        presenter.getConfig()
    }
    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }
    override fun startCalculateActivity() {
        startActivity(Intent(activity, CalculateActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
        activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
    override fun showFailedToInitializeApp() {
        activity?.let {
            CommonDialog.with(it, R.string.guide_failed_to_initialize_app).run {
                onPositive = { presenter.getConfig() }
                onNegative = { it.finish() }
                build()
            }.showRetryOrCancel()
        }
    }
    override fun showToast(message: String) {
        activity?.run {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
    override fun close() {
        activity?.finish()
    }
}