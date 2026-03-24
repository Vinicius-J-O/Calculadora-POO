import javax.swing.*;
import java.awt.*;

public class Calculadora {
    private JFrame janela;
    private JTextField visorAtual;
    private JTextField visorEquacao;

    private double resultado = 0;
    public Calculadora (){
        janela = new JFrame();
        
        janela.setSize(400, 500);
        janela.setTitle("Calculadora");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel painelVisores = new JPanel(new GridLayout(2, 1));
        visorEquacao = new JTextField("0");
        visorEquacao.setEditable(false);
        visorEquacao.setHorizontalAlignment(JTextField.RIGHT);
       

        visorAtual = new JTextField();
        visorAtual.setEditable(false);
        visorAtual.setHorizontalAlignment(JTextField.RIGHT);
        visorAtual.setFont(new Font("Arial", Font.BOLD, 28));
        visorAtual.setBackground(null);

        
        painelVisores.add(visorEquacao);
        painelVisores.add(visorAtual);

        JPanel painelBotoes = new JPanel(new GridLayout(6, 4));
        String[] textos = {
            "%", "CE", "C", "{}",
            "1/x", "x2", "2{x", "/",
            "7", "8", "9", "x",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "+/-", "0", ",", "=",
        };

        for (String texto : textos) {
            JButton btn = new JButton(texto);
            btn.addActionListener(e -> tratarClique(texto));
            painelBotoes.add(btn);
        }

        

        janela.add(painelBotoes);
        janela.add(painelVisores, BorderLayout.NORTH);
        janela.setVisible(true);
    }
    private void tratarClique(String comando){
        if ("123456789".contains(comando)) {
            visorAtual.setText(comando);
        }else if ("+-*/=".contains(comando)){

            if (comando.equals("=")) {
                
            }else{
                visorEquacao.setText(visorEquacao.getText()+visorAtual.getText()+" "+comando+" ");
            }
            
        }

    }

    private void calcular(double valor, String operador){
        if (operador.equals("+")){
            valor += resultado;
        }else if(operador.equals("-")){
            valor -= resultado;
        }else if(operador.equals("*")){
            valor *= resultado;
        }else if(operador.equals("/")){
            valor /= resultado;
        }
    }
}
