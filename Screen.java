import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;


public class Screen extends JPanel implements KeyListener{

    private Star[] starArray;
    private Mushroom[] mArray;
    private Fire [] fire1;
    private Fire [] fire2;
    private Fire [] fire3;
    private Projectile p1;
    private Color black = new Color(0, 0, 0);
    private Color green = new Color(0, 43, 23);
    private Ship ship = new Ship(0, 300);
    private Enemy1[] eLv1;
    private Enemy2[] eLv2;
    private Enemy3 eLv3;
    private int lv = 1;
    private Font f = new Font("Arial", Font.PLAIN, 25);
    private int live = 3;
    private int cE;

    public Screen(){
        eLv1 = new Enemy1 [3];
        for (int i = 0; i < eLv1.length; i++){
            int x = 650;
            int y = (int)(Math.random()*501);
            eLv1[i] = new Enemy1 (x, y);
        }

        eLv2 = new Enemy2 [5];
        for (int i = 0; i < eLv2.length; i++){
            int x = 650;
            int y = (int)(Math.random()*501);
            eLv2[i] = new Enemy2 (x, y);
        }

        eLv3 = new Enemy3 (550, 150);

        starArray = new Star[100];
        p1 = new Projectile(70, 350);
        for (int i = 0; i < starArray.length; i++){
            starArray[i] = new Star ();
        }

        mArray = new Mushroom[30];
        for (int i = 0; i < mArray.length; i++){
            mArray[i] = new Mushroom ();
        }

        fire1 = new Fire [5];
        for (int i = 0; i < fire1.length; i++){
            fire1[i] = new Fire (eLv3.getX(), eLv3.getY() + 150);
        }

        fire2 = new Fire [5];
        for (int i = 0; i < fire2.length; i++){
            fire2[i] = new Fire (eLv3.getX(), eLv3.getY() + 100);
        }

        fire3 = new Fire [5];
        for (int i = 0; i < fire3.length; i++){
            fire3[i] = new Fire (eLv3.getX(), eLv3.getY() + 200);
        }
        setFocusable(true);
        addKeyListener(this);
    }

	
	public Dimension getPreferredSize(){
		//Sets the size of the panel
		return new Dimension(800,600);
	}

	public void paintComponent(Graphics g){
        super.paintComponent(g);

        if (lv == 1){
            cE = eLv1.length;
            //background
            g.setColor(black);
            g.fillRect(0, 0, 800, 600);

            //stars
            for (int i = 0; i < starArray.length; i++){
                starArray[i].drawMe(g);
            }

           
            for (int i = 0; i < eLv1.length; i++){
                eLv1[i].drawMe(g);
            }

            for (int i = 0; i < eLv1.length; i++){
                if (!eLv1[i].checkVis())
                    cE --;
            }
            
            if (cE == 0){
                lv++;
                cE = eLv2.length;
                p1.back();
            }
        }

        if (lv == 2){
            cE = eLv2.length;
            g.setColor(green);
            g.fillRect(0, 0, 800, 600);

            //mushroom
            for (int i = 0; i < mArray.length; i++){
                mArray[i].drawMe(g);
            }

            for (int i = 0; i < eLv2.length; i++){
                eLv2[i].drawMe(g);
            }

            for (int i = 0; i < eLv2.length; i++){
                if (!eLv2[i].checkVis())
                    cE --;
            }

            if (cE == 0){
                lv++;
                cE = 1;
                p1.back();
            }
        }

        if (lv == 3){
            eLv3.drawMe(g);
            for (int i = 0; i < fire1.length; i++){
                fire1[i].drawMe(g);
            }
            for (int i = 0; i < fire2.length; i++){
                fire2[i].drawMe(g);
            }
            for (int i = 0; i < fire3.length; i++){
                fire3[i].drawMe(g);
            }
        }

        if (live <= 0){
            lv = 5;
        }

        ship.drawMe(g);
        p1.drawMe(g);

        g.setFont(f);
        g.setColor(Color.WHITE);
        g.drawString("Level: " + lv, 10, 30);
        g.drawString("Lives: " + live, 10, 60);

        if (lv == 5){
            g.setColor(black);
            g.fillRect(0, 0, 800, 600);
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER!", 300, 275);
            g.drawString("Press R to restart.", 280, 320);
        }

        if (lv == 4){
            g.setColor(black);
            g.fillRect(0, 0, 800, 600);
            g.setColor(Color.WHITE);
            g.drawString("YOU WON!", 300, 275);
            g.drawString("Press R to restart.", 280, 320);
        }
	}

