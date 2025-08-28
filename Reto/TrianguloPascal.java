import javax.swing.*;
import java.awt.*;

public class TrianguloPascal extends JPanel {
    private int filas;

    public TrianguloPascal(int filas) {
        this.filas = filas;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[][] pascal = new int[filas][filas];

        for (int i = 0; i < filas; i++) {
            pascal[i][0] = 1;
            pascal[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
            }
        }

        int startX = getWidth() / 2;  
        int startY = 50;              
        int stepX = 40;               
        int stepY = 40;               

        for (int i = 0; i < filas; i++) {
            int x = startX - (i * stepX / 2);
            int y = startY + i * stepY;

            for (int j = 0; j <= i; j++) {
                g.drawString(String.valueOf(pascal[i][j]), x + j * stepX, y);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Triángulo de Pascal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new TrianguloPascal(10)); // Cambia 10 por el número de filas
        frame.setVisible(true);
    }
}
