package com.dgsoft.conversion.component;

import org.springframework.stereotype.Service;

@Service
public interface EncryptDecrypt {
    String aesEncryption(Object requestBody);

    String aesEncryption(String strToEncrypt);

    String aesEncryption(String strToEncrypt, String key);

    String aesDecryption(String strToDecrypt);

    String aesDecryption(String strToDecrypt, String key);

    Object aesDecryptionObj(String strToDecrypt);

    Object aesDecryptionObj(String strToDecrypt, String key);

    String rsaEncryption(Object requestBody);

    Object rsaDecryption(String message);

}
