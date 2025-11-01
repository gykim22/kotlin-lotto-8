package lotto.model

object ValidationCheck {
    fun isValidMoneyAmount(money: Int): Int {
        require(money >= 1000) { "[ERROR] 구입 금액은 1000원 이상 자연수여야 합니다." }
        require(money % 1000 == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }
        return money / 1000
    }

    fun isValidLottoNumber(lottoNumber: List<Int>): List<Int> {
        require(lottoNumber.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(lottoNumber.distinct().size == 6) { "[ERROR] 로또 번호는 중복될 수 없습니다." }
        require(lottoNumber.all { it in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이여야 합니다." }
        return lottoNumber
    }

    fun isValidBonusNumber(bonus: Int, lottoNumber: Set<Int>): Int {
        require(bonus in 1..45) { "[ERROR] 로또 번호는 1부터 45 사이여야 합니다." }
        require(bonus !in lottoNumber) { "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다." }
        return bonus
    }
}