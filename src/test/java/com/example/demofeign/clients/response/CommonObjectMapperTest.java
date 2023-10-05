package com.example.demofeign.clients.response;

import com.example.demofeign.clients.SampleDataClient;
import com.example.demofeign.config.FeignConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Import({
        FeignConfig.class
})
class CommonObjectMapperTest {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private SampleDataClient sampleDataClient;

    @Test
    void mapToCommonObject() {
        List<Object> objects = sampleDataClient.getComplexObjectList();

        List<CommonObject> commonObjects = objects.stream()
                .map(CommonObjectMapper::mappedBy)
                .collect(Collectors.toList());

        log.info("get common objects: {}", commonObjects);

        commonObjects.forEach(
                commonObject -> assertDoesNotThrow(commonObject::getType)
        );
    }
}