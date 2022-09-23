package lesson6.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Example")
    fun timeStrToSeconds() {
        assertEquals(36000, lesson8.task1.timeStrToSeconds("10:00:00"))
        assertEquals(41685, lesson8.task1.timeStrToSeconds("11:34:45"))
        assertEquals(86399, lesson8.task1.timeStrToSeconds("23:59:59"))
    }

    @Test
    @Tag("Example")
    fun twoDigitStr() {
        assertEquals("00", lesson8.task1.twoDigitStr(0))
        assertEquals("09", lesson8.task1.twoDigitStr(9))
        assertEquals("10", lesson8.task1.twoDigitStr(10))
        assertEquals("99", lesson8.task1.twoDigitStr(99))
    }

    @Test
    @Tag("Example")
    fun timeSecondsToStr() {
        assertEquals("10:00:00", lesson8.task1.timeSecondsToStr(36000))
        assertEquals("11:34:45", lesson8.task1.timeSecondsToStr(41685))
        assertEquals("23:59:59", lesson8.task1.timeSecondsToStr(86399))
    }

    @Test
    @Tag("4")
    fun dateStrToDigit() {
        assertEquals("15.07.2016", lesson8.task1.dateStrToDigit("15 июля 2016"))
        assertEquals("", lesson8.task1.dateStrToDigit("3 мартобря 1918"))
        assertEquals("18.11.2018", lesson8.task1.dateStrToDigit("18 ноября 2018"))
        assertEquals("", lesson8.task1.dateStrToDigit("23"))
        assertEquals("03.04.2011", lesson8.task1.dateStrToDigit("3 апреля 2011"))
        assertEquals("", lesson8.task1.dateStrToDigit("32 сентября 2011"))
        assertEquals("", lesson8.task1.dateStrToDigit("29 февраля 1993"))
    }

    @Test
    @Tag("4")
    fun dateDigitToStr() {
        assertEquals("15 июля 2016", lesson8.task1.dateDigitToStr("15.07.2016"))
        assertEquals("", lesson8.task1.dateDigitToStr("01.02.20.19"))
        assertEquals("", lesson8.task1.dateDigitToStr("28.00.2000"))
        assertEquals("3 апреля 2011", lesson8.task1.dateDigitToStr("03.04.2011"))
        assertEquals("", lesson8.task1.dateDigitToStr("ab.cd.ef"))
        assertEquals("", lesson8.task1.dateDigitToStr("32.09.2011"))
        assertEquals("", lesson8.task1.dateDigitToStr("29.02.1993"))
    }

    @Test
    @Tag("4")
    fun flattenPhoneNumber() {
        assertEquals("+79211234567", lesson8.task1.flattenPhoneNumber("+7 (921) 123-45-67"))
        assertEquals("123456798", lesson8.task1.flattenPhoneNumber("12 --  34- 5 -- 67 -98"))
        assertEquals("+12345", lesson8.task1.flattenPhoneNumber("+12 (3) 4-5"))
        assertEquals("", lesson8.task1.flattenPhoneNumber("+12 () 4-5"))
        assertEquals("+425667", lesson8.task1.flattenPhoneNumber("+42 56 -- 67"))
        assertEquals("+42566789", lesson8.task1.flattenPhoneNumber("+42(56 -- 67)89"))
        assertEquals("", lesson8.task1.flattenPhoneNumber("ab-123"))
        assertEquals("", lesson8.task1.flattenPhoneNumber("134_+874"))
    }

    @Test
    @Tag("5")
    fun bestLongJump() {
        assertEquals(717, lesson8.task1.bestLongJump("706 % - 717 - 703"))
        assertEquals(-1, lesson8.task1.bestLongJump("% - - % -"))
        assertEquals(754, lesson8.task1.bestLongJump("700 717 707 % 754"))
        assertEquals(-1, lesson8.task1.bestLongJump("700 + 700"))

    }

    @Test
    @Tag("6")
    fun bestHighJump() {
        assertEquals(226, lesson8.task1.bestHighJump("226 +"))
        assertEquals(-1, lesson8.task1.bestHighJump("???"))
        assertEquals(230, lesson8.task1.bestHighJump("220 + 224 %+ 228 %- 230 + 232 %%- 234 %"))
    }

    @Test
    @Tag("6")
    fun plusMinus() {
        assertEquals(0, lesson8.task1.plusMinus("0"))
        assertEquals(4, lesson8.task1.plusMinus("2 + 2"))
        assertEquals(6, lesson8.task1.plusMinus("2 + 31 - 40 + 13"))
        assertEquals(-1, lesson8.task1.plusMinus("0 - 1"))
        assertThrows(IllegalArgumentException::class.java) { lesson8.task1.plusMinus("+2") }
        assertThrows(IllegalArgumentException::class.java) { lesson8.task1.plusMinus("+ 4") }
        assertThrows(IllegalArgumentException::class.java) { lesson8.task1.plusMinus("4 - -2") }
        assertThrows(IllegalArgumentException::class.java) { lesson8.task1.plusMinus("44 - - 12") }
        assertThrows(IllegalArgumentException::class.java) { lesson8.task1.plusMinus("4 - + 12") }
    }

    @Test
    @Tag("6")
    fun firstDuplicateIndex() {
        assertEquals(-1, lesson8.task1.firstDuplicateIndex("Привет"))
        assertEquals(9, lesson8.task1.firstDuplicateIndex("Он пошёл в в школу"))
        assertEquals(40, lesson8.task1.firstDuplicateIndex("Яблоко упало на ветку с ветки оно упало на на землю"))
        assertEquals(9, lesson8.task1.firstDuplicateIndex("Мы пошли прямо Прямо располагался магазин"))
    }

    @Test
    @Tag("6")
    fun mostExpensive() {
        assertEquals("", lesson8.task1.mostExpensive(""))
        assertEquals("Курица", lesson8.task1.mostExpensive("Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9"))
        assertEquals("Вино", lesson8.task1.mostExpensive("Вино 255.0"))
    }

    @Test
    @Tag("6")
    fun fromRoman() {
        assertEquals(1, lesson8.task1.fromRoman("I"))
        assertEquals(3000, lesson8.task1.fromRoman("MMM"))
        assertEquals(1978, lesson8.task1.fromRoman("MCMLXXVIII"))
        assertEquals(694, lesson8.task1.fromRoman("DCXCIV"))
        assertEquals(49, lesson8.task1.fromRoman("XLIX"))
        assertEquals(-1, lesson8.task1.fromRoman("Z"))
    }

    @Test
    @Tag("7")
    fun computeDeviceCells() {
        assertEquals(listOf(0, 0, 0, 0, 0, 1, 1, 1, 1, 1), lesson8.task1.computeDeviceCells(10, "+>+>+>+>+", 10000))
        assertEquals(listOf(-1, -1, -1, -1, -1, 0, 0, 0, 0, 0),
            lesson8.task1.computeDeviceCells(10, "<-<-<-<-<-", 10000)
        )
        assertEquals(listOf(1, 1, 1, 1, 1, 0, 0, 0, 0, 0), lesson8.task1.computeDeviceCells(10, "- <<<<< +[>+]", 10000))
        assertEquals(
            listOf(0, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0),
            lesson8.task1.computeDeviceCells(11, "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]", 10000)
        )

        assertEquals(listOf(0, 0, 0, 0, 0, 1, 1, 0, 0, 0), lesson8.task1.computeDeviceCells(10, "+>+>+>+>+", 4))
        assertEquals(listOf(0, 0, -1, -1, -1, 0, 0, 0, 0, 0), lesson8.task1.computeDeviceCells(10, "<-<-<-<-<-", 6))
        assertEquals(listOf(1, 1, 1, 0, 0, -1, 0, 0, 0, 0), lesson8.task1.computeDeviceCells(10, "- <<<<< +[>+]", 17))
        assertEquals(
            listOf(0, 6, 5, 4, 3, 2, 1, 0, -1, -1, -2),
            lesson8.task1.computeDeviceCells(11, "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]", 256)
        )
        assertThrows(IllegalArgumentException::class.java) { lesson8.task1.computeDeviceCells(10, "===", 3) }
        assertThrows(IllegalArgumentException::class.java) { lesson8.task1.computeDeviceCells(10, "+>+>[+>", 3) }
        assertThrows(IllegalStateException::class.java) { lesson8.task1.computeDeviceCells(20, ">>>>>>>>>>>>>", 12) }
    }
}