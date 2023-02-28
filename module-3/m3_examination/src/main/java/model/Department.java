package model;

import java.sql.Date;

public class Department {
    private int id;
    private String code;
    private double area;
    private String status;
    private int floor;
    private String type;
    private String detail;
    private double cost;
    private Date startDate;
    private Date endDate;

    public Department() {
    }

    public Department(int id, String code, double area, String status, int floor, String type, String detail, double cost, Date startDate, Date endDate) {
        this.id = id;
        this.code = code;
        this.area = area;
        this.status = status;
        this.floor = floor;
        this.type = type;
        this.detail = detail;
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Department(String code, double area, String status, int floor, String type, String detail, double cost, Date startDate, Date endDate) {
        this.code = code;
        this.area = area;
        this.status = status;
        this.floor = floor;
        this.type = type;
        this.detail = detail;
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
