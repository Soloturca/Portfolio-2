package api.model.JSON.CreateVFMallOffering;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Parameter {

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

   String code;

    @JsonProperty("value")
    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    List<String> value = null;

    @JsonProperty("isVariant")
    public Boolean getIsVariant() {
        return isVariant;
    }

    public void setIsVariant(Boolean isVariant) {
        this.isVariant = isVariant;
    }

    Boolean isVariant;

    @JsonProperty("parameterTypeCode")
    public String getParameterTypeCode() {
        return parameterTypeCode;
    }

    public void setParameterTypeCode(String parameterTypeCode) {
        this.parameterTypeCode = parameterTypeCode;
    }

    String parameterTypeCode;

}