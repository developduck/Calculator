package duck.develop.calendar

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CalendarServerApplication

fun main(args: Array<String>) {
    runApplication<CalendarServerApplication>(*args)
}
