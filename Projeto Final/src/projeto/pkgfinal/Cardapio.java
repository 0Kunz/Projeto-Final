package projeto.pkgfinal;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Cardapio {
    File arq_cardapio;
    ArrayList<String> nomes = new ArrayList<String>();
    ArrayList<Integer> ids = new ArrayList<Integer>();
    ArrayList<Double> precos = new ArrayList<Double>();

    public Cardapio(String cardapio) {
        this.arq_cardapio = new File(cardapio);
        this.iniciar();
    }

    public void iniciar() {
        Boolean nome = true;
        try {
            Scanner leia = new Scanner(this.arq_cardapio);
            while (leia.hasNextLine()) {
                String data = leia.nextLine();
                String num = "";
                for (char c : data.toCharArray()) {
                    if (nome) {
                        if (c != ',') {
                            num += c;
                        } else {
                            this.nomes.add(num);
                            num = "";
                            nome = false;
                        }
                    } else {
                        if (c != '*') {
                            num += c;
                        } else {
                            this.precos.add(Double.parseDouble(num));
                            num = "";
                            nome = true;
                        }
                    }
                }
            }
            leia.close();
        } catch (Exception e) {
            System.out.println("Deu Erro!!!");
        }
    }

    public Item getItem(int id) {
        return new Item(id, this.nomes.get(id - 1), this.precos.get(id - 1));
    }
}
