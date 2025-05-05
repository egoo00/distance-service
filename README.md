# Distance Service

REST-сервис для расчета расстояния между городами с использованием Spring Boot и PostgreSQL.

## Технологии
- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- PostgreSQL
- Maven

## Архитектура
![Архитектура](architecture.png) <!-- Если есть диаграмма -->

- **Слои приложения**:
  1. **Controller**: Обработка HTTP-запросов (`DistanceController`).
  2. **Service**: Бизнес-логика (расчет расстояния).
  3. **Repository**: Работа с БД через Spring Data JPA.
  4. **Entity**: Сущности базы данных.

## Запуск
1. Установите PostgreSQL и создайте БД:
   ```sql
   CREATE DATABASE distance_db;
