package com.example.demofeign.clients.response;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class User {
    private int id;
    private String name;
    private LocalDateTime createdDatetime;
}
