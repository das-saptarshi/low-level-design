package com.saptarshi.das.lowleveldesigns.meetingroombookingservice;

import com.saptarshi.das.lowleveldesigns.meetingroombookingservice.entity.Meeting;
import com.saptarshi.das.lowleveldesigns.meetingroombookingservice.entity.Room;
import com.saptarshi.das.lowleveldesigns.meetingroombookingservice.entity.Slot;
import com.saptarshi.das.lowleveldesigns.meetingroombookingservice.entity.User;
import com.saptarshi.das.lowleveldesigns.meetingroombookingservice.service.BookingService;
import com.saptarshi.das.lowleveldesigns.meetingroombookingservice.service.Notifier;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class Scheduler {
    private final BookingService bookingService;
    private final Notifier notifier;

    public List<Room> getAvailableMeetingRooms(
            @NonNull final String meetingStartTime,
            @NonNull final String meetingEndTime,
            @NonNull final Integer capacity
    ) {
        final Slot slot = new Slot().setStartsAt(meetingStartTime).setEndsAt(meetingEndTime);
        return this.bookingService.getRoomsAvailableForTheSlotAndCapacity(slot, capacity);
    }

    public Meeting bookMeetingRoom(
            @NonNull final Integer meetingRoomId,
            @NonNull final String meetingStartTime,
            @NonNull final String meetingEndTime,
            @NonNull final List<User> participants
    ) {
        final Slot slot = new Slot().setStartsAt(meetingStartTime).setEndsAt(meetingEndTime);
        final Meeting meeting = this.bookingService.bookMeetingRoom(meetingRoomId, slot, participants);
        this.notifier.sendMeetingInvitations(meeting);
        return meeting;
    }
}
