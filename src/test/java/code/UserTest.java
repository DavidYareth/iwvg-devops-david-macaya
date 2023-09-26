package code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {
    private User user;
    private List<Fraction> fractions;

    @BeforeEach
    void before() {
        fractions = new ArrayList<>();
        fractions.add(new Fraction(2, 3));
        fractions.add(new Fraction(3, 4));
        user = new User("1", "John", "Doe", fractions);
    }

    @Test
    void testUserIdNameFamilyNameFractions() {
        assertEquals("1", user.getId());
        assertEquals("John", user.getName());
        assertEquals("Doe", user.getFamilyName());
        assertEquals(fractions, user.getFractions());
    }

    @Test
    void testUser() {
        User defaultUser = new User();
        assertTrue(defaultUser.getFractions().isEmpty());
    }

    @Test
    void testSetName() {
        user.setName("Jane");
        assertEquals("Jane", user.getName());
    }

    @Test
    void testSetFamilyName() {
        user.setFamilyName("Smith");
        assertEquals("Smith", user.getFamilyName());
    }

    @Test
    void testSetFractions() {
        List<Fraction> newFractions = new ArrayList<>();
        newFractions.add(new Fraction(4, 5));
        user.setFractions(newFractions);
        assertEquals(newFractions, user.getFractions());
    }

    @Test
    void testAddFraction() {
        Fraction newFraction = new Fraction(1, 2);
        user.addFraction(newFraction);
        assertTrue(user.getFractions().contains(newFraction));
    }

    @Test
    void testFullName() {
        assertEquals("John Doe", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("J.", user.initials());
    }

    @Test
    void testToString() {
        assertEquals("User{id='1', name='John', familyName='Doe', fractions=[Fraction{numerator=2, denominator=3}, Fraction{numerator=3, denominator=4}]}", user.toString());
    }
}
