package org.example;
import javax.swing.*;
import java.awt.*;

public class Vendas extends JFrame {
    private JPanel panel;
    private JTextField valor;
    private JTextField cupom;
    private JButton botao;
    private JTextArea valorFinal;
    private JTextArea valorOriginal;
    private JTextArea descontoAplicado;


    public Vendas() {
        setTitle("Black Friday");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton voltar = new JButton("Voltar");

        panel = new JPanel(new GridLayout(8,2));

        valor = new JTextField(10);
        cupom = new JTextField(10);
        botao = new JButton("Calcular");
        valorFinal = new JTextArea(2,10);
        valorOriginal = new JTextArea(2,10);
        descontoAplicado = new JTextArea(2,10);


        panel.add(new JLabel("Valor"));
        panel.add(valor);

        panel.add(new JLabel("Cupom"));
        panel.add(cupom);

        panel.add(botao);

        panel.add(new JLabel("Valor Original"));
        panel.add(valorOriginal);

        panel.add(new JLabel("Desconto Aplicado"));
        panel.add(descontoAplicado);

        panel.add(new JLabel("Valor Final"));
        panel.add(valorFinal);

        botao.addActionListener(e -> {
            double v = Double.parseDouble(valor.getText());
            String c = cupom.getText();

            double vf = desconto(v, c);
            valorFinal.setText("R$ " + vf);
            valorOriginal.setText("R$ " + v);
            descontoAplicado.setText("R$ " + (vf-v));
        });

        voltar.addActionListener(e -> {
            new EXR1();
            dispose();
        });

        add(panel, BorderLayout.CENTER);
        add(voltar, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public double desconto(double valor, String cupom) {
        double desconto = valor * 0.90;

        if (cupom.equalsIgnoreCase("AMIGAO10")) {
            desconto -= 10.00;
        }

        return desconto;
    }
}