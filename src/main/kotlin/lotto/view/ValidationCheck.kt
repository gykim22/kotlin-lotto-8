package lotto.view

import lotto.Lotto

class ValidationCheck {
    fun isValidMoneyAmount(): Int {
        while (true) {
            try {
                val money = LottoView().getMoney()
                require(money % 1000 == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }
                require(money >= 1000) { "[ERROR] 구입 금액은 1000원 이상 자연수여야 합니다." }
                return money / 1000
            } catch (e: NumberFormatException) {
                println("[ERROR] 올바른 문자 형식으로 입력해주세요.")
            } catch (e: IllegalArgumentException) {
                println(e.message ?: "[ERROR] 잘못된 입력입니다.")
            }
        }
    }

    fun isValidLottoNumber(): Lotto {
        while (true) {
            try {
                val lottoNumbers = LottoView().getLottoNumbers()
                return Lotto(lottoNumbers)
            } catch (e: NumberFormatException) {
                println("[ERROR] 올바른 문자 형식으로 입력해주세요.")
            } catch (e: IllegalArgumentException) {
                println(e.message ?: "[ERROR] 잘못된 입력입니다.")
            }
        }
    }

    fun isValidBonusNumber(lotto: Lotto): Int {
        while (true) {
            try {
                val bonusNumber = LottoView().getBonusNumber()
                require(bonusNumber in 1..45) { "[ERROR] 로또 번호는 1부터 45 사이여야 합니다." }
                require(bonusNumber !in lotto.getSortedNumbers()) { "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다." }
                return bonusNumber
            } catch (e: NumberFormatException) {
                println("[ERROR] 올바른 문자 형식으로 입력해주세요.")
            } catch (e: IllegalArgumentException) {
                println(e.message ?: "[ERROR] 잘못된 입력입니다.")
            }
        }

    }
}