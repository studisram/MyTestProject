package org.example;

import java.lang.reflect.*;

public class LoggingAspect {
    // Создаем экземпляр класса Logger для логирования
    private Logger logger = new Logger();

    // Метод для логирования вызова метода с использованием аннотации @Loggable
    public void logMethodCall(Method method, Object[] args){
        // Создаем StringBuilder для формирования сообщения
        StringBuilder logMessage = new StringBuilder();

        // Добавляем имя метода
        logMessage.append("Method: ").append(method.getName());

        // Добавляем текст
        logMessage.append(" called with arguments:  ");
        for (Object arg : args){ // Перебираем аргументы метода
            logMessage.append(arg).append(", "); // Добавляем каждый аргумент к сообщению
        }
        logger.logInfo(logMessage.toString()); // Логируем сообщение с уровнем "INFO"
    }
}
