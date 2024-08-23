package org.example;

import java.lang.reflect.*; // Импортируем классы для работы с рефлексией

public class Main {
    public static void main(String[] args) throws Exception {
        MyService service = new MyService(); // Создаем экземпляр класса MyService
        LoggingAspect aspect = new LoggingAspect(); // Создаем экземпляр класса LoggingAspect

        // Получаем метод doSomething класса MyService
        Method method = MyService.class.getMethod("doSomething", String.class);
        // Проверяем, есть ли у метода аннотация @Loggable
        if (method.isAnnotationPresent(Loggable.class)) {
            // Логируем вызов метода с аргументом "testParam"
            aspect.logMethodCall(method, new Object[]{"testParam"});
        }
        // Вызываем метод doSomething с аргументом "testParam"
        method.invoke(service, "testParam");
    }
}