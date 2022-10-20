package api.model.JSON.UpdateStatus.RateAndComment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InsertRateComment {
    @JsonProperty("uuid")
    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    String uuid;

    @JsonProperty("variantCode")
    public String getVariantCode() {
        return this.variantCode;
    }

    public void setVariantCode(String variantCode) {
        this.variantCode = variantCode;
    }

    String variantCode;

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

    @JsonProperty("height")
    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    String height;

    @JsonProperty("weight")
    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    String weight;
}
