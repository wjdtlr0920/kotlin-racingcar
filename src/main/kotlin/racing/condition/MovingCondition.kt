package racing.condition

import racing.util.RandomValueGenerator

class MovingCondition {

    companion object {
        const val LIMIT_VALUE = 4
    }

    fun canMove(): Boolean {
        val randomValue = RandomValueGenerator().getRandomValue()
        return randomValue >= LIMIT_VALUE
    }
}