package api.model.Character;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location
{
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;

    /**
     * No args constructor for use in serialization
     *
     */
    public Location() {
    }

    /**
     *
     * @param name
     * @param url
     */
    public Location(String name, String url) {
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
