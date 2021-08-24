package medical_declaration.model.bean;

public class MedicalDeclaration {
    private String name;
    private String dateOfBirth;
    private String cardId;
    private String travelInformation;
    private String travelCity;
    private String address;
    private String home;
    private String phoneNumber;
    private String email;
    private String [] sympathy;
    private String [] exposure;

    public MedicalDeclaration(String name, String dateOfBirth, String cardId, String travelInformation,
                              String travelCity, String address, String home, String phoneNumber,
                              String email, String[] sympathy, String[] exposure) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.cardId = cardId;
        this.travelInformation = travelInformation;
        this.travelCity = travelCity;
        this.address = address;
        this.home = home;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.sympathy = sympathy;
        this.exposure = exposure;
    }

    public MedicalDeclaration() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getTravelCity() {
        return travelCity;
    }

    public void setTravelCity(String travelCity) {
        this.travelCity = travelCity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getSympathy() {
        return sympathy;
    }

    public void setSympathy(String[] sympathy) {
        this.sympathy = sympathy;
    }

    public String[] getExposure() {
        return exposure;
    }

    public void setExposure(String[] exposure) {
        this.exposure = exposure;
    }
}
