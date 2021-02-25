import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CircleDrawing extends JFrame implements ActionListener{
    
    private JButton bt;
    private JPanel p1, p2, p3, p4;
    private JPanel p3subp, p3subp2, p3subp3, p3subp4, p4subp1, p4subp2, p4subp3, p4subp4;
    private JLabel lbTitle, lbTitleP3, lbTitleP4, lbEnter1, lbEnter2, lbCenterX1, lbCenterY1, lbRadius1,
                   lbCenterX2, lbCenterY2, lbRadius2;
    private JTextField tfCenterX1, tfCenterY1, tfRadius1,tfCenterX2, tfCenterY2, tfRadius2;
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
        p1 = new JPanel();
        lbTitle = new JLabel("Two circles intersect ?");
            p1.add(lbTitle);

        add(p1, BorderLayout.CENTER);


        // panel 3
        p3 = new JPanel();
        p3subp = new JPanel();
        p3subp2 = new JPanel();
        p3subp3 = new JPanel();
        p3subp4 = new JPanel();
            lbTitleP3 = new JLabel("Enter circle 1 info");
            lbCenterX1 = new JLabel("Center x :");
            lbCenterY1 = new JLabel("Center y :");
            lbRadius1 = new JLabel("Radius :  ");
            tfCenterX1 = new JTextField(5);
            tfCenterY1 = new JTextField(5);
            tfRadius1 = new JTextField(5);
                p3subp.add(lbTitleP3);
                p3subp2.add(lbCenterX1);
                p3subp2.add(tfCenterX1);
                p3subp3.add(lbCenterY1);
                p3subp3.add(tfCenterY1);
                p3subp4.add(lbRadius1);
                p3subp4.add(tfRadius1);
                    p3.setLayout(new GridLayout(4, 1));
                        p3.add(p3subp);
                        p3.add(p3subp2);
                        p3.add(p3subp3);
                        p3.add(p3subp4);

        p3.setPreferredSize(new Dimension(50, 110));                
        p3.setBorder(border);
        // p3.setLayout(null);
        // p3.setLocation(50, 100);
        add(p3, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}