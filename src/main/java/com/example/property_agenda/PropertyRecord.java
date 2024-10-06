package com.example.property_agenda;

import com.example.property_agenda.property.IProperty;

import java.util.List;

public record PropertyRecord(String id, List<IProperty> properties) {}
