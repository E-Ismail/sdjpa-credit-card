package guru.springframework.creditcard.service;

/**
 * @author E.I.
 * <p>
 * {@code @Date}  5/14/2023
 */
public interface EncryptionService {
    String encrypt(String freetext);

    String decrypt(String encryptedText);
}
