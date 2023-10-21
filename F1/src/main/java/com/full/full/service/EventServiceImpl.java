package com.full.full.service;

import com.full.full.models.Event;
import com.full.full.models.User;
import com.full.full.repository.EventRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EventServiceImpl implements EventService{
    public EventServiceImpl(EventRepo eventRepository) {
        this.eventRepository = eventRepository;
    }

    private final EventRepo eventRepository;
    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
    @Override
    public Event updateEvent(Long id, Event updatedEvent) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Event not found with id: " + id));

        existingEvent.setTitle(updatedEvent.getTitle());
        existingEvent.setStart(updatedEvent.getStart());
        existingEvent.setEnd(updatedEvent.getEnd());
        return eventRepository.save(existingEvent);
    }
}