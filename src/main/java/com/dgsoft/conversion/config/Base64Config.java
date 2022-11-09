package com.dgsoft.conversion.config;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

/*---Base64Config is a class which provides base64 encryption and decryption---*/
@NoArgsConstructor
public class Base64Config {

    private static final Logger log = LoggerFactory.getLogger(Base64Config.class);
    public static String encryptBase64(final byte[] encode) {
        log.info("Entering:: MessageSecurity:: Base64Config:: encryptBase64 method");
        return Base64.getEncoder().encodeToString(encode);
    }

    public static byte[] decryptBase64(final String decode) {
        log.info("Entering:: MessageSecurity:: Base64Config:: decryptBase64 method");
        return Base64.getDecoder().decode(decode);
    }
}
