package com.saptarshi.das.lowleveldesigns.meetingroombookingservice.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Meeting {
    private Slot slot;
    private Room room;
    private List<User> participants;
}
