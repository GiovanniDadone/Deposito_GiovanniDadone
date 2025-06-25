public class EsercizioMathExtra {
    public static void main(String[] args) {
        // extra: generazione randomica valori


        //check #1: età
        int età = (int) (Math.random() * 101);
        System.out.println("Età: " + età);

        if (età >= 18 && età <= 40) {
            System.out.println("Età verificata e valida");
        } else {
            System.out.println("Età non valida");
            System.out.println("Non ammesso alla gara");
            return;
        }


        //check #2: tempo 100 metri
        int tempo100Metri = (int) (10 + Math.random() * 10);  //generazione del tempo realistica
        System.out.println("Tempo 100 metri: " + tempo100Metri);

        if (tempo100Metri < 12) {
            System.out.println("Tempo 100 metri valido");
        } else {
            System.out.println("Tempo 100 metri non valido");
            System.out.println("Non ammesso alla gara");
            return;
        }

        
        //check #3: parametri fisici
        System.out.println("Qual è la tua altezza (in metri)?");
        int altezza = (int) (1 + Math.random());  //random con una generazione d'altezza realistica
        System.out.println("Altezza: " + altezza);

        System.out.println("Qual è il tuo peso (in Kg)?");
        int peso = (int) (Math.random() * 101);  //random con generazione del peso realistica
        System.out.println("Peso: " + peso);

        double bmi = peso / Math.pow(altezza, 2);
        System.out.println("BMI: " + bmi);
        if (bmi < 25) {
            System.out.println("BMI valido");
        } else {
            System.out.println("BMI non valido");
            System.out.println("Non ammesso alla gara");
            return;
        }

        System.out.println("Ammesso alla gara");

    }
}
