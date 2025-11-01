package lotto.controller

import lotto.model.LottoGame
import lotto.model.LottoRank
import lotto.view.LottoView
import lotto.view.ValidationCheck

class LottoController {
    fun run() {
        val validatedAmount = ValidationCheck().isValidMoneyAmount()
        val lottoNumbers = ValidationCheck().isValidLottoNumber()
        val bonusNumber = ValidationCheck().isValidBonusNumber(lottoNumbers)
        val lottoList = LottoGame.generateLotto(validatedAmount)

        LottoView().printLottoList(lottoList)
        val results = lottoList.map {
            val matchCount = it.getSortedNumbers().count { num -> num in lottoNumbers.getSortedNumbers() }
            val bonusMatch = bonusNumber in it.getSortedNumbers()
            LottoRank.of(matchCount, bonusMatch)
        }
        LottoView().printWinningResult(results)
        LottoView().printProfitRate(results, validatedAmount * 1000)
    }
}