import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Projectile{
	private int x;
	private int y;
	
	private int width;
	private int height;
	
    private BufferedImage pr;

    private boolean vis;

	
	public Projectile(int x, int y){
		
		this.x = x;
		this.y = y;
		
		this.width = 30;
		this.height = 20;
		this.vis = false;

        try {
            pr = ImageIO.read(getClass().getResourceAsStream("projectile.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }


	}
	

	public void drawMe(Graphics g){
		if (vis == true){
            g.drawImage(pr, x, y, width, height, null);
        }
	}

    public void changeVis(){
        vis = true;
    }

    public void back(){
        vis = false;
        x = 70;
    }

    public void moveRight(){
        if (vis == true)
            x += 5;
        if (x > 800){
            x = 70;
            vis = false;
        }
    }

    public void changeY(int n){
        if (vis == false){
            y = n + 20;
        }
    }
	
    public void checkCollision1(Enemy1 e){
        if (vis == true){
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
                    e.disappearY();	
                    vis = false;
                    x = 70;		
                }  
            }
        }
    }

    public void checkCollision2(Enemy2 e){
        if (vis == true){
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
                    e.disappearY();	
                    vis = false;
                    x = 70;		
                }  
            }
        }
    }

    public void checkCollision3(Enemy3 e){
        if (vis == true){
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
                    e.mLive();
                    if (e.rLive() == 0){
                        e.disappearY();	
                    }
                    vis = false;
                    x = 70;		
                }  
            }
        }
    }

    public void checkCollisionf(Fire fire){
        if (vis == true){
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
                    fire.disappear();	
                    vis = false;
                    x = 70;		
                }  
            }
        }
    }
}

