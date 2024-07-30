package user;

import lombok.*; // Импорт всех необходимых аннотаций из библиотеки

@Getter // Автоматически создает геттеры
@Setter // Автоматически создает сеттеры
@EqualsAndHashCode // Автоматически создает методы equals() и hashCode()
@NoArgsConstructor // Автоматически создает конструктор без аргументов
@AllArgsConstructor // Автоматически создает конструктор с аргументами для всех полей
public class User {
    public String name;
    public String email;
    public String password;

    // Конструктор с двумя аргументами (email и пароль)
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}