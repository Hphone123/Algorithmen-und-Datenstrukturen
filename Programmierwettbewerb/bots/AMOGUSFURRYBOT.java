import com.gatdsen.manager.Controller;
import com.gatdsen.manager.StaticGameState;
import com.gatdsen.manager.player.Bot;
import com.gatdsen.simulation.Tower;

public class AMOGUSFURRYBOT extends Bot {
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
        System.out.println("Der Bot \"" + getName() + "\" wurde initialisiert!");
    }
}
