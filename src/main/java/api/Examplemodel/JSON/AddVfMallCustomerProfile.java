package api.Examplemodel.JSON;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddVfMallCustomerProfile {

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("surname")
    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    String surname;

    @JsonProperty("contactNumber")
    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    String contactNumber;

    @JsonProperty("msisdn")
    public String getMsisdn() {
        return this.msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    String msisdn;

    @JsonProperty("city")
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    String city;

    @JsonProperty("district")
    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    String district;

    @JsonProperty("addressTitle")
    public String getAddressTitle() {
        return this.addressTitle;
    }

    public void setAddressTitle(String addressTitle) {
        this.addressTitle = addressTitle;
    }

    String addressTitle;

    @JsonProperty("detailedAddress")
    public String getDetailedAddress() {
        return this.detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    String detailedAddress;
}
