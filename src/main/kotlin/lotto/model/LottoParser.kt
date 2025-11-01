package lotto.model

object LottoParser {
    fun money(input: String): Int =
        input.trim().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.")

    fun lottoNumbers(input: String): List<Int> =
        input.split(Regex("[,\\s]+"))
            .filter { it.isNotBlank() }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.") }

    fun bonusNumber(input: String): Int =
        input.trim().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.")
}