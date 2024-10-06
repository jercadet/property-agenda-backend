package com.example.property_agenda.property;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing methods in {@code Property} class
 */
public class PropertyTest {

    private LocalDate date;
    private IProperty testProperty;

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
        testProperty = new Property("Bikini Bottom", date, "Bob Joe");
    }

    /**
     * Tests for the constructor
     */
    @Test
    public void constructWithNameEmptyString() {
        initDate();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Property("", date, "Bob"));
        assertEquals("Name cannot be blank", exception.getMessage());
    }

    @Test
    public void constructWithNameWhiteSpaceName() {
        initDate();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Property("    ", date, "John"));
        assertEquals("Name cannot be blank", exception.getMessage());
    }

    @Test
    public void constructNameNewLineName() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Property("\n", date, "John"));
        assertEquals("Name cannot be blank", exception.getMessage());
    }

    @Test
    public void constructNameTabName() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Property("\t", date, "John"));
        assertEquals("Name cannot be blank", exception.getMessage());
    }

    @Test
    public void constructInspectorEmptyString() {
        initDate();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Property("Real Name", date, ""));
        assertEquals("Inspector cannot be blank", exception.getMessage());
    }

    @Test
    public void constructInspectorWhiteSpaceName() {
        initDate();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Property("Real Name", date, "       "));
        assertEquals("Inspector cannot be blank", exception.getMessage());
    }

    @Test
    public void constructInspectorNewLineName() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Property("Real Name", date, "\n"));
        assertEquals("Inspector cannot be blank", exception.getMessage());
    }

    @Test
    public void constructInspectorTabName() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Property("Real Name", date, "\t"));
        assertEquals("Inspector cannot be blank", exception.getMessage());
    }

    /**
     * Tests for {@code getId} method
     */
    @Test
    public void getIdTest() {
        initFullData();
        testProperty.getId();
        assertFalse(testProperty.getId().isBlank());
    }
    /**
     * Tests for {@code getName} method in {@code Property}
     */
    @Test
    public void getNameWithStandardName() {
        initFullData();
        String gottenName = testProperty.getName();
        assertEquals("Bikini Bottom", gottenName);
    }

    @Test
    public void getNameWithUnusualName() {
        initDate();
        testProperty = new Property("ja8&#3923qi32r--ff,m", date, "John");
        String gottenName = testProperty.getName();
        assertEquals("ja8&#3923qi32r--ff,m", gottenName);
    }

    /**
     * Tests for {@code setName} method in {@code Property}
     */
    @Test
    public void setNameErrorEmptyString() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                testProperty.setName(""));
        assertEquals("Name cannot be blank", exception.getMessage());
    }

    @Test
    public void setNameErrorWhiteSpaceName() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                testProperty.setName("           "));
        assertEquals("Name cannot be blank", exception.getMessage());
    }

    @Test
    public void setNameErrorNewLineName() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                testProperty.setName("\n"));
        assertEquals("Name cannot be blank", exception.getMessage());
    }

    @Test
    public void setNameErrorTabName() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                testProperty.setName("\t"));
        assertEquals("Name cannot be blank", exception.getMessage());
    }

    @Test
    public void setNameValidNormalName() {
        initFullData();
        testProperty.setName("Duncan Smith");
        assertEquals("Duncan Smith", testProperty.getName());
    }

    @Test
    public void setNameValidWeirdName() {
        initFullData();
        testProperty.setName("fj#@33ICNllsKLA00--");
        assertEquals("fj#@33ICNllsKLA00--", testProperty.getName());
    }

    /**
     * Tests for {@code getDate} method
     */
    @Test
    public void getDateTest() {
        initFullData();
        assertEquals(date, testProperty.getDate());
    }

    @Test
    public void getOldDateTest() {
        date = LocalDate.of(1902, 5, 27);
        testProperty = new Property("Big Property", date, "Big Inspector");
        assertEquals(date, testProperty.getDate());
    }

    /**
     * Tests for {@code setDate} method
     */
    @Test
    public void setValidDate() {
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
    public void setOldValidDate() {
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
    public void getInspectorRealName() {
        initFullData();
        String testInspector = testProperty.getInspector();
        assertEquals("Bob Joe", testInspector);
    }

    @Test
    public void getInspectorWeirdName() {
        initDate();
        IProperty testProperty = new Property("Real Name", date, "hoi34j-3IE2rj*&^%$fIue");
        String testInspector = testProperty.getInspector();
        assertEquals("hoi34j-3IE2rj*&^%$fIue", testInspector);
    }

    /**
     * Tests for the {@code setInspector} method
     */
    @Test
    public void setInspectorErrorEmptyString() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                testProperty.setInspector(""));
        assertEquals("Inspector cannot be blank", exception.getMessage());
    }

    @Test
    public void setInspectorErrorWhiteSpaceInspector() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                testProperty.setInspector("           "));
        assertEquals("Inspector cannot be blank", exception.getMessage());
    }

    @Test
    public void setInspectorErrorNewLineInspector() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                testProperty.setInspector("\n"));
        assertEquals("Inspector cannot be blank", exception.getMessage());
    }

    @Test
    public void setInspectorErrorTabInspector() {
        initFullData();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                testProperty.setInspector("\t"));
        assertEquals("Inspector cannot be blank", exception.getMessage());
    }

    @Test
    public void setInspectorValidNormalInspector() {
        initFullData();
        testProperty.setInspector("John Doe");
        assertEquals("John Doe", testProperty.getInspector());
    }

    @Test
    public void setInspectorValidWeirdInspector() {
        initFullData();
        testProperty.setInspector("iIWka32#@#kf2390JN--21()#(0@");
        assertEquals("iIWka32#@#kf2390JN--21()#(0@", testProperty.getInspector());
    }
}