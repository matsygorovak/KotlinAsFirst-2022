package lesson12.task1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag

internal class TableFunctionTest {

    @Test
    @Tag("6")
    fun tfAdd() {
        val function = TableFunction()
        function.add(1.0, 2.0)
        function.add(3.0, 4.0)
        assertTrue(function.add(5.0, 6.0))
        assertFalse(function.add(5.0, 7.0))
        assertEquals(3, function.size)
    }

    @Test
    @Tag("6")
    fun tfRemove() {
        val function = TableFunction()
        function.add(1.0, 2.0)
        function.add(3.0, 4.0)
        assertTrue(function.remove(1.0))
        assertFalse(function.remove(1.0))
        assertEquals(1, function.size)
    }

    @Test
    @Tag("6")
    fun getPairs() {
        val function = TableFunction()
        function.add(1.0, 2.0)
        val pairs = function.getPairs()
        assertEquals(1, pairs.size)
        assertEquals(1.0 to 2.0, pairs.single())
        function.add(8.0, 7.0)
        function.add(6.0, 3.0)
        val pairs2 = function.getPairs()
        assertEquals(3, pairs2.size)
    }

    @Test
    @Tag("6")
    fun findPair() {
        val function = TableFunction()
        function.add(1.0, 2.0)
        function.add(3.0, 4.0)
        function.add(5.0, 6.0)
        assertEquals(5.0 to 6.0, function.findPair(5.75))
        assertEquals(1.0 to 2.0, function.findPair(1.5))
        assertEquals(3.0 to 4.0, function.findPair(4.0))
    }

    @Test
    @Tag("10")
    fun tfGetValue() {
        val function = TableFunction()
        try {
            function.getValue(0.0)
        } catch (ex: IllegalStateException) {
            // pass
        } catch (ex: NotImplementedError) {
            throw ex
        }
        function.add(1.0, 2.0)
        assertEquals(2.0, function.getValue(1.5))
        function.add(3.0, 4.0)
        function.add(5.0, 6.0)
        assertEquals(5.0, function.getValue(4.0), 1e-10)
        assertEquals(0.0, function.getValue(-1.0), 1e-10)
    }

    @Test
    @Tag("6")
    fun tfEquals() {
        val f1 = TableFunction()
        f1.add(1.0, 2.0)
        f1.add(3.0, 4.0)
        val f2 = TableFunction()
        f2.add(3.0, 4.0)
        f2.add(1.0, 2.0)
        assertEquals(f1, f2)
        val f3 = TableFunction()
        f3.add(1.0, 2.0)
        f3.add(3.0, 4.0)
        val f4 = TableFunction()
        f4.add(3.0, 5.0)
        f4.add(7.0, 2.0)
        assertFalse(f3 == f4)
    }
}