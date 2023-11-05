package guru.springframework.creditcard.domain;

import guru.springframework.creditcard.config.SpringContextHelper;
import guru.springframework.creditcard.service.EncryptionService;
import jakarta.persistence.*;

/**
 * Created by EI on 11/5/2023
 */
public class CreditCardJPACallback {

    @PrePersist
    @PreUpdate
    public void beforeInsertOrUpdate(CreditCard cc){
        System.out.println("before update was called...");
        cc.setCreditCardNumber(getEncryptionService().encrypt(cc.getCreditCardNumber()));
    }

    @PostPersist
    @PostLoad
    @PostUpdate
    public void postLoad(CreditCard cc){
        System.out.println("postLoad was called...");
        cc.setCreditCardNumber(getEncryptionService().decrypt(cc.getCreditCardNumber()));
    }

    private EncryptionService getEncryptionService(){
        return SpringContextHelper.getApplicationContext().getBean(EncryptionService.class);
    }
}
