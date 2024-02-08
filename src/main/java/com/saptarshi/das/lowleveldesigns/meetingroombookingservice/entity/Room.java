package com.saptarshi.das.lowleveldesigns.meetingroombookingservice.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Room {
    private Integer id;
    private String name;
    private Integer capacity;
    private String location;
    private Calendar calendar;
}
