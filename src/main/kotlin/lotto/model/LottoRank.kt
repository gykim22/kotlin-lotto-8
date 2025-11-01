package lotto.model

enum class LottoRank(val count: Int, val prize: Int, val bonus: Boolean = false) {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000),
    LOSES(0, 0);

    /**
     * Companion object를 활용해 클래스에 속하지만, 인스턴스에는 속하지 않는 함수로 만들어 당첨 판별에 활용.
     */
    companion object {
        fun of(count: Int, bonus: Boolean): LottoRank = entries.find { it.count == count && it.bonus == bonus } ?: LOSES
    }
}