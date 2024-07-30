package user;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    // Генерация объекта User с случайными данными
    public user.User getUser() {
        return new user.User(getName(), getEmail(), getValidPassword());
    }

    // Генерация случайного имени (10 букв)
    public String getName() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    // Генерация случайного email
    public String getEmail() {
        return String.format("%s@%s.ru",
                RandomStringUtils.randomAlphabetic(5), // Локальная часть email
                RandomStringUtils.randomAlphabetic(4)); // Доменная часть email
    }

    // Генерация действительного пароля (8 символов)
    public String getValidPassword() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    // Генерация недействительного пароля (менее 6 символов)
    public String getInvalidPassword() {
        return RandomStringUtils.randomAlphanumeric(5);
    }
}