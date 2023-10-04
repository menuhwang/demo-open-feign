package com.example.demofeign.clients;

import com.example.demofeign.clients.response.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "dataStructure",
        url = "${feign.client.dataStructure.url}",
        path = "/datastructure")
public interface DataStructureClient {
    @GetMapping(value = "/arraylist/string")
    List<String> getStringList();

    @GetMapping(value = "/arraylist/int")
    List<Integer> getIntList();

    @GetMapping(value = "/object/simple")
    User getObjectSimpleUser();

    @GetMapping(value = "/arraylist/object/complex")
    List<Object> getComplexObjectList();
}
