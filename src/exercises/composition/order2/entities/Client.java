package exercises.composition.order2.entities;

import java.util.Date;

public class Client {
    private String name;
    private String email;
    private Date birtDate;

    public Client(){
    }

    public Client(String name, String email, Date birtDate) {
        this.name = name;
        this.email = email;
        this.birtDate = birtDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirtDate() {
        return birtDate;
    }

    public void setBirtDate(Date birtDate) {
        this.birtDate = birtDate;
    }
}
