package duck.develop.calculator.task

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

/**
 * Created by Hwang on 2019-06-28.
 *
 * Description :
 */
fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, @IdRes resId: Int) {
    supportFragmentManager.transact {
        replace(resId, fragment)
    }
}
fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply(action).commit()
}
@SuppressLint("Registered")
open class DefaultActivity: AppCompatActivity()