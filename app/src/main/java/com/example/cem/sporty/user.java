package com.example.cem.sporty;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.LinkedList;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Created by balpy on 16.11.2017.
 * User Class
 */

public class user {
    public int userID;
    public String userName;
    public String password;
    public String email;
    public LinkedList bookMarkedEventsList;
    public LinkedList myEventsList;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LinkedList getBookMarkedEventsList() {
        return bookMarkedEventsList;
    }

    public void setBookMarkedEventsList(LinkedList bookMarkedEventsList) {
        this.bookMarkedEventsList = bookMarkedEventsList;
    }

    public LinkedList getMyEventsList() {
        return myEventsList;
    }

    public void setMyEventsList(LinkedList myEventsList) {
        this.myEventsList = myEventsList;
    }

    public user(int userID, String userName, String password_, String email, LinkedList bookMarkedEventsList, LinkedList myEventsList) {
        this.userID = userID;
        this.userName = userName;
        //this.password = get_SHA_256_SecurePassword(password_, salt);
        this.password= generateStrongPasswordHash(password_);
        this.email = email;
        this.bookMarkedEventsList = bookMarkedEventsList;
        this.myEventsList = myEventsList;
    }
    private static String generateStrongPasswordHash(String password){
        int iterations = 1000;
        char[] chars = password.toCharArray();
        try{
            byte[] salt= getSalt();
            PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = skf.generateSecret(spec).getEncoded();
            return iterations + ":" + toHex(salt) + ":" + toHex(hash);
        }catch(NoSuchAlgorithmException e){
            System.err.println("No Such Algorithm Exception: " + e.getMessage());
            return password;
        }catch(InvalidKeySpecException e){
            System.err.println("Invalid Key Exception: " + e.getMessage());
            return password;
        }
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private static String toHex(byte[] array) throws NoSuchAlgorithmException {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }
}
