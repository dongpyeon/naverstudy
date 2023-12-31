package test.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import test.dto.TestmemberDto;

public class HashService {

    public static void hashAndSetPassword(TestmemberDto dto, String password) {
        String hashedPassword = hashPassword(password);

        dto.setPass(hashedPassword);
    }

    public static boolean checkPassword(String rawPassword, String hashedPassword) {
        String inputHash = hashPassword(rawPassword);
        return inputHash.equals(hashedPassword);
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password.", e);
        }
    }
}
