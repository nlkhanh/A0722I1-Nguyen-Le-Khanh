package codegym.model;

import java.util.List;

public class DeclareForm {
    private String name;
    private int birthYear;
    private String gender;
    private String nationality;
    private int id;
    private String movingInfo;
    private String movingId;
    private String seatNumber;
    private int startDay;
    private int startMonth;
    private int startYear;
    private int endDay;
    private int endMonth;
    private int endYear;
    private String recentMove;
    private String province;
    private String district;
    private String town;
    private String address;
    private String phone;
    private String email;
    private List<String> symptoms;
    private List<String> exposures;

    public DeclareForm() {
    }

    public DeclareForm(String name, int birthYear, String gender, String nationality, int id, String movingInfo, String movingId, String seatNumber, int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear, String recentMove, String province, String district, String town, String address, String phone, String email, List<String> symptoms, List<String> exposures) {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.nationality = nationality;
        this.id = id;
        this.movingInfo = movingInfo;
        this.movingId = movingId;
        this.seatNumber = seatNumber;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.recentMove = recentMove;
        this.province = province;
        this.district = district;
        this.town = town;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.symptoms = symptoms;
        this.exposures = exposures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovingInfo() {
        return movingInfo;
    }

    public void setMovingInfo(String movingInfo) {
        this.movingInfo = movingInfo;
    }

    public String getMovingId() {
        return movingId;
    }

    public void setMovingId(String movingId) {
        this.movingId = movingId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getRecentMove() {
        return recentMove;
    }

    public void setRecentMove(String recentMove) {
        this.recentMove = recentMove;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public List<String> getExposures() {
        return exposures;
    }

    public void setExposures(List<String> exposures) {
        this.exposures = exposures;
    }
}
