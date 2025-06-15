package helpers;

import net.datafaker.Faker;

public class DataGenerator {
    private final Faker faker = new Faker();

    public int getPriority() {
        return faker.number().numberBetween(1, 5);
    }

    public String getTaskName() {
        return faker.funnyName().name();
    }

    public String getTaskDescription() {
        return "Visit " + faker.address().fullAddress();
    }

    public String getStreetName() {
        return "Visit " + faker.address().streetName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }
}