package se.meepo.burgerorder.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ObjectMapperUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ObjectWriter objectWriter;

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
    }

    public static ObjectWriter getObjectWriter() {
        return objectWriter;
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
