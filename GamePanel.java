
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.FontMetrics;
import java.awt.*;
import java.util.*;

//import javax.swing.JRootPane;
import javax.swing.plaf.DimensionUIResource;
//import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Toolkit;
import javax.swing.Timer;



public class GamePanel extends JPanel implements ActionListener{

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGTH = 600;
    static final int CHOPSTICK_WIDTH = 25;
    static final int CHOPSTICK_HEIGTH = 75;
    boolean running = false;
    Timer timer;
    Random random;
    int level = 0;
    
    int terminate = 0;
    public int ps1;
    public int ps2;
    public int cs1;
    public int cs2;

    public Graphics g;
    
    private Image handright1;
    private Image handright2;
    private Image handright3;
    private Image handright4;
    private Image handright5;
    

    GamePanel(){
        this.setPreferredSize(new DimensionUIResource(SCREEN_WIDTH, SCREEN_HEIGTH));
        this.setBackground(Color.white); 
        this.setFocusable(true);
        this.setVisible(true);
        //loadImages();
        startGame();
        //paintComponent(g);
    }
    
    private void loadImages() {

        ImageIcon ii1 = new ImageIcon("Hand_Right5.png");
        handright1 = ii1.getImage();

        ImageIcon ii2 = new ImageIcon("Hand_Right4.png");
        handright2 = ii2.getImage();

        ImageIcon ii3 = new ImageIcon("Hand_Right3.png");
        handright3 = ii3.getImage();
        
        ImageIcon ii4 = new ImageIcon("Hand_Right2.png");
        handright4 = ii4.getImage();
        
        ImageIcon ii5 = new ImageIcon("Hand_Right.png");
        handright5 = ii5.getImage();
    }
    
    
    public void startGame(){
        running = true;
        timer = new Timer(1000, this);
        timer.start();
    }
    
    public int getWinner(){
        if(cs1 ==0 && cs2 ==0){//checks if both computer hands are dead
            return 1;
        }
        if(ps1 ==0 && ps2 ==0){//checks if both player hands are dead
            return 2;
        }
        else{
            return 0;
        }
    }
    
    public void compTurn(){
       System.out.println("COMPUTER TURN: ");
       int check = 0;
       
       int comphand = (int)(Math.random()*2)+1;
       
       
       int playerhand = (int)(Math.random()*2)+1;
       int possplay = this.checkEndPlay();
       
       if(comphand ==1 && cs1==0){
           comphand = 2;
        }
       if(comphand ==2 && cs2==0){
           comphand = 1;
        }
       if(playerhand ==1 && ps1==0){
           comphand = 2;
        }
       if(playerhand ==2 && ps2==0){
           comphand = 1;
        }
       
        if(possplay == 1){
          ps1+=cs1;
           check++;
        }
        else if(possplay == 2){
           ps2+=cs1;
           check++;
        }
        else if(possplay == 3){
           ps1+=cs2;
           check++;
        }
        else if(possplay == 4){
           ps2+=cs2;
           check++;
        }
       
       if(check == 0){ 
           if(comphand == 1 && cs1>0){
               if(playerhand == 1 && ps1 > 0){//check if the hand randomly generated is less than 5
                   ps1 += cs1;
                }
                else if (playerhand == 2 && ps2 >0){
                    ps2 += cs1;
                }
        
            }
            else{
                comphand = 2;// and if it is not under 5 we switch it
            }
            if(comphand ==2 && cs2>0){
                if(playerhand == 1 && ps1 > 0){
                    ps1 += cs2;
                }
                else if (playerhand == 2 && ps2 >0){
                    ps2 += cs2;
                }
            }
            
        }
        //setZero();
       
    }
    

    
     public boolean checkFives(){
        if(cs1 ==0 && cs2 ==0){
            return true;
        }
        if(ps1==0 && ps2 ==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void playerTurn()
    {
       int playerhand = 0;
       int comphand = 0;
       
       //sets playerhand and comphand to a legal value
       while(playerhand != 1 && playerhand != 2 && playerhand != 3){
       //mouse event on Jlabel
       //playerhand = keyboard.nextInt();
       }
       while(comphand != 1 && comphand != 2 && comphand != 3){
       //mouse event on Jlabel
       //comphand = keyboard.nextInt();
       }
    
    
       if(playerhand == 1){
           if(comphand == 1){
               cs1 += ps1;
           }
           else if (comphand == 2){
               cs2 += ps1;
           }
           else if (comphand == 3 && ps1%2 ==0){//this is mitosis(when u redistribute) ,can only be done if the value is even
               ps2 += ps1/2;
               ps1 -= ps1/2;
           }
       }
       else{
            if(comphand == 1){
               cs1 += ps2;
           }
           else if (comphand == 2){
               cs2 += ps2;
           }
           else if (comphand == 3 && ps2%2 ==0){//mitosis clause again
               ps1 += ps2/2;
               ps2 -= ps2/2;
           }
       }
       //setZero();
    }
    
    public int checkEndPlay(){
        if(ps1+cs1 >=5 && cs1<5 && ps1<5){
            return 1;
        }
        else if (ps2+cs1 >=5 && cs1<5 && ps2<5){
            return 2; 
        }
        else if(ps1+cs2 >=5 && cs2<5 && ps1<5){
            return 3;
        }
        else if(ps2+cs2 >=5 && cs2<5 && ps2<5){
            return 4;
        }
        else{
            return 0;
        }
    }

    public int decideMitosis(){
        if(cs1 % 2 == 0 && cs2 == 0){
            return 1;
        }
        else if(cs2 % 2 == 0 && cs1 == 0){
            return 2;
        }
        else{
            return 0;
        }
    }

        
    
    /*
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawChop(g);
    }

    public void drawChop(Graphics g){
        if(running){
            g.drawRect(10,10, CHOPSTICK_WIDTH, CHOPSTICK_HEIGTH);
            //Toolkit.getDefaultToolkit().sync();
        }else {
            gameOver(g);
        }
            
    }
    */

    public void gameOver(Graphics g){
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (SCREEN_WIDTH - metr.stringWidth(msg)) / 2, SCREEN_HEIGTH / 2);

    }

    public void actionPerformed(ActionEvent e){
        System.out.println("action: " +e);

    }
    // public static void main(String[] args){

    //     new graphic();

    //     /*
    //     javax.swing.SwingUtilities.invokeLater(new Runnable() {
    //         public void run(){
    //             openingPanel();
    //         }
    //     });
    //     */
    // }

}