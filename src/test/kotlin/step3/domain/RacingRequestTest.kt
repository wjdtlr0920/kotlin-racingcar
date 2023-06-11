package step3.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

internal class RacingRequestTest {
    @ParameterizedTest
    @ValueSource(ints = [0, -1, -2])
    internal fun `시도 횟수에 0 이하의 값은 허용되지 않는다`(value: Int) {
        assertThatThrownBy { RacingRequest(carNames = listOf("car1"), attemptCount = value) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    internal fun `자동차의 이름은 빈값이 아니여야 한다`() {
        assertThatThrownBy { RacingRequest(carNames = listOf(), attemptCount = 1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    internal fun `자동차의 이름은 5자리 까지 허용된다`() {
        assertThatThrownBy { RacingRequest(carNames = listOf("car1", "car123"), attemptCount = 1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}