    public void animate(){
        while (true){
            //move projectitile
            p1.moveRight();

            //lv1
            if (lv == 1){
                for (int i = 0; i < eLv1.length; i++){
                    eLv1[i].move();
                    if (eLv1[i].checkVis()){
                        if (eLv1[i].checkLive() || ship.checkC1(eLv1[i])){
                            live --;
                            // go through the enemy array and reset each one
                            for (int j = 0; j < eLv1.length; j++){
                                int x = 650;
                                int y = (int)(Math.random()*501);
                                eLv1[j].changeX(x, y);
                            }
                            p1.back();
                        }
                    }
                }
                
                //check collision between each enemy
                for(int i = 0; i < eLv1.length; i++){
                    p1.checkCollision1(eLv1[i]);
                }

                for (int i = 0; i < starArray.length; i++){
                    starArray[i].move();
                }
            }

            //lv2
            if (lv == 2){
                for (int i = 0; i < mArray.length; i++){
                    mArray[i].move();
                }

                for (int i = 0; i < eLv2.length; i++){
                    eLv2[i].move();
                    if (eLv2[i].checkVis()){
                        if (eLv2[i].checkLive() || ship.checkC2(eLv2[i])){
                            live --;
                            for (int j = 0; j < eLv2.length; j++){
                                int x = 650;
                                int y = (int)(Math.random()*501);
                                eLv2[j].changeX(x, y);
                            }
                            p1.back();
                        }
                    }
                }

                for(int i = 0; i < eLv2.length; i++){
                    p1.checkCollision2(eLv2[i]);
                }
            }

            //lv3
            if (lv == 3){
                eLv3.move();
                for (int i = 0; i < fire1.length; i++){
                    fire1[i].moveLeft(eLv3, 150);
                    if ((i % 5) == 1){
                        fire1[i].changeY(1);
                    } else if ((i % 5) == 2){
                        fire1[i].changeY(2);
                    } else if ((i % 5) == 3){
                        fire1[i].changeY(3);
                    } else if ((i % 5) == 4){
                        fire1[i].changeY(4);
                    }
                }

                for (int i = 0; i < fire2.length; i++){
                    if (fire2[i].checkVis()){
                        fire2[i].moveLeft(eLv3, 100);
                        if ((i % 5) == 1){
                            fire2[i].changeY(1);
                        } else if ((i % 5) == 2){
                            fire2[i].changeY(2);
                        } else if ((i % 5) == 3){
                            fire2[i].changeY(3);
                        } else if ((i % 5) == 4){
                            fire2[i].changeY(4);
                        }
                    }
                }

                for (int i = 0; i < fire3.length; i++){
                    if (fire3[i].checkVis()){
                        fire3[i].moveLeft(eLv3, 200);
                        if ((i % 5) == 1){
                            fire3[i].changeY(1);
                        } else if ((i % 5) == 2){
                            fire3[i].changeY(2);
                        } else if ((i % 5) == 3){
                            fire3[i].changeY(3);
                        } else if ((i % 5) == 4){
                            fire3[i].changeY(4);
                        }
                    }
                }


                p1.checkCollision3(eLv3);
                if (eLv3.checkVis() == false)
                    lv ++;

                
                for (int i = 0; i < fire1.length; i ++){
                    p1.checkCollisionf(fire1[i]);
                }

                for (int i = 0; i < fire3.length; i ++){
                    p1.checkCollisionf(fire3[i]);
                }
            
                for (int i = 0; i < fire2.length; i ++){
                    p1.checkCollisionf(fire2[i]);
                }


                for (int i = 0; i < fire1.length; i++){
                    for (int j = 0; j < fire2.length; j++){
                        for (int k = 0; k < fire3.length; k++){
                            if (ship.checkCollisionf(fire1[i]) || ship.checkCollisionf(fire2[j]) || ship.checkCollisionf(fire3[k]) || ship.checkCollisionB(eLv3)){
                                    live --;
                                    p1.back();
                                    eLv3.changeX(550);
                                    for (int l = 0; l < fire1.length; l++){
                                        fire1[l].back(eLv3.getX(), eLv3.getY() + 150);
                                    }
                                    for (int l = 0; l < fire2.length; l++){
                                        fire2[l].back(eLv3.getX(), eLv3.getY() + 100);
                                    }
                                    for (int l = 0; l < fire3.length; l++){
                                        fire3[l].back(eLv3.getX(), eLv3.getY() + 200);
                                    }
                                }
                            }
                        }
                    }
                }

                

            //wait to slow it down
            try{
                Thread.sleep(25);
            } catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }

            repaint();
        }
    }

	public void keyPressed(KeyEvent e){
        //System.out.println(e.getKeyCode());
        if (e.getKeyCode() == 38){ //up arrow
            //move the ship up
            ship.moveUp();

        }else if(e.getKeyCode() == 40){ //down arrow
            //move the ship down
            ship.moveDown();
        }else if (e.getKeyCode() == 32){
            //make the projective to where the ship is
            p1.changeY(ship.getY());

            //fire the projective
            p1.changeVis();
        //cheat code
        } else if (e.getKeyCode() == 79){
            lv += 1;
            p1.back();
        //restart the game
        } else if (e.getKeyCode() == 82){
            if (lv >= 4){
                lv = 1;
                live = 3;
                p1.back();

                for (int i = 0; i < eLv2.length; i++){
                    int x = 650;
                    int y = (int)(Math.random()*501);
                    eLv2[i].changeX(x, y);
                    eLv2[i].appear();;
                }

                for (int i = 0; i < eLv1.length; i++){
                    int x = 650;
                    int y = (int)(Math.random()*501);
                    eLv1[i].changeX(x, y);
                    eLv1[i].appear();
                }

                eLv3.aLive();
                for (int i = 0; i < fire1.length; i++){
                    fire1[i].back(eLv3.getX(), eLv3.getY() + 150);
                }
                for (int i = 0; i < fire2.length; i++){
                    fire2[i].back(eLv3.getX(), eLv3.getY() + 100);
                }
                for (int i = 0; i < fire3.length; i++){
                    fire3[i].back(eLv3.getX(), eLv3.getY() + 200);
                }
            }
        }
    }

    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
}
