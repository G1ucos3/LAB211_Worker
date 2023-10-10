package model;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Worker {

    private String code;
    private String name;
    private int age;
    private double salary;
    private String workLocation;
    private String status;
    private Date date;

    private List<Worker> wl = new ArrayList<>();

    public Worker() {
    }

    public Worker(String code, String name, int age, double salary, String workLocation, String status, Date date) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
        this.status = status;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Worker> getWl() {
        return wl;
    }

    public void setWl(List<Worker> wl) {
        this.wl = wl;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%-7s%-15s%-7d%-15.2f%-15s%-10s%s",
                this.getCode(), this.getName(),
                this.getAge(), this.getSalary(),
                this.getWorkLocation(), this.getStatus(),
                sdf.format(this.getDate()));
    }
}
