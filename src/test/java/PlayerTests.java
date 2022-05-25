import com.example.final_project_liu_caleb.Circle;
import com.example.final_project_liu_caleb.Player;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Player class tests
public class PlayerTests {
    @Test
    //tests the getters when creating a Player object using the argument constructor
    public void GettersArgConstructor(){
        Player p2=new Player(0,50,200, Color.BLUE);

        assertEquals(0,p2.getPosX());
        assertEquals(Color.BLUE,p2.getColor());
        assertEquals(200,p2.getHeight());
        assertEquals(50,p2.getWidth());
    }
    @Test
    //tests the getters when creating a Player object using the no-arg constructor
    public void GettersNoArgConstructor(){
        Player p1=new Player();

        assertEquals(Color.BLACK,p1.getColor());
        assertEquals(100,p1.getHeight());
        assertEquals(25,p1.getWidth());
    }

    @Test
    //tests the setters of player
    public void setters(){
        Player p1=new Player();

        p1.setPosY(100);

        assertEquals(100,p1.getPosY());
    }

    @Test
    //tests the positioning of the bot according to the positioning of the ball
    public void botMovementTest(){
        Player p1=new Player();
        Circle c1=new Circle(50,70,24,Color.BLACK,3,4);

        /*
        50<100-100/6
        50<83.33 -> true
        70-50 = 20
        posY = 20
        */
        p1.movementBot(c1,100);
        assertEquals(20,p1.getPosY());

        /*
        80>20-50
        80>70 -> true
        80-70 = 10
        since posY += 1 ;
        20+1
        =21
        */
        c1.setPosX(90);
        c1.setPosY(80);
        p1.movementBot(c1,100);
        assertEquals(21,p1.getPosY());

        //theoretical values
        /*
        60>21+250/2
        60>146 -> false
        since posY -= 1 ;
        21-1
        =20
        */
        c1.setPosY(60);
        p1=new Player(75,25,250,Color.BLACK);
        p1.setPosY(21);
        p1.movementBot(c1,100);
        assertEquals(20,p1.getPosY());
    }

}
