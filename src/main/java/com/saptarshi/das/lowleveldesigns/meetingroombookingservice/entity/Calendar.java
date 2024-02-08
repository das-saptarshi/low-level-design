package com.saptarshi.das.lowleveldesigns.meetingroombookingservice.entity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Calendar {

    public boolean isSlotAvailable(final Slot slot) {
        // Slot availability code goes here.
        log.info(slot.toString());
        return true;
    }

    public void bookSlot(Slot slot) {
        // Slot booking code goes here.
        log.info(slot.toString());
    }
}
