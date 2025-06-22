package projeto.pkgfinal;

import javax.swing.JFrame;

public class App {
    
    public static void main(String[] args) {
        Token token = new Token();
        JFrame tela = new JFrame();

        tela.add(token);
        tela.setSize(600, 500);
        tela.setVisible(true);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
