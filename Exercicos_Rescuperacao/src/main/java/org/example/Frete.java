package org.example;
import javax.swing.*;
import java.awt.*;

public class Frete extends JFrame {
    private JPanel panel;
    private JTextField distancia;
    private JTextField peso;
    private JButton normal;
    private JButton expresso;
    private JTextArea resultado;

    public Frete() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(5,2));

        distancia = new JTextField(10);
        peso = new JTextField(10);
        normal = new JButton("Normal");
        expresso = new JButton("Expresso");
        resultado = new JTextArea(3,20);

        resultado.setSize(100,10);

        setTitle("Logística Express");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton voltar = new JButton("Voltar");

        panel.add(new JLabel("Distância:"));
        panel.add(distancia);

        panel.add(new JLabel("Peso:"));
        panel.add(peso);

        panel.add(normal);

        panel.add(expresso);

        panel.add(new JLabel("Resultado:"));
        panel.add(resultado);

        normal.addActionListener(e -> {
            double d = Double.parseDouble(distancia.getText());
            double p = Double.parseDouble(peso.getText());
            double r = Normal(d, p);
            resultado.setText("R$ " + r);
            add(resultado, BorderLayout.CENTER, EXIT_ON_CLOSE);


        });
        expresso.addActionListener(e -> {
            double d = Double.parseDouble(distancia.getText());
            double p = Double.parseDouble(peso.getText());
            double r = Expresso(d, p);
            resultado.setText("R$ " + r);
            add(resultado);
        });

        add(voltar,  BorderLayout.PAGE_END);

        voltar.addActionListener(e -> {
            new EXR1();
            dispose();
        });

        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public double Normal(double distancia, double peso) {

    double resultado = distancia * 0.50;
    if (peso > 20) {
      resultado += 30;
    }
    return resultado;
    }
    public double Expresso(double distancia, double peso) {

        double resultado = distancia * 0.50;
        if (peso > 20) {
            resultado += 30;
        }
        resultado *= 1.20;
        return resultado;
}
}