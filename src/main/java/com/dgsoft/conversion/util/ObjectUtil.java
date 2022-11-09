package com.dgsoft.conversion.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.NoArgsConstructor;

import java.io.IOException;

/*--ObjectUtil provides functionality for reading and writing objects---*/

@NoArgsConstructor
public class ObjectUtil {

    public static final ObjectWriter OBJECT_WRITER = new ObjectMapper().writer();

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String asJasonString(final Object obj) {
        String input = "";
        try {
            input = OBJECT_WRITER.writeValueAsString(obj);
            return input;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object asJasonObject(final String str) {
        try {
            return OBJECT_MAPPER.readValue(str, Object.class);
        } catch (JsonParseException ex) {
            ex.printStackTrace();
        } catch (JsonMappingException ex1) {
            ex1.printStackTrace();
        } catch (IOException exp) {
            exp.printStackTrace();
        }
        return null;
    }

    public static Object asJasonObject(final String str, Class<?> tClass) {
        try {
            return OBJECT_MAPPER.readValue(str, tClass);
        } catch (JsonParseException ex) {
            ex.printStackTrace();
        } catch (JsonMappingException ex1) {
            ex1.printStackTrace();
        } catch (IOException exp) {
            exp.printStackTrace();
        }
        return null;
    }
}
