package api.model.JSON.UpdateStatus.RateAndComment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetRateAndComment {

    @JsonProperty("uuid")
    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    String uuid;

    @JsonProperty("variantCode")
    public String getVariantCode() {
        return this.variantCode;
    }

    public void setVariantCode(String variantCode) {
        this.variantCode = variantCode;
    }

    String variantCode;
}
