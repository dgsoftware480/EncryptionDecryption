package com.dgsoft.conversion.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Base64ConfigTest {

    private byte[] testBytes;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.testBytes = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    }

    @AfterEach
    public void tearDown() {
        this.testBytes = null;
    }

    @Test
    public void byteStringBase64TestEquals() {
        String test = Base64Config.encryptBase64(testBytes);
        Assertions.assertNotNull(test);
        byte[] decrypted = Base64Config.decryptBase64(test);
        Assertions.assertNotNull(decrypted);

        Assertions.assertEquals(decrypted.length, testBytes.length);
        Assertions.assertEquals(new String(decrypted), new String(testBytes));
    }

    @Test
    public void byteStringBase64TestNotEquals() {
        String test = Base64Config.encryptBase64(testBytes);
        Assertions.assertNotNull(test);
        byte[] decrypted = Base64Config.decryptBase64(test);
        Assertions.assertNotNull(decrypted);

        Assertions.assertNotEquals(decrypted, testBytes);
    }

}
