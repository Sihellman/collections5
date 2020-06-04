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
        //do nothing. This constructor is here so that EmailAddress methods can be called on Person's getEmail
        //if Person's getEmail is null
    }
    public  Map<Type, String> getEmailMap(){
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
        return emailMap.get(type);
        
    }

    private boolean valid(String emailAddress) {
        return (emailAddress != null) && emailAddress.contains("@");
    }

    public String toString(){
        String string;
        if(getEmailAddress() != null){
            StringBuilder toString = new StringBuilder("<");
            if(emailMap.get(Type.HOME) != null){
                toString.append("HOME: ")
                        .append(emailMap.get(Type.HOME))
                        .append(", ");
            }
            if(emailMap.get(Type.WORK) != null){
                toString.append("WORK: ")
                        .append(emailMap.get(Type.WORK))
                        .append(", ");
            }
            if(emailMap.get(Type.SCHOOL) != null){
                toString.append("SCHOOL: ")
                        .append(emailMap.get(Type.SCHOOL))
                        .append(", ");
            }
            toString.append(">");
            toString.delete(toString.length()-3, toString.length()-1);
            string =toString.toString();
        }
        else{
           string = "<no email address available>";
        }
        return string;
    }
}
