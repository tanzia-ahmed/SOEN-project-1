package team14.warzone.GameEngine.State;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import team14.warzone.Console.Console;
import team14.warzone.GameEngine.GameEngine;
import team14.warzone.MapModule.AdapterMapEditor;
import team14.warzone.MapModule.MapEditorConquest;

import java.util.ArrayList;
import java.util.List;

public class TournamentTest {
     /**
     * console field
     */
    private static Console d_Console;
    /**
     * map editor field
     */
    private static AdapterMapEditor d_MapEditor;
    /**
     * game engine field
     */
    private static GameEngine d_GE;

    @Before
    public void setup() {
        // object instantiation
        d_Console = new Console();
        d_MapEditor = new AdapterMapEditor(new MapEditorConquest());
        d_GE = new GameEngine(d_Console, d_MapEditor);
    }
    
    @Test
    @DisplayName("Testing Tournament")
    public void tournamentRun() {
        //tournament -M listofmapfiles -P listofplayerstrategies -G numberofgames -D maxnumberofturns
        //tournament -M bigeurope.map -P aggressive random aggressive -G 2 -D 4
        List<String> l_MapList = new ArrayList<>();
        l_MapList.add("bigeurope.map");
        l_MapList.add("europass.map");
        List<String> l_PlayerList = new ArrayList<>();
        l_PlayerList.add("aggressive");
        l_PlayerList.add("benevolent");
        l_PlayerList.add("random");
        String l_NumofGame = "3";
        String l_NumofTurn = "4";

        Tournament t = new Tournament(d_GE);
        t.tournamentAddMaps(l_MapList);
        t.tournamentAddPlayersStrategies(l_PlayerList);
        t.tournamentNumOfGames(l_NumofGame);
        t.tournamentMaxNumOfTurns(l_NumofTurn);

        t.run();

    }
     /**
     * tear down after all test run
     */
    @AfterClass
    public static void tearDown() {
        d_Console = null;
        d_MapEditor = null;
        d_GE = null;
    }
    
}
