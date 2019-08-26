package duck.develop.calculator.task.calculate

import android.os.Bundle
import duck.develop.calculator.R
import duck.develop.calculator.di.MVP
import duck.develop.calculator.di.named
import duck.develop.calculator.task.DefaultActivity
import duck.develop.calculator.task.DefaultFragment
import duck.develop.calculator.task.replaceFragmentInActivity
import org.koin.android.ext.android.get
import org.koin.core.parameter.parametersOf

class CalculateActivity : DefaultActivity() {
    private lateinit var view: DefaultFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_bar)

        view = supportFragmentManager.findFragmentById(R.id.content) as CalculateFragment?
            ?: get<DefaultFragment>(named(MVP.WITH_BUNDLE)) { parametersOf(CalculateFragment::class.java, intent.extras) }
                .also { replaceFragmentInActivity(it, R.id.content) }
    }
}
