package api.Examplemodel.JSON.shoppingCart;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayShoppingCart {

    @JsonProperty("cardUniqueId")
    public String getCardUniqueId() {
        return cardUniqueId;
    }

    public void setCardUniqueId(String cardUniqueId) {
        this.cardUniqueId = cardUniqueId;
    }

    String cardUniqueId;


    @JsonProperty("masterpassTokenId")
    public String getMasterpassTokenId() {
        return masterpassTokenId;
    }

    public void setMasterpassTokenId(String masterpassTokenId) {
        this.masterpassTokenId = masterpassTokenId;
    }

    String masterpassTokenId;

    @JsonProperty("paymentTokenId")
    public String getPaymentTokenId() {
        return paymentTokenId;
    }

    public void setPaymentTokenId(String paymentTokenId) {
        this.paymentTokenId = paymentTokenId;
    }

    String paymentTokenId;
}
