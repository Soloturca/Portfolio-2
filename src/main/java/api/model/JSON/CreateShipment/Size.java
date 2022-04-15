package api.model.JSON.CreateShipment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Size {

    @JsonProperty("deci")
    public Integer getDeci() {
        return deci;
    }

    public void setDeci(Integer deci) {
        this.deci = deci;
    }

    Integer deci;
}