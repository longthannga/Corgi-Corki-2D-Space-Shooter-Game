import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Ship {
    private BufferedImage image;
    private int x, y;
    private int width;
	private int height;

    public Ship(int x, int y){
        this.x = x;
		this.y = y;
		
		this.width = 100;
		this.height = 80;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("Ship.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void drawMe(Graphics g){
        g.drawImage(image , x, y, width,height, null);
    }

    public void moveUp(){
        y -= 15;
    }

    public void moveDown(){
        y += 15;
    }
    
    public int getY(){
        return y;
    }

    public boolean checkC1(Enemy1 e){
        if (e.checkVis() == true){
            int pX = x;
            int pY = y;
            int pWidth = width;
            int pHeight = height;

            int tX = e.getX();
            int tY = e.getY();
            int tHeight = e.getH();
            int tWidth = e.getW();
            if( pX+pWidth >= tX && pX <= tX + tWidth  &&  pY+pHeight >= tY && pY <= tY + tHeight ){	
                return true;		
            }  
        }
        return false;
    }

    public boolean checkC2(Enemy2 e){
        if (e.checkVis() == true){
            int pX = x;
            int pY = y;
            int pWidth = width;
            int pHeight = height;

            int tX = e.getX();
            int tY = e.getY();
            int tHeight = e.getH();
            int tWidth = e.getW();
            if( pX+pWidth >= tX && pX <= tX + tWidth  &&  pY+pHeight >= tY && pY <= tY + tHeight ){	
                return true;		
            }  
        }
        return false;
    }

    public boolean checkCollisionf(Fire fire){
        if (fire.checkVis() == true){
            int pX = x;
            int pY = y;
            int pWidth = width;
            int pHeight = height;

            int tX = fire.getX();
            int tY = fire.getY();
            int tHeight = fire.getH();
            int tWidth = fire.getW();
            if( pX+pWidth >= tX && pX <= tX + tWidth  &&  pY+pHeight >= tY && pY <= tY + tHeight ){
                //System.out.println("Collision");
                return true;		
            }  
        }
        return false;
    }

    public boolean checkCollisionB(Enemy3 e){
            if (e.checkVis() == true){
                int pX = x;
                int pY = y;
                int pWidth = width;
                int pHeight = height;

                int tX = e.getX();
                int tY = e.getY();
                int tHeight = e.getH();
                int tWidth = e.getW();
                if( pX+pWidth >= tX && pX <= tX + tWidth  &&  pY+pHeight >= tY && pY <= tY + tHeight ){
                    //System.out.println("Collision");
                    return true;		
                }  
            }
            return false;
        }
}

