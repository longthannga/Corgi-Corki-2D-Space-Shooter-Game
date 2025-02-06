import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Enemy1 {
    private BufferedImage yuumi;
    private int x, y;
    private int width;
	private int height;
    private boolean visibleY = true;
    private int count;
    private int yDirection;

    public Enemy1(int x, int y){
        this.x = x;
		this.y = y;
        yDirection = 1;
		
		this.width = 100;
		this.height = 80;
        try {
            yuumi = ImageIO.read(getClass().getResourceAsStream("Yuumi.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void drawMe(Graphics g){
        if (visibleY == true){
            g.drawImage(yuumi , x, y, width,height, null);
        }
    }
    
    public int  getX(){
        return x;
    }

    public int  getY(){
        return y;
    }

    public int  getW(){
        return width;
    }

    public int  getH(){
        return height;
    }

    public void disappearY(){
        visibleY = false; 
    }

    public boolean checkVis(){
        return visibleY;
    }

    public void move(){
        if (yDirection == 1){
            y--;
        } else if (yDirection == 2){
            y++;
        }

        x -= 1;
        count ++;
        if (count == 200){
            if (yDirection == 1){
                yDirection = 2;
                count = 0;
            } else {
                yDirection = 1;
                count = 0;
            }
        }

        if (y >= 550){
            yDirection = 1;
        } else if (y <= 10){
            yDirection = 2;
        }
    }

    public void changeX(int n, int p){
        x = n;
        y = p;
    }
    
    public boolean checkLive(){

        if (x == 0){
            return true;
        }
        return false;
    }

    public void appear(){
        visibleY = true;    
    }
}
