import com.example.final_project_liu_caleb.Score;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTests {
    @Test
    public void GettersArgConstructor(){
        Score s1=new Score(Color.AQUA);

        assertEquals(Color.AQUA,s1.getColor());
    }

    @Test
    public void setters(){
        Score s1=new Score(Color.AQUA);

        s1.setScore(0);

        assertEquals(0,s1.getScore());
    }

    @Test
    public void compareTest(){
        Score ping=new Score(Color.AQUA);
        Score pong=new Score(Color.AQUA);

        ping.setScore(5);
        pong.setScore(9);

        System.out.println(ping.compareTo(pong));
    }
}
