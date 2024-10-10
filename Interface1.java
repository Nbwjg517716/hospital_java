import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Mostrarcadastros;


public class Interface1 {

    public static void main(String[] args) {
        // Cria o primeiro JFrame (Interface 1)
        JFrame frame1 = new JFrame("Interface 1");
        frame1.setSize(300, 200);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null); // Centraliza a janela
        
        // Cria o botão que vai mudar para a Interface 2
        JButton button = new JButton("Ir para Interface 2");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Quando o botão for clicado, fecha a Interface 1 e abre a Interface 2
                frame1.dispose(); // Fecha a Interface 1
                new Interface2();  // Abre a Interface 2
            }
        });

        frame1.add(button);  // Adiciona o botão no JFrame
        frame1.setVisible(true);  // Torna o JFrame visível
    }
}

// Classe para a Interface 2
class Interface2 {

    Interface2() {
        // Cria o segundo JFrame (Interface 2)
        JFrame frame2 = new JFrame("Interface 2");
        frame2.setSize(300, 200);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLocationRelativeTo(null); // Centraliza a janela
        
        // Cria o botão para fechar a Interface 2
        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();  // Fecha a Interface 2
            }
        });

        frame2.add(closeButton);  // Adiciona o botão no JFrame
        frame2.setVisible(true);  // Torna o JFrame visível
    }
}
