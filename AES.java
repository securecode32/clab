import  java.util.Base64;
 import javax.crypto.Cipher;
 import javax.crypto.KeyGenerator;
 import javax.crypto.SecretKey;

class AesEncrypter { 
Cipher ecipher;

Cipher dcipher;

AesEncrypter(SecretKey key) throws Exception { 
ecipher = Cipher.getInstance("AES");
dcipher = Cipher.getInstance("AES"); 
ecipher.init(Cipher.ENCRYPT_MODE, key);
dcipher.init(Cipher.DECRYPT_MODE, key);
}

public String encrypt(String str) throws Exception {

byte[] utf8 = str.getBytes("UTF8");


byte[] enc = ecipher.doFinal(utf8);


 return Base64.getEncoder().encodeToString(enc);
}

public String decrypt(String str) throws Exception {

 byte[] dec = Base64.getDecoder().decode(str);

byte[] utf8 = dcipher.doFinal(dec);


return new String(utf8, "UTF8");
}
}

public class AES {
public   static   void   main(String[]   argv)   throws   Exception   { 
SecretKey key = KeyGenerator.getInstance("AES").generateKey(); 
AesEncrypter encrypter = new AesEncrypter(key);
 
String encrypted = encrypter.encrypt("Don't tell anybody!");
System.out.println(encrypted);
String decrypted = encrypter.decrypt(encrypted); 
System.out.println(decrypted);
}
}