/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.pkgfinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 *
 * @author GabrielSanini
 */

public class TelaPedidos extends JFrame {
    private ArrayList<Pedido> pedidosEmAguardo;
    private ArrayList<Pedido> pedidosEmPreparo;
    private ArrayList<Pedido> pedidosFinalizados;
    
    private JPanel panelAguardo;
    private JPanel panelPreparo;
    private JPanel panelFinalizados;
    
    public TelaPedidos() {
        pedidosEmAguardo = new ArrayList<>();
        pedidosEmPreparo = new ArrayList<>();
        pedidosFinalizados = new ArrayList<>();
        
        setTitle("Gerenciamento de Pedidos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(1, 3));
      
        panelAguardo = new JPanel();
        panelAguardo.setBorder(BorderFactory.createTitledBorder("EM AGUARDO"));
        panelAguardo.setLayout(new BoxLayout(panelAguardo, BoxLayout.Y_AXIS));
        
      
        panelPreparo = new JPanel();
        panelPreparo.setBorder(BorderFactory.createTitledBorder("EM PREPARO"));
        panelPreparo.setLayout(new BoxLayout(panelPreparo, BoxLayout.Y_AXIS));
        
    
        panelFinalizados = new JPanel();
        panelFinalizados.setBorder(BorderFactory.createTitledBorder("FINALIZADOS"));
        panelFinalizados.setLayout(new BoxLayout(panelFinalizados, BoxLayout.Y_AXIS));
        
        add(panelAguardo);
        add(panelPreparo);
        add(panelFinalizados);
    }
    
    public void adicionarPedido(Pedido pedido) {
        pedido.setStatus("EM AGUARDO");
        pedidosEmAguardo.add(pedido);
        atualizarTela();
    }
    
    private void atualizarTela() {
        panelAguardo.removeAll();
        panelPreparo.removeAll();
        panelFinalizados.removeAll();
        
        for (Pedido pedido : pedidosEmAguardo) {
            JPanel panelPedido = criarPanelPedido(pedido, "Iniciar Preparo");
            panelAguardo.add(panelPedido);
        }
        
        for (Pedido pedido : pedidosEmPreparo) {
            JPanel panelPedido = criarPanelPedido(pedido, "Finalizar Pedido");
            panelPreparo.add(panelPedido);
        }
        
        for (Pedido pedido : pedidosFinalizados) {
            JPanel panelPedido = criarPanelPedido(pedido, null);
            panelFinalizados.add(panelPedido);
        }
        
        panelAguardo.revalidate();
        panelAguardo.repaint();
        panelPreparo.revalidate();
        panelPreparo.repaint();
        panelFinalizados.revalidate();
        panelFinalizados.repaint();
    }
    
    private JPanel criarPanelPedido(Pedido pedido, String textoBotao) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEtchedBorder());
        

        StringBuilder texto = new StringBuilder();
        texto.append("Pedido #").append(pedido.getIdPedido()).append("\n");
        
        Item item = pedido.getCabeca();
        double total = 0.0;
        while (item != null) {
            texto.append("- ").append(item.getNome()).append(": R$ ").append(item.getPreco()).append("\n");
            total += item.getPreco();
            item = item.getProximo();
        }
        texto.append("Total: R$ ").append(total);
        
        JTextArea textArea = new JTextArea(texto.toString());
        textArea.setEditable(false);
        panel.add(textArea, BorderLayout.CENTER);
        
        if (textoBotao != null) {
            JButton botao = new JButton(textoBotao);
            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mudarStatusPedido(pedido);
                }
            });
            panel.add(botao, BorderLayout.SOUTH);
        }
        
        return panel;
    }
    
    private void mudarStatusPedido(Pedido pedido) {
        if (pedidosEmAguardo.contains(pedido)) {
            pedidosEmAguardo.remove(pedido);
            pedido.setStatus("EM PREPARO");
            pedidosEmPreparo.add(pedido);
        } else if (pedidosEmPreparo.contains(pedido)) {
            pedidosEmPreparo.remove(pedido);
            pedido.setStatus("FINALIZADO");
            pedidosFinalizados.add(pedido);
        }
        atualizarTela();
    }
}
