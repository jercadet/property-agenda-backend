package com.example.property_agenda.property;

import com.example.property_agenda.buildings.IBuilding;

import java.time.LocalDate;
import java.util.List;

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

    /**
     * Gets all the current {@code IBuildings} in this property
     * @return An ArrayList of {@code IBuildings} in this {@code IProperty}
     */
    List<IBuilding> getAllBuildings();

    /**
     * Gets the {@code IBuilding} from this {@code IProperty}  using the given Building ID
     * @param bid The ID of the requested {@code IBuilding}
     * @return The {@code IBuilding} with the given ID
     */
    IBuilding getBuilding(String bid);

    /**
     * Add the given {@code IBuilding} to this {@code IProperty}
     * @param building The {@code Building} to add to this {@code IProperty}
     */
    void addBuilding(IBuilding building);

    /**
     * Remove an {@code IBuilding} from this {@code IProperty} using the given Building ID
     * @param bid The ID of the {@code IBuilding} to remove
     */
    void removeBuilding(String bid);
}
