package edu.ti.caih313.collections.dataobj;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class EmailAddress {
    public enum Type {HOME, WORK, SCHOOL};
    Map<Type, String> emailMap = new HashMap<>();

    public EmailAddress(String emailAddress, Type type) {
        if (!valid(emailAddress)) {
            throw new InvalidParameterException("Email address not valid: '" + emailAddress + "'");
        }
        emailMap.put(type, emailAddress);
    }
    public EmailAddress(){

    }
    public Map<Type, String> getEmailMap(){
        return emailMap;
    }

    public String getEmailAddress() {
        return getPrimaryEmailAddress();
    }

    private String getPrimaryEmailAddress() {
        String primaryEmailAddress = null;
        if (emailMap.containsKey(Type.HOME)) {
            primaryEmailAddress = emailMap.get(Type.HOME);
        } else if (emailMap.containsKey(Type.WORK)) {
            primaryEmailAddress = emailMap.get(Type.WORK);
        } else if (emailMap.containsKey(Type.SCHOOL)) {
            primaryEmailAddress = emailMap.get(Type.SCHOOL);
        }
        return primaryEmailAddress;
    }

    public String getEmailAddress(Type type) {
        String emailAddress = emailMap.get(type);
        if(emailMap.get(type) == null){
          emailAddress = "<no email address available>";
        }
        return emailAddress;
    }

    private boolean valid(String emailAddress) {
        return (emailAddress != null) && emailAddress.contains("@");
    }
    public String toString(){
        StringBuilder toString = new StringBuilder("<HOME:")
                .append(getEmailAddress(Type.HOME))
                .append(", SCHOOL:")
                .append(getEmailAddress(Type.SCHOOL))
                .append(", WORK:")
                .append(getEmailAddress(Type.WORK))
                .append(">");
        return toString.toString();
    }
}
