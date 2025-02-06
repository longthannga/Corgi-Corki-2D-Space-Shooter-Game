import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Enemy3 {
    private BufferedImage boss;
    private BufferedImage map;
    private int x, y;
    private int width;
	private int height;
    private boolean visible = true;
    private int live = 5;


    public Enemy3(int x, int y){
        this.x = x;
		this.y = y;
		
		this.width = 250;
		this.height = 300;
       
        try {
            boss = ImageIO.read(getClass().getResourceAsStream("Boss.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        try {
            map = ImageIO.read(getClass().getResourceAsStream("map3 .jpeg"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void drawMe(Graphics g){
        if (visible == true){
            g.drawImage(map, 0, 0, 800, 600,  null);
            g.drawImage(boss , x, y, width,height, null);
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
        x--;
    }

    public void mLive(){
        live --;
    }

    public int rLive(){
        return live;
    }

    public void changeX(int n){
        x = n;
    }

    public void aLive(){
        live = 5;
        visible = true;
        x = 550;
    }
}
