package org.example.task2;

/**
 * Головний клас для демонстрації роботи інтернет-магазину.
 * Цей клас є утилітарним і не призначений для створення екземплярів.
 */
public final class Main {

    /** Максимальна місткість кошика. */
    private static final int CART_CAPACITY = 10;
    /** Індекс товару для видалення. */
    private static final int REMOVE_ITEM_INDEX = 9;
    /** Ідентифікатор тестового замовлення. */
    private static final long ORDER_ID = 1L;
    /** Ім'я тестового клієнта. */
    private static final String CUSTOMER_NAME = "John";

    /** Тестовий товар: Смартфон Samsung. */
    private static final Item ITEM_1 = new Item(1, "Samsung Galaxy S23", 27999);
    /** Тестовий товар: Ноутбук Lenovo. */
    private static final Item ITEM_2 = new Item(2, "Lenovo IdeaPad 3", 19499);
    /** Тестовий товар: Телевізор LG. */
    private static final Item ITEM_3 = new Item(3,
            "LG 55\" 4K Smart TV", 15999);
    /** Тестовий товар: Пральна машина Bosch. */
    private static final Item ITEM_4 = new Item(4,
            "Bosch Serie 6 Пральна машина", 14799);
    /** Тестовий товар: Холодильник Samsung. */
    private static final Item ITEM_5 = new Item(5,
            "Samsung RB34 Холодильник", 22399);
    /** Тестовий товар: Кавоварка De'Longhi. */
    private static final Item ITEM_6 = new Item(6,
            "De'Longhi Magnifica S Кавоварка", 10599);
    /** Тестовий товар: Електрична плита Gorenje. */
    private static final Item ITEM_7 = new Item(7,
            "Gorenje Електрична плита", 9999);
    /** Тестовий товар: Пилосос Dyson. */
    private static final Item ITEM_8 = new Item(8, "Dyson V11 Пилосос", 16499);
    /** Тестовий товар: Мікрохвильова піч Samsung. */
    private static final Item ITEM_9 = new Item(9,
            "Samsung ME83K Мікрохвильова піч", 3199);
    /** Тестовий товар: Фен Philips. */
    private static final Item ITEM_10 = new Item(10,
            "Philips DryCare Фен", 1499);

    /**
     * Приватний конструктор, щоб запобігти створенню екземплярів цього класу.
     */
    private Main() {
    }

    /**
     * Точка входу в програму.
     * @param args аргументи командного рядка (не використовуються).
     */
    public static void main(final String[] args) {
        Cart cart = new Cart(CART_CAPACITY);

        cart.add(ITEM_1);
        cart.add(ITEM_2);
        cart.add(ITEM_3);
        cart.add(ITEM_4);
        cart.add(ITEM_5);
        cart.add(ITEM_6);
        cart.add(ITEM_7);
        cart.add(ITEM_8);
        cart.add(ITEM_9);
        cart.add(ITEM_10);

        System.out.println(cart);

        cart.removeByIndex(REMOVE_ITEM_INDEX);

        System.out.println(cart);

        Order order = new Order(ORDER_ID, CUSTOMER_NAME);
        String bill = order.formOrderBill(cart);
        System.out.println(bill);
    }
}