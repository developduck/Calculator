package duck.develop.calculator.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Hwang on 2019-07-25.
 *
 * Description : 데이터를 감싸는 최상위 클래스 (주로 네트워크에서 사용됨)
 */
@Parcelize data class Root<out DATA: Parcelable>(
    val code: Int,
    val message: String? = null,
    val data: DATA
): Parcelable