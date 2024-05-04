package pojos;

public class ContactListAddUserPojo{
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public ContactListAddUserPojo() {
    }

    public ContactListAddUserPojo(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public String toString(){
        return
                "ContactListAddUserPojo{" +
                        "firstName = '" + firstName + '\'' +
                        ",lastName = '" + lastName + '\'' +
                        ",password = '" + password + '\'' +
                        ",email = '" + email + '\'' +
                        "}";
    }
}