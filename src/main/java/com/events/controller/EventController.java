package com.events.controller;

import com.events.repository.EventRepository;
import com.events.model.Event;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public Event createEvent(@RequestBody Event event) {
        return eventRepository.saveAndFlush(event);
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
    public Event getEventById(@PathVariable Long id) {
        return eventRepository.findOne(id);
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.PUT)
    public Event updateEvent(@RequestBody Event event, @PathVariable Long id) {
        Event existingEvent = eventRepository.findOne(id);
        BeanUtils.copyProperties(event, existingEvent);
        existingEvent.setId(id);
        System.out.println("saving and flushing");
        return eventRepository.saveAndFlush(existingEvent);
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.DELETE)
    public Event deleteEvent(@PathVariable Long id) {
        Event existingEvent = eventRepository.findOne(id);
        eventRepository.delete(id);
        return existingEvent;
    }
}
