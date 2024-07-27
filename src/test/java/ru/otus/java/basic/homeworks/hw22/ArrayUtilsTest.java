package ru.otus.java.basic.homeworks.hw22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayUtilsTest {

    /**
     * Тестирует метод {@link ArrayUtils#getElementsAfterLastOne(int[])}.
     * Проверяет, что метод корректно возвращает элементы после последней единицы
     */
    @Test
    void testGetElementsAfterLastOne() {
        assertArrayEquals(new int[]{2, 2}, ArrayUtils.getElementsAfterLastOne(new int[]{1, 2, 1, 2, 2}));
        assertArrayEquals(new int[]{}, ArrayUtils.getElementsAfterLastOne(new int[]{1, 2, 1}));
        assertArrayEquals(new int[]{2, 2, 2}, ArrayUtils.getElementsAfterLastOne(new int[]{1, 2, 2, 2}));
    }

    /**
     * Тестирует метод {@link ArrayUtils#getElementsAfterLastOne(int[])}.
     * Проверяет, что метод выбрасывает {@link RuntimeException}, если в массиве нет единиц
     */
    @Test
    void testGetElementsAfterLastOneThrowsException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            ArrayUtils.getElementsAfterLastOne(new int[]{2, 2, 2, 2});
        });
        assertEquals("Array does not contain any 1s", exception.getMessage());
    }

    /**
     * Тестирует метод {@link ArrayUtils#isArrayValid(int[])}.
     * Проверяет, что метод корректно определяет, состоит ли массив только из чисел 1 и 2,
     * и содержит ли он хотя бы одну единицу и одну двойку
     */
    @Test
    void testIsArrayValid() {
        assertTrue(ArrayUtils.isArrayValid(new int[]{1, 2}));
        assertFalse(ArrayUtils.isArrayValid(new int[]{1, 1}));
        assertFalse(ArrayUtils.isArrayValid(new int[]{1, 3}));
        assertTrue(ArrayUtils.isArrayValid(new int[]{1, 2, 2, 1}));
        assertFalse(ArrayUtils.isArrayValid(new int[]{3, 3, 3}));
        assertFalse(ArrayUtils.isArrayValid(new int[]{2, 2, 2}));
    }

}