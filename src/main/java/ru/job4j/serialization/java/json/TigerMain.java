package ru.job4j.serialization.java.json;

import ru.job4j.serialization.java.json.Animal;
import ru.job4j.serialization.java.json.Tiger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class TigerMain {
    public static void main(String[] args) throws Exception {
        Tiger tiger = new Tiger(true, 12, "Qwe", new Animal("Cat"), "Russia", "China");
        JAXBContext context = JAXBContext.newInstance(Tiger.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(tiger, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader stringReader = new StringReader(xml)) {
            Tiger rsl = (Tiger) unmarshaller.unmarshal(stringReader);
            System.out.println(rsl);
        }
    }
}
