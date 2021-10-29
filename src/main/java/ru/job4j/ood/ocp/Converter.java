package ru.job4j.ood.ocp;

import ru.job4j.serialization.java.B;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Converter {


    /**
     * @param rub
     * @return dollar
     * <p>
     * не сможем расширить метод без изменения
     */
    public double convertToDollar(double rub) {
        double rate = 0.014;
        return rub * rate;
    }


    /**
     * @param rsl нет возможности сменить вид save
     *            в базу,в файл, в память
     */
    public void save(String rsl) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data/converterRsl"))) {
            bufferedWriter.write(rsl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param rsl
     * @return отформатированный дабл
     * не сменить тип форматирования,
     * кол-во символом после точки
     */

    public String format(double rsl) {
        return String.format("%.2f", rsl);
    }

    public static void main(String[] args) {
        Converter converter = new Converter();
        converter.save(converter.format(converter.convertToDollar(1000)));
    }
}
