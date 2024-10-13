package com.example.property_agenda.property;

import com.example.property_agenda.buildings.Building;
import com.example.property_agenda.buildings.IBuilding;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing methods in {@code Property} class
 */
class PropertyTest {

    private LocalDate date;
    private IProperty testProperty;
    private final IBuilding building1 = new Building("Building 1");
    private final IBuilding building2 = new Building("Building 2");
    private final IBuilding building3 = new Building("Building 3");

    /**
     * Initializes a {@code LocalDate} LocalDate to be used for constructing a {@code Property} where the date of the {@code Property} is not the focus of the test
     */
    private void initDate() {
        date = LocalDate.of(2020, 3, 17);
    }

    /**
     * Initializes a {@code Property} to be used for tests, using the date from the {@code initDate} method
     */
    private void initFullData() {
        initDate();
        Map<String, IBuilding> buildingMap = new HashMap<>();
        buildingMap.put("1", building1);
        buildingMap.put("2", building2);
        buildingMap.put("3", building3);
        testProperty = new Property("Bikini Bottom", date, "Bob Joe", buildingMap);
    }

    /**
     * Tests for the constructor
     */
    @Test
    void constructWithNameEmptyString() {
        initDate();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Property("", date, "Bob"));
        assertEquals("Name cannot be blank", exception.getMessage());
    }

    @Test
    void constructWithNameWhiteSpaceName() {
        initDate();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Property("    ", date, "John"));
        assertEquals("Name cannot be blank", exception.getMessage());
    }

    @Test
    void constructNameNewLineName() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Property("\n", date, "John"));
        assertEquals("Name cannot be blank", exception.getMessage());
    }

    @Test
    void constructNameTabName() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Property("\t", date, "John"));
        assertEquals("Name cannot be blank", exception.getMessage());
    }

    @Test
    void constructInspectorEmptyString() {
        initDate();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Property("Real Name", date, ""));
        assertEquals("Inspector cannot be blank", exception.getMessage());
    }

    @Test
    void constructInspectorWhiteSpaceName() {
        initDate();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Property("Real Name", date, "       "));
        assertEquals("Inspector cannot be blank", exception.getMessage());
    }

    @Test
    void constructInspectorNewLineName() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Property("Real Name", date, "\n"));
        assertEquals("Inspector cannot be blank", exception.getMessage());
    }

    @Test
    void constructInspectorTabName() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Property("Real Name", date, "\t"));
        assertEquals("Inspector cannot be blank", exception.getMessage());
    }

    /**
     * Tests for {@code getId} method
     */
    @Test
    void getIdTest() {
        initFullData();
        testProperty.getId();
        assertFalse(testProperty.getId().isBlank());
    }

    /**
     * Tests for {@code getName} method in {@code Property}
     */
    @Test
    void getNameWithStandardName() {
        initFullData();
        String gottenName = testProperty.getName();
        assertEquals("Bikini Bottom", gottenName);
    }

    @Test
    void getNameWithUnusualName() {
        initDate();
        testProperty = new Property("ja8&#3923qi32r--ff,m", date, "John");
        String gottenName = testProperty.getName();
        assertEquals("ja8&#3923qi32r--ff,m", gottenName);
    }

    /**
     * Tests for {@code setName} method in {@code Property}
     */
    @Test
    void setNameErrorEmptyString() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                testProperty.setName(""));
        assertEquals("Name cannot be blank", exception.getMessage());
    }

    @Test
    void setNameErrorWhiteSpaceName() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                testProperty.setName("           "));
        assertEquals("Name cannot be blank", exception.getMessage());
    }

    @Test
    void setNameErrorNewLineName() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                testProperty.setName("\n"));
        assertEquals("Name cannot be blank", exception.getMessage());
    }

    @Test
    void setNameErrorTabName() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                testProperty.setName("\t"));
        assertEquals("Name cannot be blank", exception.getMessage());
    }

    @Test
    void setNameValidNormalName() {
        initFullData();
        testProperty.setName("Duncan Smith");
        assertEquals("Duncan Smith", testProperty.getName());
    }

    @Test
    void setNameValidWeirdName() {
        initFullData();
        testProperty.setName("fj#@33ICNllsKLA00--");
        assertEquals("fj#@33ICNllsKLA00--", testProperty.getName());
    }

    /**
     * Tests for {@code getDate} method
     */
    @Test
    void getDateTest() {
        initFullData();
        assertEquals(date, testProperty.getDate());
    }

    @Test
    void getOldDateTest() {
        date = LocalDate.of(1902, 5, 27);
        testProperty = new Property("Big Property", date, "Big Inspector");
        assertEquals(date, testProperty.getDate());
    }

    /**
     * Tests for {@code setDate} method
     */
    @Test
    void setValidDate() {
        initFullData();
        LocalDate newDate = LocalDate.of(2019, 10, 8);
        testProperty.setDate(newDate);
        LocalDate testDate = testProperty.getDate();
        assertAll("date",
                () -> assertEquals(2019, testDate.getYear()),
                () -> assertEquals(10, testDate.getMonthValue()),
                () -> assertEquals(8, testDate.getDayOfMonth())
        );
    }

    @Test
    void setOldValidDate() {
        initFullData();
        LocalDate newDate = LocalDate.of(1910, 4, 27);
        testProperty.setDate(newDate);
        LocalDate testDate = testProperty.getDate();
        assertAll("date",
                () -> assertEquals(1910, testDate.getYear()),
                () -> assertEquals(4, testDate.getMonthValue()),
                () -> assertEquals(27, testDate.getDayOfMonth())
        );
    }

    /**
     * Tests for the {@code getInspector} method
     */
    @Test
    void getInspectorRealName() {
        initFullData();
        String testInspector = testProperty.getInspector();
        assertEquals("Bob Joe", testInspector);
    }

    @Test
    void getInspectorWeirdName() {
        initDate();
        IProperty testProperty = new Property("Real Name", date, "hoi34j-3IE2rj*&^%$fIue");
        String testInspector = testProperty.getInspector();
        assertEquals("hoi34j-3IE2rj*&^%$fIue", testInspector);
    }

    /**
     * Tests for the {@code setInspector} method
     */
    @Test
    void setInspectorErrorEmptyString() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                testProperty.setInspector(""));
        assertEquals("Inspector cannot be blank", exception.getMessage());
    }

    @Test
    void setInspectorErrorWhiteSpaceInspector() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                testProperty.setInspector("           "));
        assertEquals("Inspector cannot be blank", exception.getMessage());
    }

    @Test
    void setInspectorErrorNewLineInspector() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                testProperty.setInspector("\n"));
        assertEquals("Inspector cannot be blank", exception.getMessage());
    }

    @Test
    void setInspectorErrorTabInspector() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                testProperty.setInspector("\t"));
        assertEquals("Inspector cannot be blank", exception.getMessage());
    }

    @Test
    void setInspectorValidNormalInspector() {
        initFullData();
        testProperty.setInspector("John Doe");
        assertEquals("John Doe", testProperty.getInspector());
    }

    @Test
    void setInspectorValidWeirdInspector() {
        initFullData();
        testProperty.setInspector("iIWka32#@#kf2390JN--21()#(0@");
        assertEquals("iIWka32#@#kf2390JN--21()#(0@", testProperty.getInspector());
    }

    /**
     * Tests for {@code getAllBuildings} method
     */
    @Test
    void getAllBuildingsFromEmptyProperty() {
        initDate();
        testProperty = new Property("Real Name", date, "Real Inspector");
        assertTrue(testProperty.getAllBuildings().isEmpty());
    }

    @Test
    void getAllBuildingsPopulatedProperty() {
        initFullData();
        List<IBuilding> buildings = testProperty.getAllBuildings();
        assertAll("buildings",
                () -> assertFalse(buildings.isEmpty()),
                () -> assertTrue(buildings.contains(building1)),
                () -> assertTrue(buildings.contains(building2)),
                () -> assertTrue(buildings.contains(building3))
        );
    }

    /**
     * Tests for the {@code getBuilding} method
     */
    @Test
    void getSingleBuildingEmptyList() {
        initFullData();
        assertNull(testProperty.getBuilding("non-existent ID"));
    }

    @Test
    void getSingleExistingBuilding() {
        initFullData();
        IBuilding testBuilding = testProperty.getBuilding("2");
        assertEquals(testBuilding, building2);
    }

    /**
     * Tests for {@code addBuilding} method
     */
    @Test
    void addBuildingValidBuilding() {
        initFullData();
        IBuilding building4 = new Building("Building 4");
        String bid = building4.getId();
        // should be null because it's not added to testProperty yet
        assertNull(testProperty.getBuilding(bid));
        testProperty.addBuilding(building4);
        // building4 should now exist in testProperty and not return null
        assertNotNull(testProperty.getBuilding(bid));
    }

    @Test
    void addBuildingAlreadyInProperty() {
        initFullData();
        IBuilding building4 = new Building("Building 4");
        testProperty.addBuilding(building4);
        // before trying to add building4 a second time
        List<IBuilding> beforeList = testProperty.getAllBuildings();
        testProperty.addBuilding(building4);
        // after trying to add building4 a second time. both lists should be equal b/c method ignores second call to add building4
        List<IBuilding> afterList = testProperty.getAllBuildings();
        assertEquals(beforeList, afterList);
    }

    @Test
    void addMultipleBuildings() {
        initFullData();
        IBuilding building4 = new Building("Building 4");
        IBuilding building5 = new Building("Building 5");
        IBuilding building6 = new Building("Building 6");
        String bid4 = building4.getId();
        String bid5 = building5.getId();
        String bid6 = building6.getId();
        // should be null because buildings 4, 5, and 6 not added to testProperty yet
        assertAll("buildings not in Property yet",
                () -> {
                    assertNull(testProperty.getBuilding(bid4));
                    assertNull(testProperty.getBuilding(bid5));
                    assertNull(testProperty.getBuilding(bid6));
                }
        );
        testProperty.addBuilding(building4);
        testProperty.addBuilding(building5);
        testProperty.addBuilding(building6);
        // building4 should now exist in testProperty and not return null
        assertAll("buildings now in Property yet",
                () -> {
                    assertNotNull(testProperty.getBuilding(bid4));
                    assertNotNull(testProperty.getBuilding(bid5));
                    assertNotNull(testProperty.getBuilding(bid6));
                }
        );
    }

    /**
     * Tests for {@code removeBuilding} method
     */
    @Test
    void removeEmptyStringBuildingID() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> testProperty.removeBuilding(""));
        assertEquals("The given ID cannot be a blank string", exception.getMessage());
    }

    @Test
    void removeWhiteSpaceStringBuildingID() {
        initFullData();
        assertAll(() -> {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> testProperty.removeBuilding("    "));
            assertEquals("The given ID cannot be a blank string", exception.getMessage());
            exception = assertThrows(IllegalArgumentException.class, () -> testProperty.removeBuilding("\t"));
            assertEquals("The given ID cannot be a blank string", exception.getMessage());
            exception = assertThrows(IllegalArgumentException.class, () -> testProperty.removeBuilding("\n"));
            assertEquals("The given ID cannot be a blank string", exception.getMessage());
        });
    }

    @Test
    void removeBuildingNotInProperty() {
        initFullData();
        // building list before removing building not in Property
        List<IBuilding> beforeList = testProperty.getAllBuildings();
        testProperty.removeBuilding("non-existent building id");
        // building list before removing building not in Property (both should be equal)
        List<IBuilding> afterList = testProperty.getAllBuildings();
        assertEquals(beforeList, afterList);
    }

    @Test
    void removeBuildingInProperty() {
        initFullData();
        // building list before removing building not in Property
        List<IBuilding> beforeList = testProperty.getAllBuildings();
        testProperty.removeBuilding("2");
        // building list before removing building not in Property (both should be equal)
        List<IBuilding> afterList = testProperty.getAllBuildings();
        assertAll(() -> {
                    assertNotEquals(beforeList.size(), afterList.size());
                    assertTrue(beforeList.contains(building2));
                    assertFalse(afterList.contains(building2));
                }
        );
    }
}