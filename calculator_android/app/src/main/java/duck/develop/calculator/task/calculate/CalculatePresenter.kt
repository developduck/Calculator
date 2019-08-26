package duck.develop.calculator.task.calculate

import duck.develop.calculator.data.source.KeyboardDataSource
import duck.develop.calculator.exception.handler.errorHandler
import duck.develop.calculator.runner.SchedulerProvider
import duck.develop.calculator.task.BaseView
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Hwang on 2019-06-28.
 *
 * Description : Calculate Presenter / 키보드 불러오기 및 계산기 처리 로직
 */
class CalculatePresenter(
    private val repository: KeyboardDataSource,
    private val scheduler: SchedulerProvider
): CalculateContract.Presenter {
    private lateinit var view: CalculateContract.View
    private lateinit var disposable: CompositeDisposable

    override fun attach(view: BaseView) {
        this.view = view as CalculateContract.View
        this.disposable = CompositeDisposable()
    }
    override fun detach() {
        this.disposable.clear()
    }

    override fun loadKeyboard(width: Int, height: Int) {
        repository.getKeyboardJoinKeyAll(1)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribe({ keyboard ->
                view.setColumnCount(keyboard.column_count)
                keyboard.keys.withIndex().forEach {
                    it.value.width = width / keyboard.column_count
                    it.value.height = height / ((keyboard.keys.size / keyboard.column_count)
                            + (keyboard.keys.size % keyboard.column_count))
                    view.showKey(it.index, it.value)
                }
            }, errorHandler {
                view.showRetryOrCancel(message = it, onRetry = {
                    loadKeyboard(width, height)
                })
            }).let {
                disposable.add(it)
            }
    }
}