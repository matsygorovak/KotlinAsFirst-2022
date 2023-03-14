@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

import java.lang.IllegalArgumentException
import kotlin.math.abs

/**
 * Фабричный метод для создания комплексного числа из строки вида x+yi
 */
fun Complex(s: String): Complex {
    var re = 0.0
    var im = 0.0
    if (!Regex("""(-?\d+)?(([+-]\d*)?i)?""").matches(s)) throw IllegalArgumentException()
    if (!Regex("""i""").containsMatchIn(s)) {
        re = s.toDouble()
    } else {
        val number = Regex("""i""").replace(s, "")
        if (Regex("""-\d+[-+]\d+""").matches(number)) {
            re -= Regex("""-""").split(number)[0].toDouble()
            im = if (Regex("""[+]""").containsMatchIn(number)) {
                Regex("""[+]""").split(number)[1].toDouble()
            } else {
                -Regex("""-""").split(number)[1].toDouble()
            }
        } else if (Regex("""-?\d+""").matches(number)) {
            im = number.toDouble()
        } else {
            re = Regex("""[-+]""").split(number)[0].toDouble()
            im = if (Regex("""-""").containsMatchIn(number)) {
                -Regex("""[-+]""").split(number)[1].toDouble()
            } else {
                Regex("""[-+]""").split(number)[1].toDouble()
            }
        }
    }
    return Complex(re, im)
}

/**
 * Класс "комплексное число".
 *
 * Общая сложность задания -- лёгкая, общая ценность в баллах -- 8.
 * Объект класса -- комплексное число вида x+yi.
 * Про принципы работы с комплексными числами см. статью Википедии "Комплексное число".
 *
 * Аргументы конструктора -- вещественная и мнимая часть числа.
 */
class Complex(val re: Double, val im: Double) {
    /**
     * Конструктор из вещественного числа
     */
    constructor(x: Double) : this(x, 0.0)

    /**
     * Сложение.
     */
    operator fun plus(other: Complex): Complex = Complex(re + other.re, im + other.im)

    /**
     * Смена знака (у обеих частей числа)
     */
    operator fun unaryMinus(): Complex = Complex(re * (-1), im * (-1))

    /**
     * Вычитание
     */
    operator fun minus(other: Complex): Complex = Complex(re - other.re, im - other.im)

    /**
     * Умножение
     */
    operator fun times(other: Complex): Complex =
        Complex(re * other.re - im * other.im, re * other.im + im * other.re)

    /**
     * Деление
     */
    operator fun div(other: Complex): Complex =
        Complex(
            (re * other.re + im * other.im) / (other.re * other.re + other.im * other.im),
            (im * other.re - re * other.im) / (other.re * other.re + other.im * other.im)
        )

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean = (other is Complex) && (re == other.re) && (im == other.im)

    /**
     * Преобразование в строку
     */
    override fun toString(): String {
        return if (im > 0) {
            "$re+${im}i"
        } else {
            "$re${im}i"
        }
    }
}
