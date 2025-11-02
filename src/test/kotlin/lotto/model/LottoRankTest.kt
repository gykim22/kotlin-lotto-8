package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `당첨 조건에 해당하지 않으면 LOSES가 반환된다`() {
        val count = 1
        val bonus = false
        val actualRank = LottoRank.of(count, bonus)

        assertEquals(LottoRank.LOSES, actualRank)
    }

    @Test
    fun `3개를 맞추면 5등에 당첨된다`() {
        val count = 3
        val bonus = false
        val actualRank = LottoRank.of(count, bonus)

        assertEquals(LottoRank.FIFTH, actualRank)
    }

    @Test
    fun `4개를 맞추면 4등에 당첨된다`() {
        val count = 4
        val bonus = false
        val actualRank = LottoRank.of(count, bonus)

        assertEquals(LottoRank.FOURTH, actualRank)
    }

    @Test
    fun `5개를 맞추면 3등에 당첨된다`() {
        val count = 5
        val bonus = false
        val actualRank = LottoRank.of(count, bonus)

        assertEquals(LottoRank.THIRD, actualRank)
    }

    @Test
    fun `5개 번호 및 보너스 번호를 맞추면 2등에 당첨된다`() {
        val count = 5
        val bonus = true
        val actualRank = LottoRank.of(count, bonus)

        assertEquals(LottoRank.SECOND, actualRank)
    }

    @Test
    fun `6개를 모두 맞추면 1등에 당첨된다`() {
        val count = 6
        val bonus = false
        val actualRank = LottoRank.of(count, bonus)

        assertEquals(LottoRank.FIRST, actualRank)
    }
}