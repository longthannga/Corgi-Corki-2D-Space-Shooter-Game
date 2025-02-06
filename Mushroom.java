import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Mushroom {
    private int x, y;
    private BufferedImage m;

    public Mushroom(){
        x = (int)(Math.random()*798);
        y = (int)(Math.random()*598);
        try {
            m = ImageIO.read(getClass().getResourceAsStream("mushrooms.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void drawMe(Graphics g){
        g.drawImage(m, x, y, 50, 50, null);
    }

    public void move(){
        x -= 1;
        if (x < 0){
            x = 800;
            y = (int)(Math.random()*598);
        }
    }
    
}
