# Distance Service

Простой REST-сервис для расчета расстояния между городами. Сделано на коленке, но работает! 😎

## Технологии

*   Java 17 (ну а что еще?)
*   Spring Boot (куда ж без него)
*   Maven (собирает все это дело)
*   PostgreSQL (храним координаты городов)

## Задача

Надо было сделать сервис, который принимает названия двух городов и возвращает расстояние между ними. Вот и сделал.

## Как запустить

1.  Убедитесь, что у вас установлен PostgreSQL и создана база данных `distance_db`.
    ```sql
    CREATE DATABASE distance_db;
    ```
2.  Клонируйте репозиторий:
    ```bash
    git clone <ваш_репозиторий>
    cd distance-service
    ```
3.  Соберите проект с помощью Maven:
    ```bash
    mvn clean install
    ```
4.  Запустите приложение:
    ```bash
    mvn spring-boot:run
    ```
5.  Проверьте, что все работает, перейдя в браузере по адресу:
    ```
    http://localhost:8080/distance?city1=Minsk&city2=Moscow
    ```
    В ответ должен прийти JSON с расстоянием между Минском и Москвой (или ошибкой, если города не найдены).

## API

*   `GET /distance?city1={city1}&city2={city2}` - возвращает расстояние между городами `city1` и `city2` в формате JSON.

    Пример:

    ```json
    {
      "city1": "Minsk",
      "city2": "Moscow",
      "distance": 666,
      "unit": "km"
    }
    ```

## Структура проекта

*   `model/City.java` - Модель данных для города (если используете БД).
*   `repository/CityRepository.java` - Интерфейс для работы с городами в БД (если используете Spring Data JPA).
*   `service/DistanceService.java` - Класс для расчета расстояния между городами (бизнес-логика).
*   `controller/DistanceController.java` - Контроллер для обработки HTTP-запросов.
*   `Application.java` - Основной класс приложения.

## TODO

*   Реализовать нормальный расчет расстояния (сейчас там хардкод).
*   Добавить обработку ошибок.
*   Покрыть тестами (если будет время).
*   Сделать нормальный README (это так, набросок).

## .gitignore

В `.gitignore` добавлены файлы, которые не нужно коммитить в репозиторий (например, файлы сборки, логи и т.д.).

## Дерево файлов

distance-service/
├── .gitignore
├── pom.xml
├── src/
│ └── main/
│ ├── java/
│ │ └── com/
│ │ └── example/
│ │ └── distanceservice/
│ │ ├── Application.java
│ │ ├── controller/
│ │ │ └── DistanceController.java
│ │ ├── model/
│ │ │ └── City.java (если используете БД)
│ │ ├── repository/
│ │ │ └── CityRepository.java (если используете Spring Data JPA)
│ │ └── service/
│ │ └── DistanceService.java
│ └── resources/
│ ├── application.properties (или application.yml)
└── README.md
