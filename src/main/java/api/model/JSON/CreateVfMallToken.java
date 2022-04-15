package api.model.JSON;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateVfMallToken {

    @JsonProperty("integratorCode")
    public String getIntegratorCode() {
        return integratorCode;
    }

    public void setIntegratorCode(String integratorCode) {
        this.integratorCode = integratorCode;
    }

    String integratorCode;

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String password;

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    String username;
}
