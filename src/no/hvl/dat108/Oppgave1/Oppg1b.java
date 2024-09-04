package no.hvl.dat108.Oppgave1;

public class Oppg1b {
    public static void main(String[] args) {
        Operasjon summerFunksjon = (a, b) -> a + b;
        Operasjon storsteFunksjon = (a, b) -> Math.max(a, b);
        Operasjon avstandFunksjon = (a, b) -> Math.abs(a - b);

        int sum = beregn(12, 13, summerFunksjon);
        int storste = beregn(-5, 3, storsteFunksjon);
        int avstand = beregn(54, 45, avstandFunksjon);

        System.out.println("1. Summen er: " + sum);
        System.out.println("2. Den største er: " + storste);
        System.out.println("3. Avstanden er: " + avstand);
    }

    public static int beregn(int a, int b, Operasjon func) {
        return func.kalkuler(a, b);
    }

    @FunctionalInterface
    interface Operasjon {
        int kalkuler(int a, int b);
    }
}
