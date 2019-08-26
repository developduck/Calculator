package duck.develop.calculator.task.calculate

import duck.develop.calculator.data.model.entity.Key
import duck.develop.calculator.data.model.query.SelectKeyboardJoinKeyAll
import duck.develop.calculator.data.source.KeyboardDataSource
import duck.develop.calculator.runner.ImmediateSchedulerProvider
import duck.develop.calculator.runner.SchedulerProvider
import io.reactivex.Single
import io.reactivex.internal.functions.Functions
import io.reactivex.plugins.RxJavaPlugins
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.then
import org.mockito.Mockito.*

/**
 * Created by Hwang on 2019-07-08.
 *
 * Description : CalculatePresenter 테스트
 */
class CalculatePresenterTest {
    private lateinit var presenter: CalculateContract.Presenter
    private lateinit var view: CalculateContract.View
    private lateinit var dataSource: KeyboardDataSource
    private lateinit var scheduler: SchedulerProvider

    @Before fun before() {
        RxJavaPlugins.setErrorHandler(Functions.emptyConsumer())

        scheduler = ImmediateSchedulerProvider()
        dataSource = mock(KeyboardDataSource::class.java)
        view = mock(CalculateContract.View::class.java)
        presenter = CalculatePresenter(dataSource, scheduler)
        presenter.attach(view)
    }
    @After fun after() {
        presenter.detach()
    }
    @Test fun loadKeyboardTest() {
        //Data : 데이터
        val dummy: SelectKeyboardJoinKeyAll = SelectKeyboardJoinKeyAll(1, 5).apply {
            keys = listOf(Key(1, 1, "CE", "ce", 0))
        }

        //Given : 상황(Case)
        doReturn(Single.just(dummy))
            .`when`(dataSource)
            .getKeyboardJoinKeyAll(eq(1))

        //When : 로직(Logic)
        presenter.loadKeyboard(1080, 1920)

        //Then : 검증(Verify)
        then(view).should().apply {
            setColumnCount(dummy.column_count)
            dummy.keys.withIndex().forEach {
                showKey(it.index, it.value)
            }
        }
    }
}