package duck.develop.calculator.runner

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * Created by Hwang on 2019-07-08.
 *
 * Description : 테스트를 진행하기 위해서는 동기식 처리 방식으로 진행할 필요성이 있음
 *               예를들어 로직이 모두 수행되고 데이터 또는 처리 과정이 모두 반영된 후
 *               검증 단계를 수행해야함, 하지만 비동기식에서는 그 순서가 보장되지 않음
 *               따라서 스케줄러를 trampoline()으로 넘기게 되면 동기식 처리를 함.
 */
class ImmediateSchedulerProvider: SchedulerProvider {
    override fun computation(): Scheduler {
        return Schedulers.trampoline()
    }
    override fun io(): Scheduler {
        return Schedulers.trampoline()
    }
    override fun ui(): Scheduler {
        return Schedulers.trampoline()
    }
}