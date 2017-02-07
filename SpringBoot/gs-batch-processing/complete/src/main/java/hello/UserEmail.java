package hello;

/**
 * Created by ravikir on 1/27/2017.
 */
public class UserEmail {
    public int  userEmailId;
    public String emailAddress;
    public String emailFormat;

    public UserEmail() {
    }

    public UserEmail(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public UserEmail(String emailAddress, String emailFormat) {
        this.emailAddress = emailAddress;
        this.emailFormat = emailFormat;
    }

    public int getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(int userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailFormat() {
        return emailFormat;
    }

    public void setEmailFormat(String emailFormat) {
        this.emailFormat = emailFormat;
    }

    public String toString() {
        //String message = this.emailAddress + " " + this.emailFormat;
        String message = this.emailAddress;
        return message;
    }
}
