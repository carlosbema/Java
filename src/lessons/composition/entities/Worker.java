package lessons.composition.entities;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.ZoneId;

import lessons.composition.enums.WorkerLevel;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(){}

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }
    
    public double income(int year, int month) {
        double sum = baseSalary;
        for (HourContract c : contracts) {
            LocalDate contractDate = c.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (contractDate.getYear() == year && contractDate.getMonthValue() == month) {
                sum += c.totalValue();
            }
        }
        return sum;
    }
}
