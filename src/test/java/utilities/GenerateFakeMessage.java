package utilities;

import com.github.javafaker.Faker;

public class GenerateFakeMessage {

    public static String getFakeName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String getFakeEmail(){
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String getFakeNumber() {
        Faker faker = new Faker();
        return faker.number().digit();
    }

    public static String getFakeAddress() {
        Faker faker = new Faker();
        return faker.address().streetAddress();
    }

    public static String getFakeCity() {
        Faker faker = new Faker();
        return faker.address().city();
    }

    public static String getFakeZipcode() {
        Faker faker = new Faker();
        return faker.address().zipCode();
    }

}
