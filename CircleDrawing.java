import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


@SuppressWarnings("serial")
public class CircleDrawing extends JFrame implements ActionListener {

    private JButton bt;
    private JPanel p1, p3, p4, p5, flowLayoutPanel;
    private JPanel p3subp, p3subp2, p3subp3, p3subp4, p4subp1, p4subp2, p4subp3, p4subp4;
    private JLabel lbTitle, lbTitleP3, lbTitleP4, lbCenterX1, lbCenterY1, lbRadius1, lbCenterX2, lbCenterY2, lbRadius2;
    private JTextField tfCenterX1, tfCenterY1, tfRadius1, tfCenterX2, tfCenterY2, tfRadius2;
    
    public int centerX1, centerY1, centerX2, centerY2;
    public int radius1, radius2;
    
    private int dx, dy;
    private int intersect;

    private CircleMoving cm;
    private int x1, y1, x2, y2;
    boolean isCircle1Clicked = false, isCircle2Clicked = false;

    public static void main(String[] args) {

        CircleDrawing cd = new CircleDrawing();
        cd.getContentPane();
        cd.setSize(400, 360);
        cd.setVisible(true);
        cd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cd.setTitle("Circle Drawing");
        // cd.pack();
    }

    public CircleDrawing() {

        // Call the class that extends MouseAdapter
        cm = new CircleMoving();
        addMouseListener(cm);
        addMouseMotionListener(cm);

        // Create and setup the border for panel 3 and panel 4
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border borderTitle1 = BorderFactory.createTitledBorder(blackline, " - - - - - - - - - - - - - - - - ");
        Border borderTitle2 = BorderFactory.createTitledBorder(blackline," - - - - - - - - - - - - - - - - ");
       
        // Panel 1
        p1 = new JPanel();
        lbTitle = new JLabel("Two circles intersect ?");
        p1.add(lbTitle);

        // Panel 3
        p3 = new JPanel();
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
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
        ((TitledBorder) borderTitle1).setTitleJustification(TitledBorder.LEADING);
        p3.setBorder(borderTitle1);
            p3.add(p3subp);
            p3.add(p3subp2);
            p3.add(p3subp3);
            p3.add(p3subp4);

        // Panel 4
        p4 = new JPanel();
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
            bt = new JButton("Redraw Circle");
            p4subp1.add(lbTitleP4);
            p4subp2.add(lbCenterX2);
            p4subp2.add(tfCenterX2);
            p4subp3.add(lbCenterY2);
            p4subp3.add(tfCenterY2);
            p4subp4.add(lbRadius2);
            p4subp4.add(tfRadius2);
        p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
        ((TitledBorder) borderTitle2).setTitleJustification(TitledBorder.TRAILING);
        p4.setBorder(borderTitle2);
            p4.add(p4subp1);
            p4.add(p4subp2);
            p4.add(p4subp3);
            p4.add(p4subp4);

        // Flowlayout to wrap the panel 3 and panel 4
        FlowLayout fLayout = new FlowLayout();
            flowLayoutPanel = new JPanel();
                flowLayoutPanel.setLayout(fLayout);
                flowLayoutPanel.add(p3);
                flowLayoutPanel.add(p4);

        // Panel 5
        p5 = new JPanel();
            bt = new JButton("Redraw Circle");
            JPanel buttonPane = new JPanel();
                buttonPane.add(bt);
            p5.setLayout(new BorderLayout());
                p5.add(flowLayoutPanel, BorderLayout.CENTER);
                p5.add(buttonPane, BorderLayout.SOUTH);

        // Frame default panel
        setLayout(new BorderLayout());
            add(p1, BorderLayout.NORTH);
            add(p5, BorderLayout.SOUTH);

        // actionListerner
        bt.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bt) {

            // Get the value from the JTextField
            centerX1 = Integer.parseInt(tfCenterX1.getText());
            centerY1 = Integer.parseInt(tfCenterY1.getText());
            radius1 = Integer.parseInt(tfRadius1.getText());

            centerX2 = Integer.parseInt(tfCenterX2.getText());
            centerY2 = Integer.parseInt(tfCenterY2.getText());
            radius2 = Integer.parseInt(tfRadius2.getText());

            // Call the circleIntersection() that return back the intersection points of the circles
            intersect = circleIntersection(centerX1, centerY1, centerX2, centerY2, radius1, radius2);

            String interLabel;

            // If the circles are either contained inside one another or do not intersect, set the label title based on the condition
            if (intersect == 1 || intersect == 2) {
                interLabel = "No";

            } else {
                interLabel = "Yes";
            }

            lbTitle.setText("Two circles intersect ? " + interLabel);

            repaint();

        }
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        int diameterCircle1 = radius1 * 2;
        int diameterCircle2 = radius2 * 2;

        // Draw circle 1 and circle 2
        g.drawOval(centerX1, centerY1, diameterCircle1, diameterCircle1);
        g.drawOval(centerX2, centerY2, diameterCircle2, diameterCircle2);

    }

    public int circleIntersection(int x1, int y1, int x2, int y2, int r1, int r2) {

        int intersect;

        // dx and dy are the vertical and horizontal distances
        dx = x2 - x1;
        dy = y2 - y1;

        // Determine the straight-line distance between centers.
        double d = Math.sqrt((dy * dy) + (dx * dx));

        // Circles do not intersect
        if (d > (r1 + r2)) {
            intersect = 1;

        // One circle is contained inside one another
        } else if (d < Math.abs(r1 - r2)) {
            intersect = 2;

        // Circles do intersect each other
        } else {
            intersect = 3;
        }

        return intersect;
    }

    private class CircleMoving extends MouseAdapter {
        
        public void mousePressed(MouseEvent cm) {
             
            // Check if the circle1 is being clicked
            isCircle1Clicked = (centerX1 - cm.getX()) * (centerX1 - cm.getX()) + (centerY1 - cm.getY()) * 
                               (centerY1 - cm.getY()) < radius1 * radius1;

            // Check if the circle2 is being clicked
            isCircle2Clicked = (centerX2 - cm.getX()) * (centerX2 - cm.getX()) + (centerY2 - cm.getY()) * 
                               (centerY2 - cm.getY()) < radius2 * radius2;
        }

        public void mouseDragged(MouseEvent cm) {
            
            if (isCircle1Clicked) {

                // Get the x-y coordinate of the circle1 minus by the circle distance
                x1 = cm.getX() - dx;
                y1 = cm.getY() - dy;

                // New coordinate of the circle1
                centerX1 = x1 + radius1;
                centerY1 = y1 + radius1;

                System.out.println("Circle 1 coordinate : " + centerX1 + " , " + centerY1);
                
                // Set the latest value of coordinate x-y circle 1
                tfCenterX1.setText(String.valueOf(centerX1));
                tfCenterY1.setText(String.valueOf(centerY1));

                repaint();
            }

            if (isCircle2Clicked) {

                // Get the x-y coordinate of the circle1 minus by the circle distance
                x2 = cm.getX() - dx;
                y2 = cm.getY() - dy;

                // New coordinate of the circle2
                centerX2 = x2 + radius2;
                centerY2 = y2 + radius2;

                System.out.println("Circle 2 coordinate : " + centerX2 + " , " + centerY2);

                // Set the latest value of coordinate x-y circle 2
                tfCenterX2.setText(String.valueOf(centerX2));
                tfCenterY2.setText(String.valueOf(centerY2));

                repaint();
            }
        }

        public void mouseReleased(MouseEvent e) {
            
            isCircle1Clicked = false;
            isCircle2Clicked = false;
        }
    }
}
