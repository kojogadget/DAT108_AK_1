package no.hvl.dat108.Oppgave3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import no.hvl.dat108.Oppgave2.Ansatt;
import no.hvl.dat108.Oppgave2.Kjonn;

public class Oppg3 {
    public static void main(String[] args) {
        List<Ansatt> ansatte = Arrays.asList(
            new Ansatt("Ola", "Nordmann", Kjonn.MANN, "ansatt", 300_000),
            new Ansatt("Kari", "Nordmann", Kjonn.KVINNE, "ansatt", 280_000),
            new Ansatt("Per", "Spelmann", Kjonn.MANN, "sjef", 500_000),
            new Ansatt("Donald", "Duck", Kjonn.MANN, "mellomleder", 380_000),
            new Ansatt("Minni", "Mus", Kjonn.KVINNE, "hr", 350_000)
        );

        List<String> svarA = ansatte.stream().map(ansatt -> ansatt.getEtternavn()).toList();
        System.out.println("Svar a) " + svarA);

        System.out.println("####################");

        long svarB = ansatte.stream()
                .filter(ansatt -> ansatt.getKjonn() == Kjonn.KVINNE)
                .count();
        System.out.println("Svar b) " + svarB);

        System.out.println("####################");

        OptionalDouble svarC = ansatte.stream()
                .filter(ansatt -> ansatt.getKjonn() == Kjonn.KVINNE)
                .mapToInt(ansatt -> ansatt.getAarslonn())
                .average();
        System.out.println("Svar c) " + (int) svarC.getAsDouble());

        System.out.println("####################");

        System.out.println("Svar d)");
        ansatte.stream()
                .map(ansatt -> {
                    if (ansatt.getStilling().toLowerCase().contains("sjef")) {
                        ansatt.setAarslonn((int) (ansatt.getAarslonn() * 1.07));
                        return ansatt;
                    } else {
                        return ansatt;
                    }})
                .forEach(System.out::println);

        System.out.println("####################");

        boolean svarE = ansatte.stream()
                .anyMatch(ansatt -> ansatt.getAarslonn() > 800_000);
        System.out.println("Svar e) " + svarE);

        System.out.println("####################");

        System.out.println("Svar f)");
        ansatte.forEach(System.out::println);

        System.out.println("####################");

        Optional<Ansatt> svarG = ansatte.stream()
                .min(Comparator.comparingInt(Ansatt::getAarslonn));
        System.out.println("Svar g) " + svarG);

        System.out.println("####################");

        OptionalInt svarH = IntStream.range(1, 1000)
                .filter(i -> i % 3 == 0 || i % 5 == 0)
                .reduce(Integer::sum);
        System.out.println("Svar h) " + svarH.getAsInt());
    }
}
