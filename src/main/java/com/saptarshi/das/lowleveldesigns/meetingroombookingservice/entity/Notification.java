package com.saptarshi.das.lowleveldesigns.meetingroombookingservice.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Notification {
    private String sender;
    private String receiver;
    private String head;
    private String body;
}
