package lotto.controller

import lotto.Lotto
import lotto.model.LottoGame
import lotto.model.LottoParser
import lotto.model.LottoRank
import lotto.model.ValidationCheck
import lotto.view.LottoView

class LottoController(
    private val view: LottoView = LottoView()
) {
    fun run() {
        val validatedAmount = getValidateMoney()
        val lottoNumbers = getValidateLottoNumbers()
        val bonusNumber = getValidateBonusNumber(lottoNumbers)
        val lottoList = LottoGame.generateLotto(validatedAmount)

        view.printLottoList(lottoList)
        val results = lottoList.map {
            val matchCount = it.getSortedNumbers().count { num -> num in lottoNumbers.getSortedNumbers() }
            val bonusMatch = bonusNumber in it.getSortedNumbers()
            LottoRank.of(matchCount, bonusMatch)
        }
        view.printWinningResult(results)
        view.printProfitRate(results, validatedAmount * 1000)
    }

    private fun getValidateMoney(): Int {
        while (true) {
            try {
                val money = view.getMoney().let(LottoParser::money)
                return ValidationCheck.isValidMoneyAmount(money)
            } catch (e: IllegalArgumentException) {
                println(e.message ?: "[ERROR] 잘못된 입력입니다.")
            }
        }
    }

    private fun getValidateLottoNumbers(): Lotto {
        while (true) {
            try {
                val lottoNumbers = view.getLottoNumbers().let(LottoParser::lottoNumbers)
                return Lotto.of(lottoNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message ?: "[ERROR] 잘못된 입력입니다.")
            }
        }
    }

    private fun getValidateBonusNumber(main: Lotto): Int {
        while (true) {
            try {
                val bonusNumber = view.getBonusNumber().let(LottoParser::bonusNumber)
                return ValidationCheck.isValidBonusNumber(bonusNumber, main.getSortedNumbers().toSet())
            } catch (e: IllegalArgumentException) {
                println(e.message ?: "[ERROR] 잘못된 입력입니다.")
            }
        }
    }
}