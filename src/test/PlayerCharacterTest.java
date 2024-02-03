package test;

import de.game.modules.model.player.Bag;
import de.game.modules.model.player.PlayerCharacter;
import de.game.modules.model.player.misc_usable.Potion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerCharacterTest {

    private PlayerCharacter player;


    @BeforeEach
    void setUp() {
        Bag standardPlayerBag = new Bag(10, "BagImage");
        player = new PlayerCharacter(0, 100, "Player", 25, 26, 4, standardPlayerBag,
                null, null);
        player.setBag(standardPlayerBag);

        for (int i = 1; i <= 2; i++) {
            player.getBag().addInventoryObject(new Potion("Health Potion 🧪", 30));
        }
    }

    @Test
    void useHealthPotion_isCorrectAmountOfHPAfterUse() {

        // GIVEN
        PlayerCharacter playerUnderTest = player;
        playerUnderTest.takeDamage(30);

        // WHEN
        playerUnderTest.useHealthPotion();

        // THEN
        assertEquals(100,playerUnderTest.getHealth());
    }

    @Test
    void useHealthPotion_isCorrectAmountOfHealthPotions() {

        // GIVEN
        PlayerCharacter playerUnderTest = player;
        playerUnderTest.takeDamage(30);

        // WHEN
        playerUnderTest.useHealthPotion();
        int actualAmountOfHealthPotions = playerUnderTest.getAmountOfHealthPotions();

        // THEN
        assertEquals(1, actualAmountOfHealthPotions);
    }

}