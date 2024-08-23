package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    // Переменная с путем к файлу лога
    private Path logFile = Paths.get("application.log");

    // Метод для добавления уровня логирования
    public void logInfo(String message){
        log(message, "INFO");
    }

    // Метод для добавления уровня логирования
    public void logWarning(String message){
        log(message, "WARNING");
    }

    // Метод для добавления уровня логирования
    public void logError(String message){
        log(message, "ERROR");
    }

    // Метод для записи логов с указанием уровня
    private void log(String message, String level){
        // Переменная будет в формате ([переменная] [переменная] переменная, перевод строки)
        // Те после "" подставляются значения
        String logEntry = String.format("[%s] [%s] %s%n",
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                level, message);
        try {
            // Записываем строку лога в файл, добавляя её в конец файла или создавая файл,
            // если он не существует
            Files.write(logFile, logEntry.getBytes(), StandardOpenOption.APPEND,
                    StandardOpenOption.CREATE);
        } catch (IOException e) {
            // Обрабатываем исключение ввода/вывода
            e.printStackTrace();
        }
    }

}
