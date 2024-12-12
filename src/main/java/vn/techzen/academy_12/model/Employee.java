package vn.techzen.academy_12.model;

import java.time.LocalDate;

public class Employee {
    private String id;
    private String name;
    private LocalDate birthDate; // Đổi từ Date sang LocalDate
    private double salary;
    private Gender gender;
    private String phone;

    public Employee() {}

    public Employee(String id, String name, LocalDate birthDate, double salary, Gender gender, String phone) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.salary = salary;
        this.gender = gender;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
