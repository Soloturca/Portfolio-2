package api.Examplemodel.JSON.updateStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderStatusRequest {

    @JsonProperty("orderId")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    String orderId;

    @JsonProperty("reasonCode")
    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    String reasonCode;

    @JsonProperty("reasonText")
    public String getReasonText() {
        return reasonText;
    }

    public void setReasonText(String reasonText) {
        this.reasonText = reasonText;
    }

    String reasonText;

}