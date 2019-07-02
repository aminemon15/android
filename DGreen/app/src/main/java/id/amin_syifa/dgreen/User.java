package id.amin_syifa.dgreen;
import java.util.Date;

public class User {
    String username;
    String fullName;
    Date sessionExpiryDate;

    public void setUsername(String username){
        this.username  = username ;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public String getUsername(){
        return username;
    }

    public String getFullname(){
        return fullName;
    }

    public Date getSessionExpiryDate(){
        return sessionExpiryDate;
    }

    public void setSessionExpiryDate(Date sessionExpiryDate) {
        this.sessionExpiryDate = sessionExpiryDate;
    }
}
