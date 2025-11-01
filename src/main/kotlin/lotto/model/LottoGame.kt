package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoGame {
    fun generateLotto(count: Int): List<Lotto> {
        return List(count) { Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)) }
    }
}