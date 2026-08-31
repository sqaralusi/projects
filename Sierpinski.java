import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sierpinski extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski Triangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Sierpinski());
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int canvasSize = 400;
        int triangleSize = 200;
        int initialX = (canvasSize - triangleSize) / 2;
        int initialY = (canvasSize + (int) (triangleSize * Math.sqrt(3) / 2)) / 2;

        drawSierpinski(g, 5, initialX, initialY, triangleSize);
    }

    private void drawSierpinski(Graphics g, int depth, int x, int y, int size) {
        if (depth == 0) {
            drawTriangle(g, x, y, size);
        } else {
            int halfSize = size / 2;

            drawSierpinski(g, depth - 1, x, y, halfSize);
            drawSierpinski(g, depth - 1, x + halfSize, y, halfSize);
            drawSierpinski(g, depth - 1, x + halfSize / 2, y - (int) (halfSize * Math.sqrt(3) / 2), halfSize);
        }
    }

    private void drawTriangle(Graphics g, int lowerLeftX, int lowerLeftY, int side) {
        int lowerRightX = lowerLeftX + side;
        int lowerRightY = lowerLeftY;
        int topX = lowerLeftX + side / 2;
        int topY = lowerLeftY - (int) (side * Math.sqrt(3) / 2);

        g.setColor(Color.WHITE);
        int[] xPoints = { lowerLeftX, lowerRightX, topX };
        int[] yPoints = { lowerLeftY, lowerRightY, topY };
        g.fillPolygon(xPoints, yPoints, 3);

        g.setColor(Color.BLUE);
        g.drawLine(lowerLeftX, lowerLeftY, lowerRightX, lowerRightY);
        g.drawLine(lowerRightX, lowerRightY, topX, topY);
        g.drawLine(topX, topY, lowerLeftX, lowerLeftY);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }
}