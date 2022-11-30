
package api.paytionPojo;

import java.util.HashMap;
import java.util.Map;



import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pan",
    "expire",
    "cvv"
})

public class Card {

    @JsonProperty("pan")
    private String pan;
    @JsonProperty("expire")
    private String expire;
    @JsonProperty("cvv")
    private String cvv;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("pan")
    public String getPan() {
        return pan;
    }

    @JsonProperty("pan")
    public void setPan(String pan) {
        this.pan = pan;
    }

    @JsonProperty("expire")
    public String getExpire() {
        return expire;
    }

    @JsonProperty("expire")
    public void setExpire(String expire) {
        this.expire = expire;
    }

    @JsonProperty("cvv")
    public String getCvv() {
        return cvv;
    }

    @JsonProperty("cvv")
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
