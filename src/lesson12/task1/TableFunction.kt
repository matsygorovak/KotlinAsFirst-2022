@file:Suppress("UNUSED_PARAMETER")

package lesson12.task1

import kotlin.math.abs

/**
 * Класс "табличная функция".
 *
 * Общая сложность задания -- средняя, общая ценность в баллах -- 16.
 * Объект класса хранит таблицу значений функции (y) от одного аргумента (x).
 * В таблицу можно добавлять и удалять пары (x, y),
 * найти в ней ближайшую пару (x, y) по заданному x,
 * найти (интерполяцией или экстраполяцией) значение y по заданному x.
 *
 * Класс должен иметь конструктор по умолчанию (без параметров).
 */
class TableFunction {
    val table = mutableMapOf<Double, Double>()

    /**
     * Количество пар в таблице
     */
    val size: Int get() = table.size

    /**
     * Добавить новую пару.
     * Вернуть true, если пары с заданным x ещё нет,
     * или false, если она уже есть (в этом случае перезаписать значение y)
     */
    fun add(x: Double, y: Double): Boolean = table.put(x, y) == null

    /**
     * Удалить пару с заданным значением x.
     * Вернуть true, если пара была удалена.
     */
    fun remove(x: Double): Boolean = table.remove(x) != null

    /**
     * Вернуть коллекцию из всех пар в таблице
     */
    fun getPairs(): Collection<Pair<Double, Double>> {
        val set = mutableSetOf<Pair<Double, Double>>()
        for ((key, value) in table) {
            set.add(Pair(key, value))
        }
        return set
    }

    /**
     * Вернуть пару, ближайшую к заданному x.
     * Если существует две ближайшие пары, вернуть пару с меньшим значением x.
     * Если таблица пуста, бросить IllegalStateException.
     */
    fun findPair(x: Double): Pair<Double, Double>? {
        if (table.isEmpty()) {
            throw IllegalStateException()
        } else {
            var answerkey = -1.0
            var long = 1000000.0
            var answer = 0.0 to 0.0
            for ((key, value) in table) {
                if (abs(x - key) < long && abs(x - key) != 0.0 || (abs(x - key) == long && key < answerkey)) {
                    long = abs(x - key)
                    answer = (key to table[key]!!.toDouble())
                    answerkey = key
                }
            }
            return answer
        }
    }

    /**
     * Вернуть значение y по заданному x.
     * Если в таблице есть пара с заданным x, взять значение y из неё.
     * Если в таблице есть всего одна пара, взять значение y из неё.
     * Если таблица пуста, бросить IllegalStateException.
     * Если существуют две пары, такие, что x1 < x < x2, использовать интерполяцию.
     * Если их нет, но существуют две пары, такие, что x1 < x2 < x или x > x2 > x1, использовать экстраполяцию.
     */
    fun getValue(x: Double): Double {
        if (table.isEmpty()) {
            throw IllegalStateException()
        } else if (table.size == 1) {
            for ((key, value) in table) {
                return value
            }
        } else if (x in table) {
            return table[x]!!
        } else {
            val x2 = findPair(x)!!.first
            val x1 = findPair(x2)!!.first
            val y1 = table[x1]!!
            val y2 = table[x2]!!
            return y1 + ((x - x1) * (y2 - y1) / (x2 - x1))
        }
        return table[x]!!
    }

    /**
     * Таблицы равны, если в них одинаковое количество пар,
     * и любая пара из второй таблицы входит также и в первую
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TableFunction) return false
        if (size == other.size) {
            for ((key, value) in getPairs()) {
                if (value != other.table[key]) return false
            }
            return true
        } else return false
    }
}