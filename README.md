# ProjectForBootcamp
```
Приложение представляет собой многомодульный maven проект (3-level three-module development architecture)
```	
Использованы технологии: 	
- Java 17  
-	Log4j2 
-	Spring Boot 3
-	Hibernate 6
-	MySQL 8
```
Архитектурный стиль: REST 
Формат: JSON
Реализована обработка ошибок и постраничный вывод списка пользователей
```
 В приложении предусмотрены следующие страницы и функции:
 1. Добавить пользователя в базу данных
```sh
 (POST) http://localhost:8080/user
  ```
 2. Просмотреть список пользователей: 
```sh
 (GET) http://localhost:8080/user?page=1&size=5
  ```
