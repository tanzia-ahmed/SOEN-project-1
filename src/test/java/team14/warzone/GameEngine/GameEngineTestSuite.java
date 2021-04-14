package team14.warzone.GameEngine;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import team14.warzone.GameEngine.Commands.*;
import team14.warzone.GameEngine.State.GameOverPhaseTest;
import team14.warzone.GameEngine.State.IssueOrdersPhaseTest;
import team14.warzone.GameEngine.State.PreMapLoadPhaseTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        GameEngineTest.class,
        AdvanceTest.class, AirliftTest.class, BlockadeTest.class, BombTest.class, DeployTest.class,
        DiplomacyTest.class,
        IssueOrdersPhaseTest.class, PreMapLoadPhaseTest.class, GameOverPhaseTest.class,
        CardTest.class, GameSaveTest.class, GameLoadTest.class
})

/**
 * Test Suite for GameEngine
 */
public class GameEngineTestSuite {
//place holder
}
