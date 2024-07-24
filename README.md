Дипломная работа. Задание 3: веб-приложение

Чтобы запустить тесты в Google Chrome, нужно использовать команду:
mvn clean test

Чтобы запустить тесты в Яндекс.Браузере, нужно использовать команду:
mvn clean test -Dbrowser=yandex

Генерации отчета Allure:
mvn allure:report 

Открыть отчет Allure в браузере:
mvn allure:serve


Последняя версия Chrome Версия 127.0.6533.73 (Официальная сборка), (arm64) - cromedriver STABLE 126.0.6478.182
ПоследняяВерсия Yandex Browser 24.6.3.742 (64-bit) - cromedriver (он же yandexdriver) STABLE 124.0.6367.742 