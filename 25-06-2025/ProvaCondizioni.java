public class ProvaCondizioni {
    public static void main(String[] args) {

        // condizioni booleane ed espressioni booleane
        int myAge = 31;
        int votingAge = 18;

        // struttura condizionale solo if(condizione) {}
        if (myAge > 11) {
            System.out.println("Sicuramente non sei un bambino e sei almeno un ragazzino");
        }

        // struttura condizionale con if(condizione) {} else {}
        if (myAge > votingAge) {
            System.out.println("Puoi votare!");
        } else {
            System.out.println("Non puoi votare... :'( ");
        }

        // struttura condizonale con if/else-if
        if (myAge < 11) {
            System.out.println("Sei un bimbo!");
        } else if (myAge < 18) {
            System.out.println("Sei un teenager");
        } else {
            System.out.println("Sei un adulto");
        }

        // struttura condizionale con operatore ternario
        String fasciaEtà = (myAge >= 18) ? "Sei maggiorenne" : "Sei minorenne";
        System.out.println(fasciaEtà);

        // struttura condizionale con switch
        String fasciaEtà2 = switch (myAge) {
            case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 -> "Bambino";
            case 12, 13, 14, 15, 16, 17 -> "Ragazzo";
            default -> "Adulto";
        };
        System.out.println("Sei un: " + fasciaEtà2);
    }
}
