package Ex2;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    static List<Produs> citireProd(String fisier) throws IOException {

        List<Produs> produse = new ArrayList<>();
        Scanner sc = new Scanner(new File(fisier));
        while (sc.hasNextLine()){
            String linie = sc.nextLine().trim();
            if(!linie.isEmpty()){
                String[] t = linie.split(",");
                produse.add(new Produs(t[0].trim(),
                        Double.parseDouble(t[1].trim()),
                        Integer.parseInt(t[2].trim()),
                        LocalDate.parse(t[3].trim())));
            }
        }
        sc.close();
    return produse;
    }

    static void afisareProd(List<Produs> prd){
        for(Produs p : prd){
            System.out.println(p.toString());
        }
    }

    static void afisareProdExp(List<Produs> prd){
        for(Produs p : prd){
            if(p.esteExp())
                System.out.println(p.toString());
        }
    }

    static void vanzareProdus(List<Produs> produse, Scanner sc){
        System.out.println("Denumire produs: ");
        String nume = sc.nextLine().trim();
        System.out.println("Cantitate : ");
        int cant = Integer.parseInt(sc.nextLine().trim());

        for(int i = 0; i < produse.size(); i++){
            Produs p = produse.get(i);
            if(p.getNume().equalsIgnoreCase(nume)){
                if(p.vinde(cant)){
                    System.out.println("Vanzare efectuata.");
                    if(p.getCantitate() == 0){
                        produse.remove(i);
                    }
                }
                else{
                    System.out.println("Stoc insuficient");
                }
                System.out.println("Incasari toatale : " + Produs.getIncasari());
                return;
            }
        }
        System.out.println("Produsul nu exista");
    }

    static void afiseazaPretMinim(List<Produs> produse){
        if (produse.isEmpty()) {
            System.out.println("Lista este goala.");
            return;
        }
        double min = produse.get(0).getPret();
        for (Produs p : produse) min = Math.min(min, p.getPret());
        for (Produs p : produse) {
            if (p.getPret() == min) System.out.println(p);
        }
    }


    static void salveaza(List<Produs> produse, Scanner sc) throws IOException {
        System.out.print("Cantitate maxima: ");
        int prag = Integer.parseInt(sc.nextLine().trim());
        List<String> linii = new ArrayList<>();
        for (Produs p : produse) {
            if (p.getCantitate() < prag) linii.add(p.toCsv());
        }
        Files.write(Path.of("src/Ex2/iesire.csv"), linii);
        System.out.println("Produsele au fost salvate in iesire.csv");
    }

    public static void main(String[] args) throws IOException {
        List<Produs> produse = citireProd("src/Ex2/produse.csv");
        Scanner sc = new Scanner(System.in);
        int opt;
        do {
            System.out.println("\n--- MENIU ---");
            System.out.println("1. Afisare toate produsele");
            System.out.println("2. Afisare produse expirate");
            System.out.println("3. Vanzare produs");
            System.out.println("4. Afisare produse cu pretul minim");
            System.out.println("5. Salvare produse cu cantitate mai mica decat o valoare");
            System.out.println("0. Iesire");
            System.out.print("Optiune: ");
            opt = Integer.parseInt(sc.nextLine().trim());
            switch (opt) {
                case 1 -> afisareProd(produse);
                case 2 -> afisareProdExp(produse);
                case 3 -> vanzareProdus(produse, sc);
                case 4 -> afiseazaPretMinim(produse);
                case 5 -> salveaza(produse, sc);
                case 0 -> System.out.println("La revedere!");
                default -> System.out.println("Optiune invalida.");
            }
        } while (opt != 0);
        sc.close();
    }
}
