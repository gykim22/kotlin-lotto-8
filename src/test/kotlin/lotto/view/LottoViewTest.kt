package lotto.view

import lotto.model.LottoRank
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class LottoViewTest {
    private val view = LottoView()
    private val standardOut = System.out
    private val standardIn = System.`in`
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
        System.setIn(standardIn)
    }

    private fun input(input: String) {
        val inputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)
    }

    @Test
    fun `안내 메시지를 출력하고 사용자 입력을 반환한다`() {
        val expectedInput = "7"
        input(expectedInput)
        val expectedOutput = "보너스 번호를 입력해 주세요."
        val actualInput = view.getBonusNumber()

        assertEquals(expectedInput, actualInput)
        assertTrue(outputStreamCaptor.toString().contains(expectedOutput))
    }

    @Test
    fun `총 수익률을 소수점 첫째 자리까지 출력한다`() {
        val results = List(7) { LottoRank.LOSES } + LottoRank.FIFTH
        val money = 8000
        val expectedOutput = "총 수익률은 62.5%입니다."

        view.printProfitRate(results, money)
        assertTrue(outputStreamCaptor.toString().contains(expectedOutput))
    }

    @Test
    fun `정수도 소수점 첫째 자리까지 출력한다`() {
        val results = List(8) { LottoRank.LOSES } + LottoRank.FIFTH + LottoRank.FIFTH
        val money = 10000
        val expectedOutput = "총 수익률은 100.0%입니다."

        view.printProfitRate(results, money)
        assertTrue(outputStreamCaptor.toString().contains(expectedOutput))
    }
}