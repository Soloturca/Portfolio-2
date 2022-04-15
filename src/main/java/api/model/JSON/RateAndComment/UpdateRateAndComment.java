package api.model.JSON.RateAndComment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateRateAndComment {

    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

    @JsonProperty("rate")
    public int getRate() {
        return this.rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    int rate;

    @JsonProperty("title")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String title;

    @JsonProperty("status")
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String status;

    @JsonProperty("comment")
    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    String comment;

    @JsonProperty("hideMyName")
    public boolean getHideMyName() {
        return this.hideMyName;
    }

    public void setHideMyName(boolean hideMyName) {
        this.hideMyName = hideMyName;
    }

    boolean hideMyName;
}
