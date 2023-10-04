package com.example.demofeign.clients.response;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class JPGObject implements CommonObject {
    private final String type;
    private final int number;

    public JPGObject(String type, int number) {
        this.type = type;
        this.number = number;
    }
}
