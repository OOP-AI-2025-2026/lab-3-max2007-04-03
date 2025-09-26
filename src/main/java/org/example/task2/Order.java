package org.example.task2;

/**
 * Клас Order представляє замовлення клієнта.
 */
public final class Order {

    /** Ідентифікатор замовлення. */
    private final long id;
    /** Ім'я клієнта. */
    private final String customer;

    /**
     * Створює новий об'єкт замовлення.
     * @param id       ідентифікатор замовлення.
     * @param customer ім'я клієнта.
     */
    public Order(final long id, final String customer) {
        this.id = id;
        this.customer = customer;
    }

    /**
     * Повертає ID замовлення.
     * @return ідентифікатор замовлення.
     */
    public long getId() {
        return id;
    }

    /**
     * Повертає ім'я клієнта.
     * @return ім'я клієнта.
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * Формує текстовий рахунок на основі вмісту кошика.
     * @param cart кошик з товарами.
     * @return рядкове представлення рахунку.
     */
    public String formOrderBill(final Cart cart) {
        StringBuilder builder = new StringBuilder();
        builder.append("Order number ").append(this.id)
                .append(" for customer ").append(this.customer);
        builder.append("\n------------------\n");

        Item[] items = cart.getItems();

        for (Item item : items) {
            builder.append("Item id: ").append(item.getId())
                    .append(", name: ").append(item.getName())
                    .append(", price: ").append(item.getPrice())
                    .append("\n");
        }

        builder.append("------------------\n");
        builder.append("Total sum: ").append(cart.getTotalPrice());

        return builder.toString();
    }
}