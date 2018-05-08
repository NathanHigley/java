import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Rebound extends JFrame {
// CONSTANTS
   private static final int CANVAS_WIDTH = 800;
   private static final int CANVAS_HEIGHT = 800;
   private static final int UPDATE_PERIOD = 35; // refresh by ms

   private DrawCanvas canvas;
// BALL ATTRIBUTES
   private int x = 100, y = 100;  // from top-left (x, y)
   private int size = 50;        // width and height
   private int xSpeed = 12, ySpeed = 20; // displacement per step in x, y

   public Rebound() {
      canvas = new DrawCanvas();
      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
      this.setContentPane(canvas);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.pack();
      this.setTitle("Rebound");
      this.setVisible(true);

      ActionListener updateTask = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            update();
            repaint(); // refresh
         }
      };
      new Timer(UPDATE_PERIOD, updateTask).start();
   }
// CONDITIONS
   public void update() {
      x += xSpeed;
      y += ySpeed;
      if (x > CANVAS_WIDTH - size || x < 0) { // hits vertical wall
         xSpeed = -xSpeed; // reverse
      }
      if (y > CANVAS_HEIGHT - size || y < 0) { // hits horizontal wall
         ySpeed = -ySpeed; // reverse
      }
      //System.out.println(x+" "+y+" "+xSpeed+" "+ySpeed); // print ball coordinates
      if (x > 275 && x < 475 && y > 275 && y < 475 && xSpeed <= 50 && ySpeed <= 50) { // intersects center
        xSpeed = -xSpeed * 100 / 90; // reverse, increase speed by factor
        ySpeed = -ySpeed * 100 / 90;
      }
   }
// DESIGN
   private class DrawCanvas extends JPanel {
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         setBackground(Color.BLACK);
         //Color c = new Color((int)(Math.random() * 0xFFFFFF)); // randomize colors
         //g.setColor(c); // RANDOM COLOR
         g.setColor(Color.WHITE); // STATIC COLOR
         g.fillOval(x, y, size, size); // BALL SHAPE
         g.fillOval(300, 300, 200, 200); // CENTER SHAPE
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new Rebound();
         }
      });
   }
}
