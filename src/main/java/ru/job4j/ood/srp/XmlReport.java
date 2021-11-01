package ru.job4j.ood.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.function.Predicate;

public class XmlReport implements Report {

    private Store store;

    public XmlReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = "";
            try {
                JAXBContext context = JAXBContext.newInstance(Workers.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                StringWriter writer = new StringWriter();
                marshaller.marshal(new Workers(store.findBy(filter)), writer);
                xml = writer.getBuffer().toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        return xml;
    }

}
