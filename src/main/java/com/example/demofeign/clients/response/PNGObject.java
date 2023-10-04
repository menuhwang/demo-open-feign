package com.example.demofeign.clients.response;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
public class PNGObject implements CommonObject {
    private final String type;
    private final LocalDateTime createdAt;
    private final List<String> array;

    public PNGObject(String type, LocalDateTime createdAt, List<String> array) {
        this.type = type;
        this.createdAt = createdAt;
        this.array = array;
    }
}
