package no.hvl.dat108.Oppgave2;

import java.util.Arrays;
import java.util.List;

public class Oppg2 {
    public static void main(String[] args) {

        Oppgjor kronetillegg = ansatt -> ansatt.setAarslonn(ansatt.getAarslonn() + 2_000);
        Oppgjor prosenttillegg = ansatt -> ansatt.setAarslonn((int) Math.round(ansatt.getAarslonn() * 1.1));
        Oppgjor kronetilleggLav = ansatt -> {
            if (ansatt.getAarslonn() < 350_000) {
                ansatt.setAarslonn(ansatt.getAarslonn() + 2_000);
            }
        };
        Oppgjor prosenttilleggLav = ansatt -> {
            if (ansatt.getAarslonn() < 350_000) {
                ansatt.setAarslonn((int) Math.round(ansatt.getAarslonn() * 1.1));
            };
        };

        List<Ansatt> ansatte = Arrays.asList(
            new Ansatt("Ola", "Nordmann", Kjonn.MANN, "ansatt", 300_000),
            new Ansatt("Kari", "Nordmann", Kjonn.KVINNE, "ansatt", 280_000),
            new Ansatt("Per", "Spelmann", Kjonn.MANN, "sjef", 500_000),
            new Ansatt("Donald", "Duck", Kjonn.MANN, "mellomleder", 380_000),
            new Ansatt("Minni", "Mus", Kjonn.KVINNE, "hr", 350_000)
        );

        skrivUtAlle(ansatte);
        lonnsoppgjor(ansatte, kronetillegg);
        skrivUtAlle(ansatte);
        lonnsoppgjor(ansatte, prosenttillegg);
        skrivUtAlle(ansatte);
        lonnsoppgjor(ansatte, kronetilleggLav);
        skrivUtAlle(ansatte);
        lonnsoppgjor(ansatte, prosenttilleggLav);
        skrivUtAlle(ansatte);
    }

    private static void lonnsoppgjor(List<Ansatt> ansatte, Oppgjor metode) {
        ansatte.forEach(metode::beregn);
    }

    private static void skrivUtAlle(List<Ansatt> ansatte) {
        System.out.println("####################");
        ansatte.forEach(p -> System.out.println(p.toString()));
        System.out.println("####################");
    }

    @FunctionalInterface
    interface Oppgjor {
        void beregn(Ansatt ansatt);
    }
}
