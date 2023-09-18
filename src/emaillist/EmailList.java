package emaillist;

import java.util.ArrayList;

public class EmailList {
    private ArrayList<String> emailAddresses = new ArrayList<>();

    public void addEmail(String email) {
        emailAddresses.add(email);
    }

    public void removeEmail(String email) {
        emailAddresses.remove(email);
    }

    public boolean containsEmail(String email) {
        return emailAddresses.contains(email);
    }

    public ArrayList<String> listEmails() {
        return emailAddresses;
    }
}