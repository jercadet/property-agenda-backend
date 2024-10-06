package com.example.property_agenda.buildings;

/**
 * An interface representing buildings
 */
public interface IBuilding {

    /**
     * Gives the ID of this {@code IBuilding}
     * @return The ID as a String
     */
    String getId();

    /**
     * Gives the name of this {@code IBuilding}
     * @return The name as a String
     */
    String getName();

    /**
     * Sets the name of this {@code IBuilding} to the given name
     * @param name The new name of this {@code IBuilding}
     */
    void setName(String name);
}
