package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidationCheckTest {
    @Test
    fun `로또 금액이 올바르지 않을 시 예외가 발생한다`() {
        assertEquals(5, ValidationCheck.isValidMoneyAmount(5000))

        assertThrows<IllegalArgumentException> {
            ValidationCheck.isValidMoneyAmount(1900)
        }

        assertThrows<IllegalArgumentException> {
            ValidationCheck.isValidMoneyAmount(-1900)
        }

        assertThrows<IllegalArgumentException> {
            ValidationCheck.isValidMoneyAmount(900)
        }

        assertThrows<IllegalArgumentException> {
            ValidationCheck.isValidMoneyAmount(0)
        }
    }

    @Test
    fun `당첨번호가 올바르지 않을 시 예외가 발생한다`() {
        assertEquals(
            listOf(1, 2, 3, 4, 5, 6), ValidationCheck.isValidLottoNumber(listOf(1, 2, 3, 4, 5, 6))
        )

        assertThrows<IllegalArgumentException> {
            ValidationCheck.isValidLottoNumber(listOf(1))
        }

        assertThrows<IllegalArgumentException> {
            ValidationCheck.isValidLottoNumber(listOf(1, 2, 3, 4, 5))
        }

        assertThrows<IllegalArgumentException> {
            ValidationCheck.isValidLottoNumber(listOf(-1, 2, 3, 4, 5, 6))
        }

        assertThrows<IllegalArgumentException> {
            ValidationCheck.isValidLottoNumber(listOf(1, 2, 3, 4, 5, 46))
        }

        assertThrows<IllegalArgumentException> {
            ValidationCheck.isValidLottoNumber(listOf(0, 2, 3, 4, 5, 45))
        }

        assertThrows<IllegalArgumentException> {
            ValidationCheck.isValidLottoNumber(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `보너스 번호가 올바르지 않을 시 예외가 발샌한다`() {
        assertEquals(7, ValidationCheck.isValidBonusNumber(7, setOf(1, 2, 3, 4, 5, 6)))

        assertThrows<IllegalArgumentException> {
            ValidationCheck.isValidBonusNumber(6, setOf(1, 2, 3, 4, 5, 6))
        }

        assertThrows<IllegalArgumentException> {
            ValidationCheck.isValidBonusNumber(-1, setOf(1, 2, 3, 4, 5, 6))
        }

        assertThrows<IllegalArgumentException> {
            ValidationCheck.isValidBonusNumber(0, setOf(1, 2, 3, 4, 5, 6))
        }
    }
}