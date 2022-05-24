import com.example.final_project_liu_caleb.Circle;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleTests {
    @Test
    public void settersGettersArgConstructor(){
        Circle c1=new Circle(250,500,54, Color.ALICEBLUE,3,1.2);

        assertEquals(250,c1.getPosX());
        assertEquals(500,c1.getPosY());
        assertEquals(54,c1.getRadius());
        assertEquals(Color.ALICEBLUE,c1.getColor());
        assertEquals(3,c1.getSpeedX());
        assertEquals(1.2,c1.getSpeedY());
    }

    @Test
    public void settersGettersNoArgConstructor(){
        Circle c1=new Circle();

        assertEquals(400,c1.getPosX());
        assertEquals(250,c1.getPosY());
        assertEquals(25,c1.getRadius());
        assertEquals(Color.BLACK,c1.getColor());
        assertEquals(1,c1.getSpeedX());
        assertEquals(1,c1.getSpeedY());
    }
}
