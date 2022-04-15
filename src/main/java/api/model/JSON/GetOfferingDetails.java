package api.model.JSON;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetOfferingDetails {

    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    String uuid;

}
