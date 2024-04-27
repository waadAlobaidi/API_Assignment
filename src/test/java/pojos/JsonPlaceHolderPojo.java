package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.testng.annotations.Test;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceHolderPojo {
    private int id;
    private String name;
    private String status;

    public JsonPlaceHolderPojo() {

    }

    public JsonPlaceHolderPojo(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    // Getters and setters
    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    @Override
    public String toString() {
        return "PetPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}