import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

public class PasswordHasher {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        String password = "theSingleworstPassevar!1!1";
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        byte[] hash = factory.generateSecret(spec).getEncoded();
        String password2 = "theSingleworstPassevar!1!!";
        KeySpec spec2 = new PBEKeySpec(password2.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory2 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash2 = factory2.generateSecret(spec2).getEncoded();
        System.out.println(Arrays.equals(hash, hash2) ? "match" : "no match");
    }

    }
