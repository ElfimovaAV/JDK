package seminar6.home;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.seminar6.home.Door;
import ru.gb.seminar6.home.Game;
import ru.gb.seminar6.home.Player;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    List<Door> doors;
    Player player;
    Game game;

    @BeforeEach
    void createDoors () {
        doors = new ArrayList<>();
        doors.add(new Door(false));
        doors.add(new Door(false));
        doors.add(new Door(true));
        player = new Player("Игрок в Монти-Холл");
        game = new Game(player, doors);
    }

    @Test
    @DisplayName("Утверждаю, что не рискующий игрок победит, если выберет третью дверь с призом")
    void winPlayerNotRisk(){
        player.setRisk(false);
        Door door = game.round(2);
        Assertions.assertTrue(door.isPrize());
    }

    @Test
    @DisplayName("Утверждаю, что не рискующий проиграет, если выберет первую дверь без приза")
    void loosePlayerNotRiskChooseFirstDoor(){
        player.setRisk(false);
        Door door = game.round(0);
        Assertions.assertFalse(door.isPrize());
    }

    @Test
    @DisplayName("Утверждаю, что не рискующий проиграет, если выберет вторую дверь без приза")
    void loosePlayerNotRiskChooseSecondDoor(){
        player.setRisk(false);
        Door door = game.round(1);
        Assertions.assertFalse(door.isPrize());
    }

   @Test
   @DisplayName("Утверждаю, что рискующий игрок победит, если выберет сначала первую дверь без приза")
    void winPlayerRiskChooseFirstDoor(){
        player.setRisk(true);
        Door door = game.round(0);
        Assertions.assertTrue(door.isPrize());
    }

    @Test
    @DisplayName("Утверждаю, что рискующий игрок победит, если выберет сначала вторую дверь без приза")
    void winPlayerRiskChooseSecondDoor(){
        player.setRisk(true);
        Door door = game.round(1);
        Assertions.assertTrue(door.isPrize());
    }

    @Test
    @DisplayName("Утверждаю, что рискующий игрок проиграет, если выберет сначала третью дверь с призом")
    void loosePlayerRiskChooseThirdDoor(){
        player.setRisk(true);
        Door door = game.round(2);
        Assertions.assertFalse(door.isPrize());
    }






}
