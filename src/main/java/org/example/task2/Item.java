package org.example.task2;

/**
 * Клас Item представляє товар в інтернет-магазині.
 * Об'єкти цього класу є незмінними (immutable) після створення.
 */
public class Item {

    /** Унікальний ідентифікатор товару. */
    private final long id;
    /** Назва товару. */
    private final String name;
    /** Ціна товару. */
    private final double price;

    /**
     * Створює новий об'єкт товару.
     *
     * @param id    унікальний ідентифікатор.
     * @param name  назва товару.
     * @param price ціна товару.
     */
    public Item(final long id, final String name, final double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * Повертає ID товару.
     *
     * @return унікальний ідентифікатор товару.
     */
    public long getId() {
        return id;
    }

    /**
     * Повертає назву товару.
     *
     * @return назва товару.
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає ціну товару.
     *
     * @return ціна товару.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Повертає рядкове представлення об'єкта Item.
     *
     * @return рядок з інформацією про товар.
     */
    @Override
    public String toString() {
        // Рядок розбито на кілька частин з оператором '+' на початку
        // нового рядка, щоб відповідати правилам форматування.
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", price=" + price
                + '}';
    }
}
