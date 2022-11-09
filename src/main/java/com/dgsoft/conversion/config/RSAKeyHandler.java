package com.dgsoft.conversion.config;

import com.dgsoft.conversion.util.ConstantsUtil;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/*---RSAKeyHandler class is responsible to parse the encrypted private and public keys with proper encoding algorithm ---*/

public class RSAKeyHandler {

    PrivateKey privateKey;
    PublicKey publicKey;

    public  RSAKeyHandler() {
        try{
            X509EncodedKeySpec keySpecPublic = new X509EncodedKeySpec(Base64Config.decryptBase64(ConstantsUtil.PUBLIC_KEY_STRING));
            PKCS8EncodedKeySpec keySpecPrivate = new PKCS8EncodedKeySpec(Base64Config.decryptBase64(ConstantsUtil.PRIVATE_KEY_STRING));

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            publicKey = keyFactory.generatePublic(keySpecPublic);
            privateKey = keyFactory.generatePrivate(keySpecPrivate);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
