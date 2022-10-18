package Store;

import java.security.PublicKey;
import java.util.*;
import java.lang.*;

class SortByPrice implements Comparator<Produkt> {


    @Override
    public int compare(Produkt o1, Produkt o2) {
        double v = o1.preisNachR() - o2.preisNachR();
        return (int) v;
    }
}

public class Produkt {

    private double BasisPreis;
    private int Tage;

    public Produkt(double BasisPreis, int Tage) {
        this.BasisPreis = BasisPreis;
        this.Tage = Tage;
    }

    public void setBasisPreis(double basisPreis) {
        BasisPreis = basisPreis;
    }

    public double getBasisPreis() {
        return BasisPreis;
    }

    public double preisNachR() {
        double x;
        if (this.Tage > 10 && this.Tage < 20)
             x= 10.0 / 100.0;
        else
            x = 20.0 / 100.0;
        x = x * this.BasisPreis;
        return Math.round(x * 20.0) / 20.0;
    }

    public static List<Produkt> listnachR(List<Produkt> list) {
        List<Produkt> a = new ArrayList<>();
        for (Produkt x : list) {
            x.setBasisPreis(x.preisNachR());
            a.add(x);
        }
        return a;
    }

    public static List<Produkt> Over100(List<Produkt> list) {
        List<Produkt> a = new ArrayList<Produkt>();
        for (Produkt x : list) {
            x.BasisPreis = x.preisNachR();
            if (x.BasisPreis > 100)
                a.add(x);
        }
        return a;
    }

    public static List<Produkt> Sortiert(List<Produkt> list) {
        list.sort(new SortByPrice());
        return list;
    }

    public static Produkt Teurste(List<Produkt> list) {
        Produkt x = new Produkt(0, 0);
        for (Produkt a : list) {
            if (a.preisNachR() > x.BasisPreis)
                x = a;
        }
        return x;
    }

    public static Produkt Gunstigste(List<Produkt> list) {
        Produkt x = new Produkt(0, 0);
        for (Produkt a : list) {
            if (a.preisNachR() < x.BasisPreis)
                x = a;
        }
        return x;
    }
}
