package bots;

import java.util.ArrayList;
import java.util.List;

import com.gatdsen.manager.Controller;
import com.gatdsen.manager.StaticGameState;
import com.gatdsen.manager.StaticPlayerState;
import com.gatdsen.manager.player.Bot;
import com.gatdsen.simulation.Enemy.EnemyType;
import com.gatdsen.simulation.Tile;
import com.gatdsen.simulation.Tile.TileType;
import com.gatdsen.simulation.Tower.TowerType;

public class AMOGUSFURRYBOT extends Bot {
    
    public class internalTower {
        int _x; int _y;
        TowerType _type;
        int _level;

        public internalTower (int [] cords, TowerType type) {
            this._x = cords[0]; this._y = cords[1];
            this._type = type;
            this._level = 1;
        }

        public String toString () {
            return _type.toString() + "(Lvl. " + _level + ") [ " + _x + ", " + _y + "]";
        }
    }
    List<internalTower> towers;
    int currY; TowerType currTowType;
    internalTower lastActionAttempt;
    int moneten = 0;
    int currentLeveling = 2;
    String lastAction = "build";

   @Override
    public String getStudentName() {
        return "Hannes Krüger";
    }
    @Override
    public int getMatrikel() {
        return 247205;
    }
    @Override
    public String getName() {
        return "AMOGUSFURRYBOT-V.0.0.1";
    }
    @Override
    public void init(StaticGameState state) {
        towers = new ArrayList<internalTower>();
        currY = state.getBoardSizeY() - 1; currTowType = TowerType.MAGE_CAT;
        System.out.println("Der Bot \"" + getName() + "\" wurde initialisiert!");
    }
    
    @Override
    public void executeTurn(StaticGameState state, Controller controller) {

        // Check if I lost Money last Round -> An Attempted Placement / upgrade Worked!
        //! Sidenote: Why not do it with int return value to signal success or failure?!
        if (moneten > state.getMyPlayerState().getMoney()) {
            switch (lastAction) {
                case "build":
                    towers.add(lastActionAttempt);
                    System.out.println(lastActionAttempt.toString());
                    if (currTowType == TowerType.MAGE_CAT) currTowType = TowerType.MINIGUN_CAT;
                    else currTowType = TowerType.MAGE_CAT;
                    if (currY > 0) currY--;
                    break;
                case "upgrade":
                    lastActionAttempt._level++;
                    break;
                default:
                    break;
            }
        }

        StaticPlayerState myState = state.getMyPlayerState();
        Tile [][] myBoard = state.getMyPlayerState().getBoard();
        Tile [][] enemyBoard = state.getEnemyPlayerState().getBoard();

        // Im rich xD
        moneten = myState.getMoney();
        // Spawn Coins -> Mana
        int manaLol = myState.getSpawnCoins();
        // Cost to spawn EMP MVP BOIIIIIIIIII
        int empCost = myState.getEnemyCost(EnemyType.EMP_ENEMY);

        // Check if Cord is Placable
        if (myBoard[5][currY].getType() == TileType.GRASS && !(currY < 0)) {
            controller.placeTower(5, currY, currTowType);
            lastActionAttempt = new internalTower(new int[]{5, currY}, currTowType);
        } else if (currY > 0) currY--;
        else {
            boolean didAnUpgradeAttempt = false;
            for (internalTower tower : towers) {
                if (tower._level < currentLeveling) {
                    controller.upgradeTower(tower._x, tower._y);
                    lastAction = "upgrade";
                    lastActionAttempt = tower;
                    didAnUpgradeAttempt = true;
                    break;
                }
                // All Towers are Leveled to Current Level, go to next Level!
                if (!didAnUpgradeAttempt) currentLeveling++;
            }
        }



        // Always EMP, because EMP broken lol
        if (manaLol >= empCost) {
            controller.sendEnemyToPlayer(EnemyType.EMP_ENEMY);
        }

    }
}
