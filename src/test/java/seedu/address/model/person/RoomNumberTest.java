package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class RoomNumberTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new RoomNumber(null));
    }

    @Test
    public void constructor_invalidRoomNumber_throwsIllegalArgumentException() {
        String invalidRoomNumber = "#01-0123";
        assertThrows(IllegalArgumentException.class, () -> new RoomNumber(invalidRoomNumber));
    }

    @Test
    public void isValidRoomNumber() {
        // null address
        assertThrows(NullPointerException.class, () -> Address.isValidAddress(null));

        // invalid addresses
        assertFalse(RoomNumber.isValidRoomNumber("#01-0123")); // additional special character #
        assertFalse(RoomNumber.isValidRoomNumber("010123")); // no -
        assertFalse(RoomNumber.isValidRoomNumber("010-123")); // wrong placement of -
        assertFalse(RoomNumber.isValidRoomNumber("#1-0123")); // incorrect digits for floor
        assertFalse(RoomNumber.isValidRoomNumber("#001-0123")); // incorrect digits for floor
        assertFalse(RoomNumber.isValidRoomNumber("#01-012")); // incorrect digits for room
        assertFalse(RoomNumber.isValidRoomNumber("#01-01234")); // incorrect digits for room

        // valid addresses
        assertTrue(Address.isValidAddress("05-5053"));
    }

    @Test
    public void equals() {
        RoomNumber roomNumber = new RoomNumber("Valid Room Number");

        // same values -> returns true
        assertTrue(roomNumber.equals(new RoomNumber("Valid Room Number")));

        // same object -> returns true
        assertTrue(roomNumber.equals(roomNumber));

        // null -> returns false
        assertFalse(roomNumber.equals(null));

        // different types -> returns false
        assertFalse(roomNumber.equals(5.0f));

        // different values -> returns false
        assertFalse(roomNumber.equals(new RoomNumber("Other Valid Room Number")));
    }
}
