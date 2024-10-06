package com.example.property_agenda.buildings;

import com.example.property_agenda.units.UnitTypes;

import java.util.UUID;

/**
 * This is a class to represent a {@code Building}. A {@code Building} contains at least 1 of every type of {@code Room}.
 */
public class Building implements IBuilding{

    private final String id;
    private String name;
    private UnitTypes units;

    /**
     * Constructs a new instance of this {@code Building}
     * @param name The given name of this {@code Building}. The name can be empty
     */
    public Building(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;

    }


    /**
     * Gives the ID of this {@code Building}
     *
     * @return The ID as a String
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * Gives the name of this {@code Building}
     *
     * @return The name as a String
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of this {@code Building} to the given name
     *
     * @param name The new name of this {@code Building}
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
}
