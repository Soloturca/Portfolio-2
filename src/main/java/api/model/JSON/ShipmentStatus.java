package api.model.JSON;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShipmentStatus {

    @JsonProperty("shipmentCompany")
    public String getShipmentCompany() {
        return this.shipmentCompany;
    }

    public void setShipmentCompany(String shipmentCompany) {
        this.shipmentCompany = shipmentCompany;
    }

    String shipmentCompany;


    @JsonProperty("shipmentRefNo")
    public String getShipmentRefNo() {
        return this.shipmentRefNo;
    }

    public void setShipmentRefNo(String shipmentRefNo) {
        this.shipmentRefNo = shipmentRefNo;
    }

    String shipmentRefNo;
}
