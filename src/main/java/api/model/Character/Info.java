package api.model.Character;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Info
{
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("pages")
    private Integer pages;
    @JsonProperty("next")
    private String next;
    @JsonProperty("prev")
    private Object prev;

    /**
     * No args constructor for use in serialization
     *
     */
    public Info() {
    }

    /**
     *
     * @param next
     * @param pages
     * @param prev
     * @param count
     */
    public Info(Integer count, Integer pages, String next, Object prev) {
        super();
        this.count = count;
        this.pages = pages;
        this.next = next;
        this.prev = prev;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("pages")
    public Integer getPages() {
        return pages;
    }

    @JsonProperty("pages")
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @JsonProperty("next")
    public String getNext() {
        return next;
    }

    @JsonProperty("next")
    public void setNext(String next) {
        this.next = next;
    }

    @JsonProperty("prev")
    public Object getPrev() {
        return prev;
    }

    @JsonProperty("prev")
    public void setPrev(Object prev) {
        this.prev = prev;
    }

}
