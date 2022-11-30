
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
    "md",
    "cavv",
    "eci",
    "xid",
    "transactionId"
})

public class Secure3DInfo {

    @JsonProperty("md")
    private String md;
    @JsonProperty("cavv")
    private String cavv;
    @JsonProperty("eci")
    private String eci;
    @JsonProperty("xid")
    private String xid;
    @JsonProperty("transactionId")
    private String transactionId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("md")
    public String getMd() {
        return md;
    }

    @JsonProperty("md")
    public void setMd(String md) {
        this.md = md;
    }

    @JsonProperty("cavv")
    public String getCavv() {
        return cavv;
    }

    @JsonProperty("cavv")
    public void setCavv(String cavv) {
        this.cavv = cavv;
    }

    @JsonProperty("eci")
    public String getEci() {
        return eci;
    }

    @JsonProperty("eci")
    public void setEci(String eci) {
        this.eci = eci;
    }

    @JsonProperty("xid")
    public String getXid() {
        return xid;
    }

    @JsonProperty("xid")
    public void setXid(String xid) {
        this.xid = xid;
    }

    @JsonProperty("transactionId")
    public String getTransactionId() {
        return transactionId;
    }

    @JsonProperty("transactionId")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
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
