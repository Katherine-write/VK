fun main() {
    val result = feeCalculation("Мир")

    println(result)
}

fun feeCalculation(
    cardType: String,
    transition: Int = 75_000,
    transitionPerMonth: Int = 0,
    transitionPerDay: Int = 0
): Int {

    val maxTransitionPerMonth = 600_000
    val maxTransitionPerDay = 150_000

    if (transitionPerMonth + transition > maxTransitionPerMonth || transitionPerDay + transition > maxTransitionPerDay) {
        println("Перевод недоступен")
        return -1
    }

    return when (cardType) {

        "MasterCard", "Maestro" -> {
            when {
                (transitionPerMonth + transition) > 75_000 ->
                    (((transitionPerMonth + transition) - 75_000) / 100 * 0.6 + 20).toInt()

                300 > (transitionPerMonth + transition) ->
                    (transition / 100 * 0.6 + 20).toInt()
                else -> 0
            }
        }

        "Visa", "Мир" -> {
            val fee = (transition / 100 * 0.75)
            val minFee = 35
            if (fee > minFee) fee.toInt() else minFee
        }

        "VKPay" -> when {
            (transitionPerMonth + transition) <= 60_000 && (transitionPerDay + transition) <= 15_000 -> 0
            else -> -1
        }

        else -> -1
    }
}