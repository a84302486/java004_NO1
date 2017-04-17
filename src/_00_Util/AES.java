package _00_Util;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
 
import org.apache.commons.codec.binary.Base64;
 
public class AES {

	private static String key1 = "Bar12345Bar12345"; 
	private static String key2 = "ThisIsASecretKet";
	
    public static String encrypt(String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(key2.getBytes("UTF-8"));
 
            SecretKeySpec skeySpec = new SecretKeySpec(key1.getBytes("UTF-8"),
                    "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(value.getBytes());
//            System.out.println("encrypted string:"
//                    + Base64.encodeBase64String(encrypted));
            
            System.out.println("AES加密完成");
            return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
 
    public static String decrypt(String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(key2.getBytes("UTF-8"));
 
            SecretKeySpec skeySpec = new SecretKeySpec(key1.getBytes("UTF-8"),
                    "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
            
//            System.out.println(new String(original));
            System.out.println("AES解密完成");
            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
 

}
