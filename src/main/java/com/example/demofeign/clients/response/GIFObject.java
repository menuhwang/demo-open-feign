package com.example.demofeign.clients.response;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GIFObject implements CommonObject {
    private final String type;
    private final String string;

    public GIFObject(String type, String string) {
        this.type = type;
        this.string = string;
    }
}
