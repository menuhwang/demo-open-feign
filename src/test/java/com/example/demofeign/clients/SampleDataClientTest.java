package com.example.demofeign.clients;

import com.example.demofeign.clients.response.User;
import com.example.demofeign.config.FeignConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@SpringBootTest
@Import({
        FeignConfig.class
})
class SampleDataClientTest {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private SampleDataClient sampleDataClient;

    @Test
    void getStringList() {
        List<String> result = sampleDataClient.getStringList();

        log.info("get string list: {}", result);
        assertEquals(3, result.size());
    }

    @Test
    void getIntList() {
        List<Integer> result = sampleDataClient.getIntList();

        log.info("get integer list: {}", result);
        assertEquals(3, result.size());
    }

    @Test
    void getObjectSimpleUser() {
        User result = sampleDataClient.getObjectSimpleUser();

        log.info("get object simple-user: {}", result);
        assertInstanceOf(Integer.class, result.getId());
        assertInstanceOf(String.class, result.getName());
        assertInstanceOf(LocalDateTime.class, result.getCreatedDatetime());
    }

    @Test
    void getComplexObjectList() {
        List<Object> result = sampleDataClient.getComplexObjectList();

        log.info("get complex object list: {}", result);

        assertEquals(3, result.size());
    }
}