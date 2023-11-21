package br.com.gustavolopes.leadmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name="tb_leads")
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    int cellNumber;
    String email;
    String age;
    double annualIncome;

    public Lead(String name, int cellNumber, String email, String age, double annualIncome) {
        this.name = name;
        this.cellNumber = cellNumber;
        this.email = email;
        this.age = age;
        this.annualIncome = annualIncome;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }
}
