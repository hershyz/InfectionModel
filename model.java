import java.util.Random;

public class Main {

    //Args:
    static double minSpreadRate;
    static double maxSpreadRate;
    static double minRecoveryRate;
    static double maxRecoveryRate;
    static double populationInfected;
    static int repeatTimes;

    static String helpMessage = "USAGE: java -jar InfectionModel.jar <minSpreadRate>, <maxSpreadRate>, <minRecoveryRate>, <maxRecoveryRate>, <initial infected>, <repeat times>";

    static Random r = new Random();

    public static void main(String[] args) {

        try {

            minSpreadRate = Double.valueOf(args[0]);
            maxSpreadRate = Double.valueOf(args[1]);
            minRecoveryRate = Double.valueOf(args[2]);
            maxRecoveryRate = Double.valueOf(args[3]);
            populationInfected = Double.valueOf(args[4]);
            repeatTimes = Integer.parseInt(args[5]);

            run();
        }
        catch (Exception e) {
            System.out.println("");
            System.out.println(helpMessage);
            System.out.println("");
            e.printStackTrace();
        }
    }

    public static void run() {

        System.out.println("");
        System.out.println("Minimum spread rate: " + minSpreadRate);
        System.out.println("Maximum spread rate: " + maxSpreadRate);
        System.out.println("Minimum recovery rate: " + minRecoveryRate);
        System.out.println("Maximum recovery rate: " + maxRecoveryRate);
        System.out.println("Initial infected: " + populationInfected);
        System.out.println("Times to repeat spread: " + repeatTimes);
        System.out.println("");

        int i;
        for (i = 1; i <= repeatTimes; i++) {

            System.out.println("Trial - " + i);
            double currentSpreadRate = minSpreadRate + (maxSpreadRate - minSpreadRate) * r.nextDouble();
            double currentRecoveryRate = minRecoveryRate + (maxRecoveryRate - minRecoveryRate) * r.nextDouble();
            populationInfected = populationInfected * currentSpreadRate;
            populationInfected = populationInfected * currentRecoveryRate;

            System.out.println("Current spread rate: " + currentSpreadRate);
            System.out.println("Current recovery rate: " + currentRecoveryRate);
            System.out.println("Current infected population: " + (int)populationInfected);
            System.out.println("Recovered in trial: " + (int)(populationInfected * currentRecoveryRate));
            System.out.println("");
        }
    }
}
