package com.dgsoft.conversion.util;

import com.dgsoft.conversion.component.impl.TestObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.Objects;

@ExtendWith(MockitoExtension.class)
public class ObjectUtilTest {

    private TestObject testObject;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.testObject = new TestObject(1234, "Test String", true);
    }

    @AfterEach
    public void tearDown() {
        this.testObject = null;
    }

    @Test
    public void convertObjectToStringTestEquals() {
        String result = ObjectUtil.asJasonString(testObject);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("{\"number\":1234,\"message\":\"Test String\",\"decision\":true}", result);
    }

    @Test
    public void convertObjectToStringTestNotEquals() {
        String result = ObjectUtil.asJasonString(testObject);
        Assertions.assertNotNull(result);
        Assertions.assertNotEquals("random text", result);
    }

    @Test
    public void convertStringtoObjectTestEquals() throws JSONException {
        String inputStr = "{\"number\":1234,\"message\":\"Test String\",\"decision\":true}";
        JSONObject resultObj = new JSONObject((Map<?,?>) Objects.requireNonNull(ObjectUtil.asJasonObject(inputStr)));

        Assertions.assertNotNull(resultObj);
        Assertions.assertEquals(1234, resultObj.getInt("number"));
        Assertions.assertEquals("Test String", resultObj.getString("message"));
        Assertions.assertTrue(resultObj.getBoolean("decision"));
    }

    @Test
    public void convertStringToObjectTestNotEquals() {
        String inputStr = "{\"number\":1234,\"message\":\"Test String\",\"decision\":true}";
        Object resultObj = ObjectUtil.asJasonObject(inputStr);

        Assertions.assertNotNull(resultObj);
        Assertions.assertNotEquals("random text", resultObj.toString());
    }

    @Test
    public void convertStringToObjectWithClassTestEquals() {
        String inputStr = "{\"number\":1234,\"message\":\"Test String\",\"decision\":true}";
        TestObject resultObj = (TestObject) ObjectUtil.asJasonObject(inputStr, TestObject.class);

        Assertions.assertNotNull(resultObj);
        Assertions.assertEquals(1234, resultObj.getNumber());
        Assertions.assertEquals("Test String", resultObj.getMessage());
        Assertions.assertTrue(resultObj.isDecision());
    }

    @Test
    public void convertStringToObjectWithClassTestNotEquals() {
        String inputStr = "{\"number\":1234,\"message\":\"Test String\",\"decision\":true}";
        TestObject resultObj = (TestObject) ObjectUtil.asJasonObject(inputStr, TestObject.class);

        Assertions.assertNotNull(resultObj);
        Assertions.assertNotEquals("random text", resultObj.toString());
    }
}
