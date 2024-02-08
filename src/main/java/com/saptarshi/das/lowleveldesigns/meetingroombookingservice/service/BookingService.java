package com.saptarshi.das.lowleveldesigns.meetingroombookingservice.service;

import com.saptarshi.das.lowleveldesigns.meetingroombookingservice.entity.Meeting;
import com.saptarshi.das.lowleveldesigns.meetingroombookingservice.entity.Room;
import com.saptarshi.das.lowleveldesigns.meetingroombookingservice.entity.Slot;
import com.saptarshi.das.lowleveldesigns.meetingroombookingservice.entity.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class BookingService {
    private final List<Room> rooms;

    public List<Room> getRoomsAvailableForTheSlotAndCapacity(final Slot slot, final Integer capacity) {
        return rooms.stream().
                filter(room -> room.getCapacity() >= capacity).
                filter(room -> room.getCalendar().isSlotAvailable(slot)).
                collect(Collectors.toList());
    }

    public Meeting bookMeetingRoom(
            @NonNull final Integer roomId,
            @NonNull final Slot slot,
            @NonNull final List<User> participants
    ) {
        final Room meetingRoom = this.rooms.stream().
                filter(room -> room.getId().equals(roomId)).
                filter(room -> room.getCalendar().isSlotAvailable(slot)).
                findFirst().
                orElseThrow(() -> new IllegalStateException("Room not found"));

        meetingRoom.getCalendar().bookSlot(slot);

        return new Meeting()
                .setRoom(meetingRoom)
                .setSlot(slot)
                .setParticipants(participants);
    }
}
