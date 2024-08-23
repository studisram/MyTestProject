package org.example;

import java.lang.annotation.*;

// Определяем аннотацию @Loggable, которая будет доступна
// во время выполнения и применима к методам

// @Retention — определяет политику удержания аннотации (когда аннотация доступна).
@Retention(RetentionPolicy.RUNTIME)
// @Target — определяет, к каким элементам программы может быть применена
@Target(ElementType.METHOD)

// @interface — это ключевое слово, которое используется для определения новой аннотации.
//
//Loggable — это имя аннотации.
public @interface Loggable {
}
