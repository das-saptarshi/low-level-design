package com.saptarshi.das.lowleveldesigns.meetingroombookingservice.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Slot {
    private String startsAt;
    private String endsAt;
}
