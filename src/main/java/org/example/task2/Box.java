package org.example.task2;

/**
 * Клас Box моделює геометричну фігуру "прямокутний паралелепіпед".
 * Об'єкти цього класу є незмінними (immutable) після створення.
 */
public final class Box {

    /** Тестове значення для ширини коректної коробки. */
    private static final double TEST_WIDTH = 10.0;
    /** Тестове значення для висоти коректної коробки. */
    private static final double TEST_HEIGHT = 5.0;
    /** Тестове значення для довжини коректної коробки. */
    private static final double TEST_LENGTH = 2.0;
    /** Некоректне тестове значення для висоти коробки. */
    private static final double INVALID_TEST_HEIGHT = -5.0;

    /** Ширина коробки. Має бути додатним числом. */
    private final double width;

    /** Висота коробки. Має бути додатним числом. */
    private final double height;

    /** Довжина коробки. Має бути додатним числом. */
    private final double length;

    /**
     * Створює об'єкт Box з заданими розмірами.
     *
     * @param width  ширина коробки (повинна бути > 0).
     * @param height висота коробки (повинна бути > 0).
     * @param length довжина коробки (повинна бути > 0).
     * @throws IllegalArgumentException якщо будь-який з розмірів не є додатним.
     */
    public Box(final double width, final double height, final double length) {
        this.width = validateSide(width, "Ширина");
        this.height = validateSide(height, "Висота");
        this.length = validateSide(length, "Довжина");
    }

    /**
     * Перевіряє, чи є значення сторони додатним числом.
     *
     * @param sideValue значення сторони для перевірки.
     * @param sideName  ім'я сторони для повідомлення про помилку.
     * @return значення сторони, якщо воно коректне.
     * @throws IllegalArgumentException якщо значення сторони не є додатним.
     */
    private double validateSide(final double sideValue, final String sideName) {
        if (sideValue <= 0) {
            throw new IllegalArgumentException(
                    sideName + " повинна бути більшою за нуль.");
        }
        return sideValue;
    }

    /**
     * Обчислює та повертає об'єм коробки.
     *
     * @return об'єм коробки.
     */
    public double getVolume() {
        return width * height * length;
    }

    /**
     * Обчислює та повертає площу повної поверхні коробки.
     *
     * @return площа повної поверхні.
     */
    public double getSurfaceArea() {
        return 2 * (width * height + width * length + height * length);
    }

    /**
     * Обчислює та повертає площу бічної поверхні коробки.
     *
     * @return площа бічної поверхні.
     */
    public double getLateralSurfaceArea() {
        return 2 * height * (width + length);
    }

    /**
     * Головний метод для демонстрації роботи класу Box.
     *
     * @param args аргументи командного рядка (не використовуються).
     */
    public static void main(final String[] args) {
        try {
            Box myBox = new Box(TEST_WIDTH, TEST_HEIGHT, TEST_LENGTH);
            System.out.println("Об'єкт Box створено успішно.");
            System.out.println("Об'єм: " + myBox.getVolume());
            System.out.println("Площа повної поверхні: "
                    + myBox.getSurfaceArea());
            System.out.println("Площа бічної поверхні: "
                    + myBox.getLateralSurfaceArea());

            System.out.println("\n--- Спроба створити некоректний об'єкт ---");
            Box invalidBox = new Box(TEST_WIDTH,
                    INVALID_TEST_HEIGHT, TEST_LENGTH);

        } catch (IllegalArgumentException e) {
            // Цей рядок розбито на два, щоб не перевищувати 80 символів
            System.err.println("Помилка при створенні коробки: "
                    + e.getMessage());
        }
    }
}

