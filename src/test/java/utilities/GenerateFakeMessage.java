package utilities;

import com.github.javafaker.Faker;

public class GenerateFakeMessage {

    public static String getFakeText() {
        Faker faker = new Faker();
        return faker.chuckNorris().fact();
    }

}
