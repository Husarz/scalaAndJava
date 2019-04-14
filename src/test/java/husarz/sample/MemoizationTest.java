package husarz.sample;

import io.vavr.Function1;
import io.vavr.control.Try;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;

import static java.util.Objects.isNull;

public class MemoizationTest {


    @Test
    public void memoTest() {
        memoization();
    }

    void memoization() {

        lazyCalculateWithSec(2);
        printInstantTime();

        lazyCalculateWithSec(2);
        printInstantTime();

        lazyCalculateWithSec(3);
        printInstantTime();

        lazyCalculateWithSec(2);
        printInstantTime();
    }

    private Integer lazyCalculateWithSec(int sec) {
        return lazyFunctionCalculate().apply(sec);
    }

    private void printInstantTime() {
        System.out.println(getInstant());
    }

    private Instant getInstant() {
        return clock.instant();
    }

    private Function1<Integer, Integer> lazyFunctionCalculate() {
        return calculate = isNull(calculate)
                ? toMemoizedMethod()
                : calculate;
    }

    private Function1<Integer, Integer> toMemoizedMethod() {
        return Function1.of(this::callExpensiveMethod).memoized();
    }

    private Integer callExpensiveMethod(Integer number) {
        return Try.of(() -> sleep(number))
                .getOrElseThrow(this::getNoSleepException);
    }

    private RuntimeException getNoSleepException() {
        return new RuntimeException("no sleep exception");
    }

    private Integer sleep(Integer sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
        return sec;
    }

    private Function1<Integer, Integer> calculate;
    private final Clock clock = Clock.systemDefaultZone();
}
