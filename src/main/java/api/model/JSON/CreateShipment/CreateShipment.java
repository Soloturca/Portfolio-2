package api.model.JSON.CreateShipment;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CreateShipment {

    @JsonProperty("shipmentRefNo")
    public String getShipmentRefNo() {
        return this.shipmentRefNo;
    }

    public void setShipmentRefNo(String shipmentRefNo) {
        this.shipmentRefNo = shipmentRefNo;
    }

    String shipmentRefNo;

    @JsonProperty("shipmentCompany")
    public String getShipmentCompany() {
        return shipmentCompany;
    }

    public void setShipmentCompany(String shipmentCompany) {
        this.shipmentCompany = shipmentCompany;
    }

    String shipmentCompany;

    @JsonProperty("shipmentPayer")
    public String getShipmentPayer() {
        return shipmentPayer;
    }

    public void setShipmentPayer(String shipmentPayer) {
        this.shipmentPayer = shipmentPayer;
    }

    String shipmentPayer;

    @JsonProperty("customerShip")
    public Boolean getCustomerShip() {
        return customerShip;
    }

    public void setCustomerShip(Boolean customerShip) {
        this.customerShip = customerShip;
    }

    Boolean customerShip;


    @JsonProperty("fromAddress")
    public FromAddress getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(FromAddress fromAddress) {
        this.fromAddress = fromAddress;
    }

    FromAddress fromAddress;

    @JsonProperty("toAddress")
    public ToAddress getToAddress() {
        return toAddress;
    }

    public void setToAddress(ToAddress toAddress) {
        this.toAddress = toAddress;
    }

    ToAddress toAddress;

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    List<Item> items;

}