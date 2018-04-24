import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class rebound extends JFrame {
// CONSTANTS
   private static final int CANVAS_WIDTH = 800;
   private static final int CANVAS_HEIGHT = 800;
   private static final int UPDATE_PERIOD = 25; // refresh by ms

   private DrawCanvas canvas;

// BALL ATTRIBUTES
   private int x = 100, y = 100;  // from top-left (x, y)
   private int size = 50;        // width and height
   private int xSpeed = 5, ySpeed = 10; // displacement per step in x, y

   public rebound() {
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
      if (x > CANVAS_WIDTH - size || x < 0) { // hits vert wall
         xSpeed = -xSpeed; // reverse
      }
      if (y > CANVAS_HEIGHT - size || y < 0) { // hits hori wall
         ySpeed = -ySpeed; // reverse
      }
      if (x > 275 && x < 475 && y > 275 && y < 475) { // intersects center
        xSpeed = -xSpeed - 2; // reverse, increase speed
        ySpeed = -ySpeed - 2;
      }
   }
// DESIGN
   private class DrawCanvas extends JPanel {
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         setBackground(Color.BLACK);
         //Color c = new Color((int)(Math.random() * 0xFFFFFF)); // randomize colors
         g.setColor(Color.WHITE); // STATIC COLOR
         //g.setColor(c); // RANDOM COLOR
         g.fillOval(x, y, size, size); // BALL SHAPE
         g.fillOval(300, 300, 200, 200); // CENTER SHAPE
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new rebound();
         }
      });
   }
}
