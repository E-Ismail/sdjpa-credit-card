package guru.springframework.creditcard.service;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author E.I.
 * <p>
 * {@code @Date}  5/14/2023
 */
@Service
public class EncryptionServiceImpl implements EncryptionService {
    @Override
    public String encrypt(String freetext) {
        return Base64.getEncoder().encodeToString(freetext.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String decrypt(String encryptedText) {
        return new String(Base64.getDecoder().decode(encryptedText));
    }
}
