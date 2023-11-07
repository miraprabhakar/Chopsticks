
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.*;

//import javax.swing.JRootPane;

//import java.awt.event.*;
import javax.swing.*;


public class GameFrame extends JFrame {

    JButton startButton;
    JLabel label1;
    
    private Image handright1;
    private Image handright2;
    private Image handright3;
    private Image handright4;
    private Image handright5;
    
    public GameFrame(){
        super();
        GamePanel g = new GamePanel();
        this.setTitle("START GAME");
        
        // add title
        JLabel title = new JLabel("CHOPSTICKS");
        title.setForeground(Color.yellow);
        title.setFont(new Font("Khand", Font.BOLD, 50 ));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        g.add(title);
        
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
        
        label1 = new JLabel("R",ii1, JLabel.CENTER);
        //Set the position of the text, relative to the icon:
        label1.setVerticalTextPosition(JLabel.BOTTOM);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        
        
       
        this.setResizable(false);
        this.setSize(800,500);
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(label1);
        this.add(g);
        this.pack();
    }

    public static void main(String[] args){

        GameFrame f = new GameFrame();
        f.setVisible(true);
        // Runnable r = new Runnable() {
        //     public void run() {
        //         GameFrame f = new GameFrame();
        //         // f.setSize(300, 300);  better to pack() the frame
        //        // f.getContentPane().add(new HelloJava1());
        //         // pack should be AFTER components are added..
        //     }
        // };
        // // Swing GUIs should be created and updated on the EDT
        // r.run();
        // EventQueue.invokeLater(() -> {
            
        //     SwingUtilities.invokeLater(r);
        // });

    }

}

