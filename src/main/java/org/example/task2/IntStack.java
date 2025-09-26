package org.example.task2;

import java.util.EmptyStackException;

/**
 * Клас IntStack реалізує стек для цілих чисел (LIFO - Last-In, First-Out)
 * на основі масиву, що динамічно розширюється.
 * Внутрішня реалізація повністю прихована від користувача.

 */
public class IntStack {

    // --- ПРИВАТНА ЧАСТИНА (РЕАЛІЗАЦІЯ) ---

    /** Початкова місткість стека за замовчуванням. */
    private static final int DEFAULT_CAPACITY = 10;

    /** Масив для зберігання елементів стека. */
    private int[] elements;

    /** Поточна кількість елементів у стеку. */
    private int size;

    /**
     * Розширює масив, коли в ньому закінчується місце.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            int[] newElements = new int[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    // --- ПУБЛІЧНА ЧАСТИНА (ІНТЕРФЕЙС) ---

    /**
     * Створює новий порожній стек з початковою місткістю.
     */
    public IntStack() {
        this.elements = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Додає елемент на вершину стека.
     * @param element ціле число для додавання.
     */
    public void push(final int element) {
        ensureCapacity();
        elements[size] = element;
        size++;
    }

    /**
     * Видаляє та повертає елемент з вершини стека.
     * @return елемент з вершини стека.
     * @throws EmptyStackException якщо стек порожній.
     */
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        size--;
        return elements[size];
    }

    /**
     * Повертає елемент з вершини стека, не видаляючи його.
     * @return елемент з вершини стека.
     * @throws EmptyStackException якщо стек порожній.
     */
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[size - 1];
    }

    /**
     * Повертає кількість елементів у стеку.
     * @return поточний розмір стека.
     */
    public int size() {
        return size;
    }

    /**
     * Перевіряє, чи є стек порожнім.
     * @return true, якщо стек порожній, інакше false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Повністю очищує стек.
     */
    public void clear() {
        elements = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Демонструє роботу класу IntStack.
     * @param args аргументи командного рядка (не використовуються).
     */
    public static void main(final String[] args) {
        // Створено константи, щоб уникнути "магічних чисел"
        final int firstTestValue = 5;
        final int secondTestValue = 10;
        final int thirdTestValue = 15;

        IntStack stack = new IntStack();
        System.out.println("Стек порожній? " + stack.isEmpty());

        System.out.printf("\nДодаємо елементи: %d, %d, %d\n",
                firstTestValue, secondTestValue, thirdTestValue);
        stack.push(firstTestValue);
        stack.push(secondTestValue);
        stack.push(thirdTestValue);

        System.out.println("Розмір стека: " + stack.size());
        System.out.println("Верхній елемент (peek): " + stack.peek());

        System.out.println("\nВидаляємо елемент (pop): " + stack.pop());
        System.out.println("Новий верхній елемент (peek): " + stack.peek());
        System.out.println("Новий розмір стека: " + stack.size());

        System.out.println("\nОчищуємо стек...");
        stack.clear();
        System.out.println("Розмір стека після очищення: " + stack.size());

        System.out.println("\nСпроба викликати pop() на порожньому стеку:");
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.err.println("Успішно перехоплено виняток: " + e);
        }
    }
}
