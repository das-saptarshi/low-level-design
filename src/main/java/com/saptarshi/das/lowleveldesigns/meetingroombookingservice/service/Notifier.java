package com.saptarshi.das.lowleveldesigns.meetingroombookingservice.service;

import com.saptarshi.das.lowleveldesigns.meetingroombookingservice.entity.Meeting;
import com.saptarshi.das.lowleveldesigns.meetingroombookingservice.entity.Notification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Notifier {

    public void sendMeetingInvitations(final Meeting meeting) {
        final String body = String.format("You have a meeting at room %s located at %s, from %s to %s.",
                meeting.getRoom().getName(),
                meeting.getRoom().getLocation(),
                meeting.getSlot().getStartsAt(),
                meeting.getSlot().getEndsAt());
        final Notification notification = new Notification()
                .setSender("notifier@company.com")
                .setHead("Meeting Invite")
                .setBody(body);

        meeting.getParticipants().forEach(participant -> {
            notification.setReceiver(participant.getEmail());
            this.sendNotification(notification);
        });
    }

    private void sendNotification(final Notification notification) {
        log.info("Sending notification... {}", notification);
    }
}
