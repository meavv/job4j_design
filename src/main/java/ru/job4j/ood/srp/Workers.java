package ru.job4j.ood.srp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "workers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Workers {

    private List<Employee> employee;

    public Workers() {
    }

    public Workers(List<Employee> employee) {
        this.employee = employee;
    }

    public List<Employee> getWorkers() {
        return employee;
    }

    public void setWorkers(List<Employee> workers) {
        this.employee = workers;
    }
}
