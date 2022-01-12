package api.model.JSON.Character;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Origin {
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;

    /**
     * No args constructor for use in serialization
     */
    public Origin() {
    }

    /**
     * @param name
     * @param url
     */
    public Origin(String name, String url) {
        super();
        this.name = name;
        this.url = url;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }
}