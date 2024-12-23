package com.example.customobject;

public class Employee {
    private int empid;
    private String ename;
    private float sal;

    public Employee(int empid, String ename, float sal) {
        this.empid = empid;
        this.ename = ename;
        this.sal = sal;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public float getSal() {
        return sal;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }

}
