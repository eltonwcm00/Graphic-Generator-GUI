import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CircleDrawing extends JFrame implements ActionListener{
    
    private JButton bt;
    private JPanel p1, p2, p3, p4;
    private JLabel lbTitle, lbEnter1, lbEnter2, lbCenterX1, lbCenterY1, lbRadius1,
                   lbCenterX2, lbCenterY2, lbRadius2;
    private double centerX1 = 0, centerY1 = 0, centerX2 = 0, centerY2 = 0, radius1 = 0, radius2 = 0; 
    public static void main(String[] args) {
        
        CircleDrawing cd = new CircleDrawing();
        cd.setSize(500,360);
        cd.setVisible(true);
        cd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cd.setTitle("Circle Drawing");
    } 

    public CircleDrawing() {

        Border border = LineBorder.createGrayLineBorder();
        setLayout(new BorderLayout());

        // panel 1
        lbTitle = new JLabel("Two circles intersect ?");
        p1 = new JPanel();
        p1.add(lbTitle);

        add(p1, BorderLayout.CENTER);

        // panel 2

        
    }
}