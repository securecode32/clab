import     java.math.BigInteger; 
import java.security.MessageDigest;
import  java.security.NoSuchAlgorithmException;

 
class SHA {
public static String getSHA(String input)
{
try {


MessageDigest hash = MessageDigest.getInstance("SHA-256");


byte[] messageDigest = hash.digest(input.getBytes());


BigInteger no = new BigInteger(1, messageDigest);


String hashtext = no.toString(16);
while (hashtext.length() < 32) { hashtext = "0" + hashtext;
}
return hashtext;
}


catch (NoSuchAlgorithmException e) {
throw new RuntimeException(e);
}
}


public static void main(String args[]) throws NoSuchAlgorithmException
{
String s = "Computer";
System.out.println("Your HashCode Generated by SHA is: " + getSHA(s));
}
}