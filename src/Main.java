import Store.Produkt;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Produkt> list = new ArrayList<>();
        Produkt x = new Produkt(67,5);
        list.add(x);
        x = new Produkt(145,11);
        list.add(x);
        x = new Produkt(32,21);
        list.add(x);
        x = new Produkt(240,30);
        list.add(x);
        for(Produkt i:list)
            System.out.println(i.getBasisPreis());
        List<Produkt> a = Produkt.listnachR(list);
        for(Produkt i:a)
            System.out.println(i.getBasisPreis());
        List<Produkt> b = Produkt.Over100(list);
        List<Produkt> c = Produkt.Sortiert(list);
        Produkt d = Produkt.Teurste(list);
        Produkt e = Produkt.Gunstigste(list);

    }
}