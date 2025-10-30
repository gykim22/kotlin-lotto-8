package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoGame {
    fun generateLotto(count: Int): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()

        repeat(count) {
            lottoList.add(Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
        }

        return lottoList
    }
}