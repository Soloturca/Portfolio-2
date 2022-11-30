
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
    "city",
    "branch",
    "teller",
    "user"
})

public class OriginatorInfo {

    @JsonProperty("city")
    private Integer city;
    @JsonProperty("branch")
    private String branch;
    @JsonProperty("teller")
    private String teller;
    @JsonProperty("user")
    private String user;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("city")
    public Integer getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(Integer city) {
        this.city = city;
    }

    @JsonProperty("branch")
    public String getBranch() {
        return branch;
    }

    @JsonProperty("branch")
    public void setBranch(String branch) {
        this.branch = branch;
    }

    @JsonProperty("teller")
    public String getTeller() {
        return teller;
    }

    @JsonProperty("teller")
    public void setTeller(String teller) {
        this.teller = teller;
    }

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
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
