import com.example.final_project_liu_caleb.Score;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTests {

    @Test
    //tests the getters when creating a Score object using the no-arg constructor
    public void GettersNoArgConstructor(){
        Score s1=new Score();

        assertEquals(Color.AQUA,s1.getColor());
    }

    @Test
    //tests the getters when creating a Score object using the argument constructor
    public void GettersArgConstructor(){
        Score s1=new Score(Color.AQUA);

        assertEquals(Color.AQUA,s1.getColor());
    }

    @Test
    //tests the setters
    public void setters(){
        Score s1=new Score(Color.AQUA);

        s1.setScore(0);

        assertEquals(0,s1.getScore());
    }

    @Test
    //tests the method compareTo that returns the player that won
    public void compareTest(){
        Score ping=new Score(Color.AQUA);
        Score pong=new Score(Color.AQUA);

        ping.setScore(5);
        pong.setScore(9);

        System.out.println(ping.compareTo(pong));
    }
}
