import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Мое первое окно");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        JButton button = new JButton("Нажми меня!");
        frame.add(button, BorderLayout.SOUTH);

        JLabel label = new JLabel("Привет, мир!");
        frame.add(label, BorderLayout.NORTH);
        frame.setVisible(true);
    }
}
