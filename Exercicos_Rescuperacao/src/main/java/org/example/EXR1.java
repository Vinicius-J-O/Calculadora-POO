package org.example;
import javax.swing.*;
import java.awt.*;

public class EXR1 extends JFrame {
    JPanel panel;
    public EXR1() {
        setTitle("Tela Principal");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridLayout(2, 2));

        JButton btn1 = new JButton("Logísticas Express");
        JButton btn2 = new JButton("Black Friday");
        JButton btn3 = new JButton("Calculador de xp");
        JButton btn4 = new JButton("Filtro de Streamer");
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        btn1.addActionListener(e -> {
            new Frete();
            dispose();
        });
        btn2.addActionListener(e -> {
            new Vendas();
            dispose();
        });
        btn3.addActionListener(e -> {
            new Xp();
            dispose();
        });
        btn4.addActionListener(e -> {
            new Streamer();
            dispose();
        });
        setLocationRelativeTo(null);
        setVisible(true);
        add(panel);
    }
}