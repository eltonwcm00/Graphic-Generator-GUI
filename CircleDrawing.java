import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CircleDrawing extends JFrame implements ActionListener{
    
    private JFrame frame;
    private JButton bt;
    private JPanel p1, p2, p3, p4, p5;
    private JPanel p3subp, p3subp2, p3subp3, p3subp4, p4subp1, p4subp2, p4subp3, p4subp4;
    private JLabel lbTitle, lbTitleP3, lbTitleP4, lbCenterX1, lbCenterY1, lbRadius1,
                   lbCenterX2, lbCenterY2, lbRadius2;
    private JTextField tfCenterX1, tfCenterY1, tfRadius1,tfCenterX2, tfCenterY2, tfRadius2;
    private double centerX1 = 0, centerY1 = 0, centerX2 = 0, centerY2 = 0, radius1 = 0, radius2 = 0; 

    public static void main(String[] args) {
        
        CircleDrawing cd = new CircleDrawing();
        cd.frame.setVisible(true);

    } 

    public CircleDrawing() {

        interfacePanel();
    }

    public void interfacePanel() {

        frame = new JFrame();
            frame.setBounds(100, 100, 500, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);

        Border border = LineBorder.createGrayLineBorder();
        
        // panel 1
        p1 = new JPanel();
        p1.setBounds(176, 10, 130, 100);
        lbTitle = new JLabel("Two circles intersect ?");
        p1.add(lbTitle);
        frame.getContentPane().add(p1);


        // panel 2 (circle)
        p2 = new JPanel();
        p2.setBounds(10, 33, 466, 169);
        frame.getContentPane().add(p2);

        // panel 3
        p3 = new JPanel();
        p3.setBounds(84, 212, 150, 100);
        p3subp = new JPanel();
        p3subp2 = new JPanel();
        p3subp3 = new JPanel();
        p3subp4 = new JPanel();
            lbTitleP3 = new JLabel("Enter circle 1 info : ");
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

        p3.setBorder(border);
        frame.getContentPane().add(p3);
  

        // panel 4
        p4 = new JPanel();
        p4.setBounds(251, 212, 150, 100);
        p4subp1 = new JPanel();
        p4subp2 = new JPanel();
        p4subp3 = new JPanel();
        p4subp4 = new JPanel();
            lbTitleP4 = new JLabel("Enter circle 2 info : ");
            lbCenterX2 = new JLabel("Center x :");
            lbCenterY2 = new JLabel("Center y :");
            lbRadius2 = new JLabel("Radius :  ");
            tfCenterX2 = new JTextField(5);
            tfCenterY2 = new JTextField(5);
            tfRadius2 = new JTextField(5);
                p4subp1.add(lbTitleP4);
                p4subp2.add(lbCenterX2);
                p4subp2.add(tfCenterX2);
                p4subp3.add(lbCenterY2);
                p4subp3.add(tfCenterY2);
                p4subp4.add(lbRadius2);
                p4subp4.add(tfRadius2);
                    p4.setLayout(new GridLayout(4, 1));
                        p4.add(p4subp1);
                        p4.add(p4subp2);
                        p4.add(p4subp3);
                        p4.add(p4subp4);

        p4.setBorder(border);
        frame.getContentPane().add(p4);


        // panel 5
        p5 = new JPanel();
            p5.setBounds(189, 322, 85, 35);
                frame.getContentPane().add(p5);
        bt = new JButton("Redraw circle");
            p5.add(bt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}