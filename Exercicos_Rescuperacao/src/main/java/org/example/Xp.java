package org.example;

import javax.swing.*;
import java.awt.*;

public class Xp extends JFrame {
    private JPanel panel1;
    private JPanel panel2;
    private JTextField nivelAtual;
    private JTextField xpAcumulado;
    private JButton facil;
    private JButton medio;
    private JButton dificil;

    public Xp() {
        setTitle("Calculadora de XP ");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panel1 = new JPanel(new GridLayout(4,1));
        panel2 = new JPanel(new GridLayout(6,1));

        nivelAtual = new JTextField(10);
        xpAcumulado = new JTextField(10);
        facil = new JButton("Facil");
        medio = new JButton("Medio");
        dificil = new JButton("Dificil");

        panel1.add(new JLabel("Nivel Atual:"));
        panel1.add(nivelAtual);
        panel1.add(new JLabel("XP Acumulado:"));
        panel1.add(xpAcumulado);

        panel2.add(new JLabel("Fácil:"));
        panel2.add(facil);
        panel2.add(new JLabel("Medio:"));
        panel2.add(medio);
        panel2.add(new JLabel("Dificil:"));
        panel2.add(dificil);

        facil.addActionListener(e -> {
            double x = Double.parseDouble(xpAcumulado.getText());
            x += 100;

            int y = Integer.parseInt(nivelAtual.getText());
            y = (int) subirNivel(y, x);

            xpAcumulado.setText(String.valueOf(x));
            nivelAtual.setText(String.valueOf(y));
        });

        medio.addActionListener(e -> {
            double x = Double.parseDouble(xpAcumulado.getText());
            x += 100;
            x *= 1.5;

            int y = Integer.parseInt(nivelAtual.getText());
            y = (int) subirNivel(y, x);

            xpAcumulado.setText(String.valueOf(x));
            nivelAtual.setText(String.valueOf(y));
        });

        dificil.addActionListener(e -> {
            double x = Double.parseDouble(xpAcumulado.getText());
            x += 100;
            x *= 2;

            int y = Integer.parseInt(nivelAtual.getText());
            y = (int) subirNivel(y, x);

            xpAcumulado.setText(String.valueOf(x));
            nivelAtual.setText(String.valueOf(y));
        });

        JButton voltar = new JButton("Voltar");

        voltar.addActionListener(e -> {
            new EXR1();
            dispose();
        });

        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(voltar, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public double subirNivel(double nivelAtual, double xpAcumulado) {
        if (xpAcumulado >= 1000) {
            nivelAtual++;
        }
        return nivelAtual;
    }
}