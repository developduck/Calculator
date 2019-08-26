package duck.develop.calculator.task.splash

import android.content.Intent
import android.os.Bundle
import duck.develop.calculator.R
import duck.develop.calculator.di.MVP
import duck.develop.calculator.di.named
import duck.develop.calculator.task.BaseView
import duck.develop.calculator.task.DefaultActivity
import duck.develop.calculator.task.DefaultFragment
import duck.develop.calculator.task.replaceFragmentInActivity
import org.koin.android.ext.android.get
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

/**
 * Created by Hwang on 2019-07-05.
 *
 * Description : Splash Activity / Activity는 View(Fragment)를 감싸기만하는 역할로 변경
 */
class SplashActivity: DefaultActivity() {
    private lateinit var view: DefaultFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen)

        view = supportFragmentManager.findFragmentById(R.id.content) as SplashFragment?
            ?: get<DefaultFragment> { parametersOf(SplashFragment::class.java) }
                .also { replaceFragmentInActivity(it, R.id.content) }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        view.onActivityResult(requestCode, resultCode, data)
    }
}