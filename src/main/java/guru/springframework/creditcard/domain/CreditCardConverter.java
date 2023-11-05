package guru.springframework.creditcard.domain;

import guru.springframework.creditcard.config.SpringContextHelper;
import guru.springframework.creditcard.service.EncryptionService;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Created by EI on 11/5/2023
 */

@Converter
public class CreditCardConverter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String attribute) {
        return getEncryptionService().encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return getEncryptionService().decrypt(dbData);
    }

    private EncryptionService getEncryptionService(){
        return SpringContextHelper.getApplicationContext().getBean(EncryptionService.class);
    }
}
