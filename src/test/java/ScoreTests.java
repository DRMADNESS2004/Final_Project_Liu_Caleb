import com.example.final_project_liu_caleb.Score;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTests {
    @Test
    public void settersGettersArgConstructor(){
        Score s1=new Score(50,50, Color.AQUA);

        assertEquals(50,s1.getWidth());
        assertEquals(50,s1.getHeight());
        assertEquals(Color.AQUA,s1.getColor());
    }
}
