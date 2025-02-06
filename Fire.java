import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Fire{
	private int x;
	private int y;
	
	private int width;
	private int height;

    private boolean vis;
	
    private BufferedImage pr;

	
	public Fire(int x, int y){
		
		this.x = x;
		this.y = y;

        vis = true;
		
		this.width = 50;
		this.height = 50;

        try {
            pr = ImageIO.read(getClass().getResourceAsStream("Fire.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }


	}
	

	public void drawMe(Graphics g){
		if (vis == true){
            g.drawImage(pr, x, y, width, height, null);
        }   
	}


    public void moveLeft(Enemy3 e, int n){
        
        x -= 2;
        if (x < 0){
            vis = true;
            x = e.getX();
            y = e.getY() + n;
        }
            
    }

    public void changeY(int n){
        if (n == 1){
            y += 1;
        } else if (n == 2){
            y -= 1;
        } else if (n == 3){
            y -= 2;
        } else if (n == 4){
            y += 2;
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

    public boolean checkVis(){
        return vis;
    }

    public void disappear(){
        vis = false;
    }

    public void back(int i, int j){
        vis = true;
        x = i;
        y = j;
    }

    public void appear(){
        vis = true;
    }

}
