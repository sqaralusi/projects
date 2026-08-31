import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel {
    private Random random = new Random();
    private List<SnowflakeInfo> backgroundSnowflakes = new ArrayList<>();

    public SnowFlakePanel() {
        super.setPreferredSize(new Dimension(400, 400));
        super.setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        super.paintComponent(g);

        /*
         * DRAWING CODE BELOW
         */
        drawBackgroundSnowflakes(g, width, height, 100); // Draw 100 background snowflakes

        // Call the drawSnowFlake method to draw a smaller snowflake
        int centerX = width / 2;
        int centerY = height / 2;
        int size = Math.min(width, height) / 4; // Smaller initial size of the snowflake
        int depth = 10; // Depth of recursion, you can adjust this value

        Color snowflakeColor = getRandomColor();
        drawSnowFlake(g, centerX, centerY, size, depth, snowflakeColor);
    }

    private void drawBackgroundSnowflakes(Graphics g, int width, int height, int numSnowflakes) {
        for (int i = 0; i < numSnowflakes; i++) {
            int size = random.nextInt(20) + 5; // Random size between 5 and 25
            int depth = random.nextInt(3) + 1; // Random depth between 1 and 3

            Color snowflakeColor = getRandomColor();

            // Generate non-overlapping positions for background snowflakes
            Point position = generateNonOverlappingPosition(width, height, size);
            backgroundSnowflakes.add(new SnowflakeInfo(position, size, depth, snowflakeColor));

            // Draw the background snowflake
            drawSnowFlake(g, position.x, position.y, size, depth, snowflakeColor);
        }
    }

    private Point generateNonOverlappingPosition(int width, int height, int size) {
        int x, y;
        do {
            x = random.nextInt(width);
            y = random.nextInt(height);
        } while (isOverlapping(x, y, size));

        return new Point(x, y);
    }

    private boolean isOverlapping(int x, int y, int size) {
        for (SnowflakeInfo snowflake : backgroundSnowflakes) {
            int distance = (int) Math.hypot(x - snowflake.getPosition().x, y - snowflake.getPosition().y);
            if (distance < size + snowflake.getSize()) {
                return true; // Overlapping
            }
        }
        return false; // Not overlapping
    }

    private void drawSnowFlake(Graphics g, int x, int y, int size, int depth, Color color) {
        // Draw the main star with a specified color
        drawStar(g, x, y, size, color);

        // Recursion base case: stop when depth is 0 or size is small enough
        if (depth == 0 || size < 5) {
            return;
        }

        // Calculate the coordinates for the points of the main star
        double[] angles = { 0, 1 * (2 * Math.PI) / 6, 2 * (2 * Math.PI) / 6, 3 * (2 * Math.PI) / 6, 4 * (2 * Math.PI) / 6,
                5 * (2 * Math.PI) / 6 };

        // Draw smaller stars at the ends of the main star's lines with the specified color
        for (int i = 0; i < 6; i++) {
            int endX = (int) (x + size * Math.cos(angles[i]));
            int endY = (int) (y - size * Math.sin(angles[i]));
            drawSnowFlake(g, endX, endY, size / 3, depth - 1, color);
        }
    }

    private void drawStar(Graphics g, int x, int y, int size, Color color) {
        // Define the angles for the six points of the star
        double[] angles = { 0, 1 * (2 * Math.PI) / 6, 2 * (2 * Math.PI) / 6, 3 * (2 * Math.PI) / 6, 4 * (2 * Math.PI) / 6,
                5 * (2 * Math.PI) / 6 };

        // Calculate the coordinates for the points of the star
        Point[] starPoints = new Point[6];
        for (int i = 0; i < 6; i++) {
            int endX = (int) (x + size * Math.cos(angles[i]));
            int endY = (int) (y - size * Math.sin(angles[i]));
            starPoints[i] = new Point(endX, endY);
        }

        // Draw the lines connecting the points to form the star with the specified color
        g.setColor(color);
        for (int i = 0; i < 6; i++) {
            g.drawLine(x, y, starPoints[i].x, starPoints[i].y);
        }
    }

    private Color getRandomColor() {
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }
}

class SnowflakeInfo {
    private Point position;
    private int size;
    private int depth;
    private Color color;

    public SnowflakeInfo(Point position, int size, int depth, Color color) {
        this.position = position;
        this.size = size;
        this.depth = depth;
        this.color = color;
    }

    public Point getPosition() {
        return position;
    }

    public int getSize() {
        return size;
    }

    public int getDepth() {
        return depth;
    }

    public Color getColor() {
        return color;
    }
}

public class Snowflake {
    public static void main(String[] args) {
        /*
         * A frame is a container for a panel
         * The panel is where the drawing will take place
         */
        JFrame frame = new JFrame("Snowflake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SnowFlakePanel());
        frame.pack();
        frame.setVisible(true);
    }
}