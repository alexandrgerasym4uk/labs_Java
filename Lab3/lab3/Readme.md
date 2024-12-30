# Лабораторна робота 3
# Annotation Processors

## Автор
Герасимчук Олександр Група ІО-25

## Функціональні можливості
- Створення власних анотацій:
@Serializable для позначення класів, які підлягають серіалізації.
@FieldMapping для мапінгу полів Java-класів на імена, які будуть використовуватись у JSON/XML.

- Серіалізація об''єктів:
Серіалізація об’єктів класів Book, Person, Product у формати JSON та XML.
Автоматичне використання мапінгу, заданого через анотації.

- Типізовані генератори:
BookXMLGenerator, PersonJsonGenerator, ProductXMLGenerator для легкого доступу до серіалізації.

- Демонстрація:
У класі Main реалізовано приклади використання генераторів для серіалізації трьох різних класів.

## Інструкції для збірки та запуску
1. **Клонуйте репозиторій:**
   ```
   git clone https://github.com/alexandrgerasym4uk/labs_Java
   cd .\labs_Java\Lab3\lab3\
   ```

3. **Скомпілюйте проект**
   ```
   mvn compile
   ```

5. **Запустіть програму**
   ```
   mvn exec:java
   ```