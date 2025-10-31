package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto

class LottoView {
    fun getMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return Console.readLine().toInt()
    }

    fun getLottoNumbers(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        return Console.readLine().split(",").map { it.toInt() }
    }

    fun getBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        return Console.readLine().toInt()
    }

    fun printLottoList(lottoList: List<Lotto>) {
        println("${lottoList.size}개를 구매했습니다.")
        for (lotto in lottoList) { println(lotto) }
    }
}