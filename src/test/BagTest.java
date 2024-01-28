package test;

import de.game.modules.model.player.Bag;
import de.game.modules.model.player.Potion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BagTest {
    private Bag standardPlayerBag;

    @BeforeEach
    void setUp() {
        // Arrange: Set up a new Bag before each test
        standardPlayerBag = new Bag(10, "BagImage");

        // Arrange: Add 4 health potions to the bag
        for (int i = 1; i <= 4; i++) {
            standardPlayerBag.addInventoryObject(new Potion("Health Potion 🧪", 30));
        }
    }

    @Test
    void utilTotalAmountOfHealthPotionsInTheBag_isCorrect() {

        // GIVEN
        Bag bagUnderTest = standardPlayerBag;

        // WHEN
        // Act: Get the actual amount of health potions in the bag
        int actualAmountOfHealthPotionsInTheBag = bagUnderTest.utilTotalAmountOfHealthPotionsInTheBag(bagUnderTest);

        // THEN
        // Assert: Check if the actual amount matches the expected amount
        assertEquals(4, actualAmountOfHealthPotionsInTheBag, "Unexpected amount of health potions");
    }


    @Test
    void utilTotalFreeSlotsInTheCurrentBag_isCorrect() {

        // GIVEN
        Bag bagUnderTest = standardPlayerBag;

        // WHEN
        int totalFreeSlotsInTheCurrentBag = bagUnderTest.utilTotalFreeSlotsInTheCurrentBag();

        // THEN
        assertEquals(6, totalFreeSlotsInTheCurrentBag);
    }

}
