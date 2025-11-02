package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoParserTest {
    @Test
    fun `구입 금액이 올바르지 않을 시 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            LottoParser.money("a")
        }
    }

    @Test
    fun `구입 금액 정상적인 숫자 입력 시 Int로 변환된다`() {
        val input = "5000"
        val result = LottoParser.money(input)
        assertEquals(5000, result)
    }

    @Test
    fun `올바른 구분자를 사용하지 않을 시 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            LottoParser.lottoNumbers("1'2'3'4'5'6")
        }
    }

    @Test
    fun `숫자 이외의 값 사용 시 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            LottoParser.lottoNumbers("1,2,3,4,5,a")
        }

        assertThrows<IllegalArgumentException> {
            LottoParser.lottoNumbers("")
        }

        assertThrows<IllegalArgumentException> {
            LottoParser.lottoNumbers(" ")
        }
    }

    @Test
    fun `입력된 보너스 번호가 숫자가 아닐 시 예외가 발생한다`(){
        assertThrows<IllegalArgumentException> {
            LottoParser.bonusNumber("a")
        }

        assertThrows<IllegalArgumentException> {
            LottoParser.bonusNumber(" ")
        }

        assertThrows<IllegalArgumentException> {
            LottoParser.bonusNumber("")
        }
    }
}