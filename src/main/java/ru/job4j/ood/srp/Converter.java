package ru.job4j.ood.srp;

public interface Converter {

     /**
     *      Конвертер считывает информацию из файла (1)
     *      Преобразовывает данные
     *      сохраняет результат (2)
     *      сохраняет информацию о сессии (3)
     */

    Integer scannerIn(String file);
    Integer convert(int x);
    void saveToFile(String path);
    void log();

}