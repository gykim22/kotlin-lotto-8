package lotto.model

import lotto.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoGameTest {
    @Test
    fun `입력된 금액에 따른 개수만큼의 로또가 생성된다`() {
        val expectedCount = 5
        val lottos: List<Lotto> = LottoGame.generateLotto(expectedCount)

        assertEquals(expectedCount, lottos.size, "생성된 로또의 개수가 입력 금액에 따른 개수와 일치하지 않습니다.")
    }

    @Test
    fun `생성된 각 로또는 고유한 6개의 번호를 가져야 한다`() {
        val count = 2
        val lottos: List<Lotto> = LottoGame.generateLotto(count)

        lottos.forEach { lotto ->
            val numbers = lotto.getSortedNumbers()
            assertEquals(6, numbers.size, "각 로또는 6개의 번호를 가져야 합니다.")
            assertTrue(numbers.all { it in 1..45 }, "로또 번호는 1부터 45 사이여야 합니다.")
            assertEquals(6, numbers.toSet().size, "로또 번호는 중복되지 않아야 합니다.")
        }
    }
}