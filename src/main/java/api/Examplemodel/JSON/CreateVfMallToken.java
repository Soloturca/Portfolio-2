package api.Examplemodel.JSON;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "username",
        "password",
        "integratorCode"
})

public class CreateVfMallToken {

    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("integratorCode")
    private String integratorCode;

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("integratorCode")
    public String getIntegratorCode() {
        return integratorCode;
    }

    @JsonProperty("integratorCode")
    public void setIntegratorCode(String integratorCode) {
        this.integratorCode = integratorCode;
    }

}