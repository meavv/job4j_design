package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void test() throws IOException {
        Analizy analizy = new Analizy();
        File source = folder.newFile("sourceTest.txt");
        File target = folder.newFile("targetTest.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01\n" + "500 10:57:01\n"
                    + "400 10:58:01\n"
                    + "500 10:59:01\n"
                    + "400 11:01:02\n"
                    + "200 11:02:02");
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(rsl.toString(), is("10:57:01" + "11:01:02"));
    }

}