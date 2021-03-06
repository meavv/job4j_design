package ru.job4j.ood.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        String expect = "Name; Hired; Fired; Salary;"
                + System.lineSeparator()
                + worker.getName() + ";"
                + worker.getHired() + ";"
                + worker.getFired() + ";"
                + worker.getSalary() + ";"
                + System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenHtmlGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        HtmlReport htmlReport = new HtmlReport(store);
        String expect =
                System.lineSeparator() + "<html>" + System.lineSeparator() + "<body>"
                + System.lineSeparator() + "<h1>Report<h1>" + System.lineSeparator() + "<p name Ivan>"
                + System.lineSeparator() + "<p hired " + worker.getHired().getTime() + ">" + System.lineSeparator()
                + "<p fired " + worker.getFired().getTime() + ">" + System.lineSeparator()
                + "<p salary 100.0>" + System.lineSeparator() + "</body>" + System.lineSeparator() + "</html>";
        assertThat(htmlReport.generate(em -> true), is(expect));
    }

    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Qwe", now, now, 500);
        Employee worker3 = new Employee("Rtx", now, now, 1000);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        HRReport engine = new HRReport(store);
        String expect = "Name; Salary;" + System.lineSeparator() + worker3.getName() + ";"
                + worker3.getSalary() + ";" + System.lineSeparator() + worker2.getName() + ";"
                + worker2.getSalary() + ";" + System.lineSeparator() + worker1.getName() + ";"
                + worker1.getSalary() + ";";
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenBuhGenerated() {
        MemStore store = new MemStore();
        ConvertSalary convertSalary = new Convert();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        BuhReport engine = new BuhReport(store, convertSalary);
        String expect = "Name; Hired; Fired; Salary;"
                + System.lineSeparator()
                + worker.getName() + ";"
                + worker.getHired() + ";"
                + worker.getFired() + ";"
                + worker.getSalary() * 0.85 + ";"
                + System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenJsonGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Gson gson = new GsonBuilder().create();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        JsonReport engine = new JsonReport(store);
        assertThat(engine.generate(em -> true), is(gson.toJson(store.findBy(a -> true))));
    }

    @Test
    public void whenXmlGenerated() {
        MemStore store = new MemStore();
        String xml = "";
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        XmlReport engine = new XmlReport(store);
        try {
            JAXBContext context = JAXBContext.newInstance(Workers.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            marshaller.marshal(new Workers(store.findBy(a -> true)), writer);
            xml = writer.getBuffer().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThat(engine.generate(em -> true), is(xml));
    }
}