import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Paint implements ActionListener{
    JFrame f;
    JButton b1;
    JButton b2;
    JTextField t;
    JPanel p1;
    Drawing d;
    Paint(){
        f = new JFrame("paint");
        Container content = f.getContentPane();
        b1 = new JButton("clear");
        b2 = new JButton("save");
        t = new JTextField("enter comments for this page");
        content.setLayout(new BorderLayout());
        d = new Drawing();
        content.add(d,BorderLayout.CENTER);
        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(b1);p1.add(b2);
        content.add(p1,BorderLayout.EAST);
        content.add(t,BorderLayout.SOUTH);
        b1.addActionListener(this);
        b2.addActionListener(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800,1000);
        f.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Paint();
    }

    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            d.clear();
        }
        if(e.getSource()==b2){
            Image bi = d.image;
            File outputfile = new File("saved.png");
            try {
                ImageIO.write((RenderedImage) bi, "png", outputfile);
            } catch (IOException ex) {
                
            }
        }
        System.out.println("chala to");
    }
    
}
