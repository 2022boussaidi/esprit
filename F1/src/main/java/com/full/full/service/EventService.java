package com.full.full.service;

import com.full.full.models.Event;
import com.full.full.models.User;

import java.util.List;

public interface EventService {
    Event createEvent(Event event);
    List<Event> getAllEvents();
    void deleteEvent(Long id);
    Event updateEvent(Long id, Event updatedEvent);
}