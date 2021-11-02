package ru.job4j.ood.isp;

public interface File {


    /**
     *
     * если нам нужно только получить файл
     * без изменения, придется реализовать пустой метод
     * то же справедливо для сохранения и
     * вывода инфомрации о файле
     *
     */


    File scan(String path);
    File changeFile(File file);
    File save(File file);
    String fileSize(File file);

}
