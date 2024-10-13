package com.example.property_agenda.property;

import com.example.property_agenda.buildings.IBuilding;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.*;

/**
 * A class for property classes. A {@code} Property contains one or more {@code} Buildings.
 */
public class Property implements IProperty {
    private final String id;
    private String name;
    private LocalDate date;
    private String inspector;
    private final Map<String, IBuilding> buildings;

    /**
     * Constructs an instance of the {@code Property} class with an empty map of buildings.
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
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.date = date;
        this.inspector = inspector;
        this.buildings = new HashMap<>();
    }

    /**
     * Constructs an instance of the {@code Property} class with a given Map of {@code IBuildings}.
     *
     * @param name        The name of the {@code Property}
     * @param date        The date this {@code Property} is being inspected
     * @param inspector   The inspector inspecting this {@code Property}
     * @param buildingMap The hashMap of {@code IBuildings} for this {@code IProperty}
     */
    public Property(@NotNull String name, @NotNull LocalDate date, @NotNull String inspector, Map<String, IBuilding> buildingMap) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (inspector.isBlank()) {
            throw new IllegalArgumentException("Inspector cannot be blank");
        }
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.date = date;
        this.inspector = inspector;
        this.buildings = buildingMap;
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

    /**
     * Gets all the current {@code IBuildings} in this property.
     *
     * @return An ArrayList of {@code IBuildings} in this {@code IProperty}
     */
    @Override
    public List<IBuilding> getAllBuildings() {
        return new ArrayList<>(this.buildings.values());
    }

    /**
     * Gets the {@code IBuilding} from this {@code IProperty}  using the given Building ID. Returns null if there is no {@code Building} with the given ID
     *
     * @param bid The ID of the requested {@code IBuilding}
     * @return The {@code IBuilding} with the given ID
     */
    @Override
    public IBuilding getBuilding(String bid) {
        if (this.buildings.containsKey(bid)) {
            return this.buildings.get(bid);
        }
        return null;
    }

    /**
     * Add the given {@code IBuilding} to this {@code IProperty}
     *
     * @param building The {@code Building} to add to this {@code IProperty}
     */
    @Override
    public void addBuilding(@NotNull IBuilding building) {
        String id = building.getId();
        if (!this.buildings.containsKey(id)) {
            this.buildings.put(id, building);
        }
    }

    /**
     * Remove an {@code IBuilding} from this {@code IProperty} using the given Building ID
     *
     * @param bid The ID of the {@code IBuilding} to remove
     */
    @Override
    public void removeBuilding(String bid) {
        if (bid.isBlank()) {
            throw new IllegalArgumentException("The given ID cannot be a blank string");
        }
        this.buildings.remove(bid);
    }
}
