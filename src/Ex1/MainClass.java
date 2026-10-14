package Ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws FileNotFoundException {
        List<Parabola> parabole = new ArrayList<>();

        Scanner sc = new Scanner(new File("src/Ex1/in.txt"));
        while(sc.hasNextLine()){
            String linie = sc.nextLine().trim();
            if(!linie.isEmpty()){
                String[] t = linie.split(" ");
                int a = Integer.parseInt(t[0]);
                int b = Integer.parseInt(t[1]);
                int c = Integer.parseInt(t[2]);
                parabole.add(new Parabola(a,b,c));
            }
        }
        sc.close();

        for(Parabola p : parabole){
            double[] varf = p.VarfParabola();
            System.out.println("Functie : " + p.toString() + " Varful : " + varf[0] + "," + varf[1]);
        }

        double[] mijloc = Parabola.MijlocParabolaStatic(parabole.get(0),parabole.get(1));
        System.out.println("Mijlocul : " + mijloc[0] + ", " + mijloc[1]);
        System.out.println("Lungimea Segmentului : " + Parabola.LungimeaSegmentuluiStatica(parabole.get(0),parabole.get(1)));

    }
}
