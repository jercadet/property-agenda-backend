package com.example.property_agenda.property;

import java.time.LocalDate;

/**
 * An interface for property classes. A {@code} Property contains one or more {@code} Buildings.
 */
public interface IProperty {

    /**
     * Get the ID of this {@code IProperty}
     *
     * @return The ID of this {@code IProperty} as a string
     */
    String getId();

    /**
     * Get the name of this {@code IProperty}
     * @return The name of this {@code IProperty} as a string
     */
    String getName();

    /**
     * Sets the name of this {@code IProperty} to the given name
     * @param name The new name of this {@code IProperty}
     */
    void setName(String name);

    /**
     * Get the date of this {@code IProperty} as a Date data type
     * @return The date of this {@code IProperty}
     */
    LocalDate getDate();

    /**
     * Sets the date of this {@code IProperty} as the given date
     * @param date The new date of this {@code IProperty}
     */
    void setDate(LocalDate date);

    /**
     * Gets the inspector of this {@code IProperty}
     * @return The current inspector of this {@code IProperty}
     */
    String getInspector();

    /**
     * Sets the inspector name of this {@code IProperty} as the given name
     * @param inspector The new inspector name of this {@code IProperty}
     */
    void setInspector(String inspector);
}
