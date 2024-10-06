package com.example.property_agenda.property;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.UUID;

/**
 * A class for property classes. A {@code} Property contains one or more {@code} Buildings.
 */
public class Property implements IProperty {
    private final String id = UUID.randomUUID().toString();
    private String name;
    private LocalDate date;
    private String inspector;

    /**
     * Constructs an instance of the {@code Property} class.
     *
     * @param name      The name of the {@code Property}
     * @param date      The date this {@code Property} is being inspected
     * @param inspector The inspector inspecting this {@code Property}
     */
    public Property(@NotNull String name, @NotNull LocalDate date, @NotNull String inspector) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (inspector.isBlank()) {
            throw new IllegalArgumentException("Inspector cannot be blank");
        }
        this.name = name;
        this.date = date;
        this.inspector = inspector;
    }


    /**
     * Get the ID of this {@code IProperty}
     *
     * @return The ID of this {@code IProperty} as a {@code String}
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * Get the name of this {@code IProperty}
     *
     * @return The name of this {@code IProperty} as a {@code String}
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of this {@code IProperty} to the given name
     *
     * @param name The new name of this {@code IProperty}
     */
    @Override
    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;

    }

    /**
     * Get the date of this {@code IProperty} as a Date data type
     *
     * @return The date of this {@code IProperty}
     */
    @Override
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * Sets the date of this {@code IProperty} as the given date
     *
     * @param date The new date of this {@code IProperty}
     */
    @Override
    public void setDate(@NotNull LocalDate date) {
        this.date = date;
    }

    /**
     * Gets the inspector of this {@code IProperty}
     *
     * @return The current inspector of this {@code IProperty}
     */
    @Override
    public String getInspector() {
        return this.inspector;
    }

    /**
     * Sets the inspector name of this {@code IProperty} as the given name
     *
     * @param inspector The new inspector name of this {@code} IProperty
     */
    @Override
    public void setInspector(String inspector) {
        if (inspector.isBlank()) {
            throw new IllegalArgumentException("Inspector cannot be blank");
        }
        this.inspector = inspector;
    }
}
