package com.dgsoft.conversion.component.impl;

import com.dgsoft.conversion.component.EncryptDecrypt;
import com.dgsoft.conversion.config.AESDeConfig;
import com.dgsoft.conversion.config.AESEnConfig;
import com.dgsoft.conversion.config.RSAEnConfig;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

@NoArgsConstructor
@Component
@Service
public class EncryptDecryptImpl implements EncryptDecrypt {
    private static final Logger log = LoggerFactory.getLogger(EncryptDecryptImpl.class);

    @Override
    public String aesEncryption(Object requestBody) {

        log.info("Entering:: MessageSecurity:: EncryptDecryptImpl:: aesEncryption method");
        Objects.requireNonNull(requestBody);

        return AESEnConfig.encryptUsingKey(requestBody);
    }

    @Override
    public String aesEncryption(String strToEncrypt) {

        log.info("Entering:: MessageSecurity:: EncryptDecryptImpl:: aesEncryption method");
        Objects.requireNonNull(strToEncrypt);

        return AESEnConfig.encryptUsingKey(strToEncrypt);

    }

    @Override
    public String aesEncryption(String strToEncrypt, String key) {

        log.info("Entering:: MessageSecurity:: EncryptDecryptImpl:: aesEncryption method");
        Objects.requireNonNull(strToEncrypt, key);

        return AESEnConfig.encryptUsingKey(strToEncrypt);

    }

    @Override
    public String aesDecryption(String strToDecrypt) {

        log.info("Entering:: MessageSecurity:: EncryptDecryptImpl:: aesEncryption method");
        Objects.requireNonNull(strToDecrypt);

        return AESDeConfig.decryptUsingKey(strToDecrypt);

    }

    @Override
    public String aesDecryption(String strToDecrypt, String key) {

        log.info("Entering:: MessageSecurity:: EncryptDecryptImpl:: aesEncryption method");
        Objects.requireNonNull(strToDecrypt, key);

        return AESDeConfig.decryptUsingKey(strToDecrypt, key);

    }

    @Override
    public Object aesDecryptionObj(String strToDecrypt) {

        log.info("Entering:: MessageSecurity:: EncryptDecryptImpl:: aesEncryption method");
        Objects.requireNonNull(strToDecrypt);

        return AESDeConfig.decryptUsingKeyObj(strToDecrypt);

    }

    @Override
    public Object aesDecryptionObj(String strToDecrypt, String key) {

        log.info("Entering:: MessageSecurity:: EncryptDecryptImpl:: aesEncryption method");
        Objects.requireNonNull(strToDecrypt, key);

        return AESDeConfig.decryptUsingKeyObj(strToDecrypt, key);

    }

    @Override
    public String rsaEncryption(Object requestBody) {

        log.info("Entering:: MessageSecurity:: EncryptDecryptImpl:: aesEncryption method");
        Objects.requireNonNull(requestBody);

        return RSAEnConfig.encrypt(requestBody);

    }

    @Override
    public Object rsaDecryption(String message) {

        log.info("Entering:: MessageSecurity:: EncryptDecryptImpl:: aesEncryption method");
        Objects.requireNonNull(message);

        return RSAEnConfig.decrypt(message);

    }


}
