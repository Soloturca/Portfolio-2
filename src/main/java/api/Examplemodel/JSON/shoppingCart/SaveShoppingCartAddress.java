package api.Examplemodel.JSON.shoppingCart;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveShoppingCartAddress {

    @JsonProperty("msisdn")
    public String getDeliveryAddressId() {
        return this.deliveryAddressId;
    }

    public void setDeliveryAddressId(String deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }

    String deliveryAddressId;

    @JsonProperty("invoiceAddressId")
    public String getInvoiceAddressId() {
        return this.invoiceAddressId;
    }

    public void setInvoiceAddressId(String invoiceAddressId) {
        this.invoiceAddressId = invoiceAddressId;
    }

    String invoiceAddressId;

    @JsonProperty("shoppingCartId")
    public String getShoppingCartId() {
        return this.shoppingCartId;
    }

    public void setShoppingCartId(String shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    String shoppingCartId;
}
