/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roman
 */
public class PasswordEncryption {
    private static String getEncriptString(String str, String algoritm){
        if(algoritm == null){
            algoritm = "SHA-256";
        }
        try {
            MessageDigest m = MessageDigest.getInstance(algoritm);
            m.update(str.getBytes(),0,str.length());
            return new BigInteger(1,m.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordEncryption.class.getName()).log(Level.SEVERE, "Ошибка в классе EncriptPass", ex);
        }
        return null;
    }
    
    public static String getEncriptString(String str){
        return getEncriptString(str, null);
    }
    
    public static String getSalts(){
        Date time = new Date();
        String t = Long.toString(time.getTime());
        return getEncriptString(t,"MD5");
    }
}
