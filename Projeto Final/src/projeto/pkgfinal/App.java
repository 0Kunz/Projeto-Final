package projeto.pkgfinal;

import javax.swing.JFrame;

public class App {

    public static void main(String[] args) {

        Token token = new Token();
        JFrame telaPrincipal = new JFrame("Pedidos - Área do Cliente");
        telaPrincipal.add(token);
        telaPrincipal.setSize(610, 510);
        telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TelaPedidos telaPedidos = new TelaPedidos();
        telaPedidos.setVisible(true);

        telaPrincipal.setLocation(100, 100);
        telaPedidos.setLocation(750, 100);

        telaPrincipal.setVisible(true);

        token.setTelaPedidos(telaPedidos);
    }
}