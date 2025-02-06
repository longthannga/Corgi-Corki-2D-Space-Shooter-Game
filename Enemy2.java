import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Enemy2 {
    private BufferedImage teemo1;
    private int x, y;
    private int width;
	private int height;
    private boolean visible = true;
    private int count;
    private int yDirection;


    public Enemy2(int x, int y){
        this.x = x;
		this.y = y;
		
		this.width = 50;
		this.height = 50;
        try {
            teemo1 = ImageIO.read(getClass().getResourceAsStream("Teemo1.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void drawMe(Graphics g){
        if (visible == true){
            g.drawImage(teemo1 , x, y, width,height, null);
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
        visible = false; 
    }

    public boolean checkVis(){
        return visible;
    }

    public void move(){
        if (yDirection == 1){
            y--;
        } else if (yDirection == 2){
            y++;
        }

        x -= 2;
        count += 2;
        if (count == 80){
            if (yDirection == 1){
                yDirection = 2;
                count = 0;
            } else {
                yDirection = 1;
                count = 0;
            }
        }

        if (y == 570){
            yDirection = 1;
        } else if (y == 10){
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
        visible = true;    
    }
}

