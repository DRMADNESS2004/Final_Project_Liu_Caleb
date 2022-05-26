import com.example.final_project_liu_caleb.Circle;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Circle class tests
public class CircleTests {
    @Test
    //tests the getters when creating a Circle object using the argument constructor
    public void GettersArgConstructor(){
        Circle c1=new Circle(250,500,54, Color.ALICEBLUE,3,1.2);

        assertEquals(250,c1.getPosX());
        assertEquals(500,c1.getPosY());
        assertEquals(54,c1.getRadius());
        assertEquals(Color.ALICEBLUE,c1.getColor());
        assertEquals(3,c1.getSpeedX());
        assertEquals(1.2,c1.getSpeedY());
    }

    @Test
    //tests the getters when creating a Circle object using the no-arg constructor
    public void GettersNoArgConstructor(){
        Circle c1=new Circle();

        assertEquals(25,c1.getRadius());
        assertEquals(Color.rgb(151, 199, 247),c1.getColor());
        assertEquals(1,c1.getSpeedX());
        assertEquals(1,c1.getSpeedY());
    }

    @Test
    //tests the setters
    public void setters(){
        Circle c1=new Circle();

        c1.setPosX(20);
        c1.setPosY(56);
        c1.setSpeedX(234);
        c1.setSpeedY(89);

        assertEquals(20,c1.getPosX());
        assertEquals(56,c1.getPosY());
        assertEquals(234,c1.getSpeedX());
        assertEquals(89,c1.getSpeedY());
    }

    @Test
    //tests the modifications of the attributes posX and posY when the method movement() is called
    public void positionModifications(){
        Circle c1=new Circle();
        c1.setPosX(400);
        c1.setPosY(250);
        c1.movement();

        assertEquals(401,c1.getPosX());
        assertEquals(251,c1.getPosY());
    }

    @Test
    //tests the modifications of the attributes speedX and speedY when the method speedIncrease() is called
    public void speedModifications(){
        Circle c1=new Circle();

        c1.setSpeedX(-1);
        c1.setSpeedY(-9);
        c1.speedIncrease();

        assertEquals(2, c1.getSpeedX());
        assertEquals(-9.5,c1.getSpeedY());
    }

    @Test
    //tests the modifications of the attributes posX and posY when the method movement() is called
    public void randomSpeedTest(){
        Circle c1=new Circle();
        c1.randomSpeed();
        double speedX=c1.getSpeedX();
        double speedY=c1.getSpeedY();

        if(speedX==1&&speedY==1){
            assertEquals(1,c1.getInitialSpeedX());
            assertEquals(1,c1.getInitialSpeedY());
        }
        else if(speedX==-1&&speedY==-1){
            assertEquals(-1,c1.getInitialSpeedX()*-1);
            assertEquals(-1,c1.getInitialSpeedY()*-1);
        }
        else if(speedX==-1&&speedY==1){
            assertEquals(-1,c1.getInitialSpeedX()*-1);
            assertEquals(1,c1.getInitialSpeedY());
        }
        else{
            assertEquals(1,c1.getInitialSpeedX());
            assertEquals(-1,c1.getInitialSpeedY()*-1);
        }
    }
}
