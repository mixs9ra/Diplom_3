package user;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserClient {
    private static final String SITE = "https://stellarburgers.nomoreparties.site/"; // URL для API
    private user.User user = new user.User();
    private final UserGenerator userGenerator = new UserGenerator(); // Генератор пользователей

    // Создание пользователя через API
    @Step("Создание пользователя через API.")
    public static Response createUser(user.User user) {
        return given().log().all() // Логирование запроса
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(SITE + "api/auth/register"); // Выполнение POST запроса для регистрации
    }

    // Удаление пользователя через API
    @Step("Удаление пользователя через API.")
    public static Response deleteUser(user.User user) {
        String accessToken = given()
                .contentType(ContentType.JSON)
                .body(user)
                .post(SITE + "api/auth/login") // Выполнение POST запроса для получения токена
                .body().path("accessToken"); // Извлечение токена из ответа

        // Выполнение DELETE запроса для удаления пользователя
        return given().contentType(ContentType.JSON)
                .header("Authorization", accessToken)
                .body(user)
                .delete(SITE + "api/auth/user"); // Выполнение DELETE запроса для удаления пользователя
    }
}