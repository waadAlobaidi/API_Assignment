package pojos;

import org.testng.annotations.Test;

public class JsonPlaceHolderPojo {
    private Integer userId;
    private String title;
    private Boolean complated;

    public JsonPlaceHolderPojo(){

    }

    public JsonPlaceHolderPojo(String title) {
        this.title = title;
    }

    public JsonPlaceHolderPojo(Integer userId) {
        this.userId = userId;
    }

    public JsonPlaceHolderPojo(Boolean complated) {
        this.complated = complated;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getComplated() {
        return complated;
    }



    }

