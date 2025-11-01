package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import lotto.model.LottoRank

class LottoView {
    fun getMoney(): String {
        println("구입금액을 입력해 주세요.")
        return Console.readLine()
    }

    fun getLottoNumbers(): String {
        println("당첨 번호를 입력해 주세요.")
        return Console.readLine()
    }

    fun getBonusNumber(): String {
        println("보너스 번호를 입력해 주세요.")
        return Console.readLine()
    }

    fun printLottoList(lottoList: List<Lotto>) {
        println("${lottoList.size}개를 구매했습니다.")
        for (lotto in lottoList) {
            println(lotto.getSortedNumbers())
        }
    }

    fun printWinningResult(results: List<LottoRank>) {
        println("당첨 통계\n---")
        LottoRank.entries
            .filter { it != LottoRank.LOSES }
            .forEach { rank ->
                val count = results.count { it == rank }
                val label = when (rank) {
                    LottoRank.FIRST -> "6개 일치"
                    LottoRank.SECOND -> "5개 일치, 보너스 볼 일치"
                    LottoRank.THIRD -> "5개 일치"
                    LottoRank.FOURTH -> "4개 일치"
                    else -> "3개 일치"
                }
                println("$label (${String.format("%,d", rank.prize)}원) - ${count}개")
            }
    }

    fun printProfitRate(results: List<LottoRank>, money: Int) {
        val totalProfitRate = results.sumOf { it.prize }
        println("총 수익률은 %.1f".format(totalProfitRate.toDouble() / money * 100) + "%입니다.")
    }
}
