package com.example.property_agenda;

import com.example.property_agenda.property.IProperty;
import com.example.property_agenda.property.Property;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * NOT FINAL CODE, JUST PLAYING AROUND WITH SPRING BOOT RIGHT NOW
 */

@RestController
public class PropertyAgendaController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final LocalDate date = LocalDate.of(2020, 3, 17);
    private final List<IProperty> initProperty = new ArrayList<>();

    @GetMapping("/properties")
    public PropertyRecord propertyRecord(@RequestParam(value = "id", defaultValue = "0") String id) {
        initProperty.add(new Property("Real Name", date, "Real Inspector"));
        initProperty.add(new Property("Another One", date, "Another Inspector"));
        return new PropertyRecord(id, initProperty);
    }
}