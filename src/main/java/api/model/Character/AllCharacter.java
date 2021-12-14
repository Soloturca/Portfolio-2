package api.model.Character;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AllCharacter
{
    @JsonProperty("info")
    public Info info;
    @JsonProperty("results")
    public List<Result> results = null;
    @JsonProperty("error")
    public String error;
    /**
     * No args constructor for use in serialization
     *
     */
    public AllCharacter() {
    }

    /**
     *
     * @param results
     * @param info
     */
    public AllCharacter(Info info, List<Result> results,String error) {
        super();
        this.info = info;
        this.results = results;
        this.error=error;
    }
}
