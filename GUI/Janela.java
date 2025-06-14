package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

public class Janela extends JFrame{

    public Janela(){
        this.setSize(1600,900); //define o tamanho da janela
        this.setTitle("A3 Pseudo-Tabuleiro"); //define o título da janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //faz com que o programa pare quando a janela é fechada (EXIT termina todas as janelas, DISPOSE termina só a que foi fechada)
        this.setResizable(false); //proíbe o usuário de redimensionar a janela
        this.getContentPane().setBackground(Color.lightGray);
        this.setLayout(null);

        preparaPainelPrincipal();


        this.setVisible(true);
    }

    public void preparaPainelPrincipal(){
        //JPanel: componente que funciona como container, possuindo outros componentes
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setBounds(0, 0, 1600, 400);
    }
}
