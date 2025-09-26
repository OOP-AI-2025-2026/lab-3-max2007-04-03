
package org.example.task2;

import java.util.Arrays;

/**
 * Клас Cart представляє кошик для товарів в інтернет-магазині.
 * Кошик має фіксовану місткість.
 */
public class Cart {

    /** Масив для зберігання товарів у кошику. */
    private final Item[] contents;
    /** Поточна кількість товарів у кошику. */
    private int itemCount;

    /**
     * Створює новий порожній кошик із заданою максимальною місткістю.
     *
     * @param capacity максимальна кількість товарів, яку може вмістити кошик.
     */
    public Cart(final int capacity) {
        this.contents = new Item[capacity];
        this.itemCount = 0;
    }

    /**
     * Додає товар до кошика.
     * Якщо кошик заповнений, виводить повідомлення і не додає товар.
     *
     * @param item товар, який потрібно додати.
     */
    public void add(final Item item) {
        if (isFull()) {
            // Рядок розбито на два для дотримання ліміту довжини
            System.out.println("Кошик заповнений. Неможливо додати товар: "
                    + item.getName());
            return;
        }
        this.contents[this.itemCount] = item;
        this.itemCount++;
    }

    /**
     * Видаляє товар з кошика за його індексом.
     *
     * @param index індекс товару, який потрібно видалити.
     */
    public void removeByIndex(final int index) {
        if (index < 0 || index >= this.itemCount) {
            System.out.println("Помилка: невірний індекс для видалення.");
            return;
        }
        for (int i = index; i < this.itemCount - 1; i++) {
            this.contents[i] = this.contents[i + 1];
        }
        this.contents[this.itemCount - 1] = null;
        this.itemCount--;
    }

    /**
     * Обчислює та повертає загальну вартість усіх товарів у кошику.
     *
     * @return загальна вартість товарів.
     */
    public double getTotalPrice() {
        double total = 0.0;
        for (int i = 0; i < this.itemCount; i++) {
            total += this.contents[i].getPrice();
        }
        return total;
    }

    /**
     * Повертає масив товарів, що знаходяться в кошику.
     * Повертає копію масиву, щоб запобігти зміні внутрішнього стану кошика.
     *
     * @return масив товарів.
     */
    public Item[] getItems() {
        return Arrays.copyOf(this.contents, this.itemCount);
    }

    /**
     * Перевіряє, чи заповнений кошик.
     *
     * @return true, якщо кошик заповнений, інакше false.
     */
    private boolean isFull() {
        return this.itemCount == this.contents.length;
    }

    /**
     * Повертає рядкове представлення кошика.
     *
     * @return рядок з інформацією про вміст кошика.
     */
    @Override
    public String toString() {
        // Рядок розбито згідно з правилами форматування
        return "Cart{"
                + "contents=" + Arrays.toString(getItems())
                + '}';
    }
}
