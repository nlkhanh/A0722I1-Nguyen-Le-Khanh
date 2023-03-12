package codegym.model;


public class DeclarationForm {
    private String name;
    private String birthYear;
    private String gender;
    private String nationality;
    private String id;
    private String movingInfo;
    private String movingId;
    private String seatNumber;
    private String startDay;
    private String startMonth;
    private String startYear;
    private String endDay;
    private String endMonth;
    private String endYear;
    private String recentMove;
    private String province;
    private String district;
    private String ward;
    private String street;
    private String phone;
    private String email;
    private boolean fever;
    private boolean cough;
    private boolean breathless;
    private boolean soreThroat;
    private boolean vomiting;
    private boolean diarrhea;
    private boolean skinHemorrhage;
    private boolean rash;
    private boolean animalExposure;
    private boolean patientExposure;

    public DeclarationForm() {
    }

    public DeclarationForm(String name, String birthYear, String gender, String nationality, String id, String movingInfo, String movingId, String seatNumber, String startDay, String startMonth, String startYear, String endDay, String endMonth, String endYear, String recentMove, String province, String district, String ward, String street, String phone, String email, boolean fever, boolean cough, boolean breathless, boolean soreThroat, boolean vomiting, boolean diarrhea, boolean skinHemorrhage, boolean rash, boolean animalExposure, boolean patientExposure) {
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
        this.ward = ward;
        this.street = street;
        this.phone = phone;
        this.email = email;
        this.fever = fever;
        this.cough = cough;
        this.breathless = breathless;
        this.soreThroat = soreThroat;
        this.vomiting = vomiting;
        this.diarrhea = diarrhea;
        this.skinHemorrhage = skinHemorrhage;
        this.rash = rash;
        this.animalExposure = animalExposure;
        this.patientExposure = patientExposure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
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

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isBreathless() {
        return breathless;
    }

    public void setBreathless(boolean breathless) {
        this.breathless = breathless;
    }

    public boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public boolean isVomiting() {
        return vomiting;
    }

    public void setVomiting(boolean vomiting) {
        this.vomiting = vomiting;
    }

    public boolean isDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public boolean isSkinHemorrhage() {
        return skinHemorrhage;
    }

    public void setSkinHemorrhage(boolean skinHemorrhage) {
        this.skinHemorrhage = skinHemorrhage;
    }

    public boolean isRash() {
        return rash;
    }

    public void setRash(boolean rash) {
        this.rash = rash;
    }

    public boolean isAnimalExposure() {
        return animalExposure;
    }

    public void setAnimalExposure(boolean animalExposure) {
        this.animalExposure = animalExposure;
    }

    public boolean isPatientExposure() {
        return patientExposure;
    }

    public void setPatientExposure(boolean patientExposure) {
        this.patientExposure = patientExposure;
    }
}
