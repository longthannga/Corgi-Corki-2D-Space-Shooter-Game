import java.awt.Color;
import java.awt.Graphics;


public class Star{
    private int x, y;
    private Color white;

    public Star(){
        x = (int)(Math.random()*798);
        y = (int)(Math.random()*598);
        white = new Color(255,255,255);
    }

    public void drawMe(Graphics g){
        g.setColor(white);
        g.fillRect(x, y, 3, 3);
    }

    public void move(){
        x -= 1;
        if (x < 0){
            x = 800;
            y = (int)(Math.random()*598);
        }
    }

	

	
}
