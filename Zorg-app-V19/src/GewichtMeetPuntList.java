import java.util.Iterator;

public class GewichtMeetPuntList {

    // Constructor
    public GewichtMeetPuntList(){

    }

/*/////////////////////////////////////

    PRINT METHODS

*//////////////////////////////////////

    // Print de staafdiagram uit
    public void printStaafdiagram(Profile patient) {
        if (patient.getGewichtMeetPunten().size() == 0) {
            return;
        }
        Scan eigenScan = new Scan();
        double streefgewicht = eigenScan.streefGewicht();
        String kleurRood = "\u001B[31m";
        String kleurGeel = "\u001B[33m";
        String kleurReset = "\u001B[0m";
        System.out.println(kleurGeel + Talen.rb().getString("2kgVerschil") + kleurRood + "   " +
                Talen.rb().getString("5kgVerschil") + kleurReset);
        System.out.println(Talen.rb().getString("staafdiagram"));
        System.out.println("                      0    10   20   30   40   50   60   70   80   90   100  110  120  130");
        System.out.println("                      |    |    |    |    |    |    |    |    |    |    |    |    |    |");
        System.out.println(Talen.rb().getString("datumTijd"));
        for (GewichtMeetPunt g : patient.getGewichtMeetPunten()) {
            System.out.print(g.getMeetpuntDatumTijd() + "   ");
            g.printStaven(streefgewicht);
        }
    }

/*/////////////////////////////////////

    BEWERK METHODS

*//////////////////////////////////////

    // Runt de functie voor het bewerken van gewichtmeetpunten.
    public void bewerkGewichtMeetpunten(Profile patient) {
        Scan eigenScan = new Scan();
        if (patient.getGewichtMeetPunten().size() == 0) {
            System.out.println(Talen.rb().getString("geenMeetpuntBewerken"));
            return;
        }
        boolean inListofMenuTerug = false;
        while (!inListofMenuTerug) {
            System.out.println(Talen.rb().getString("toetsMeetpuntNummer"));
            System.out.println(Talen.rb().getString("toets99"));
            int choice = eigenScan.getChoiceGewichtMeetpunt();
            for (GewichtMeetPunt g : patient.getGewichtMeetPunten()) {
                if (choice == g.getMeetpuntNummer()) {
                    g.setMeetpuntGewicht(eigenScan.nieuwGewicht());
                    inListofMenuTerug = true;
                }
                if (choice == 99) {
                    inListofMenuTerug = true;
                }
            }
            if (!inListofMenuTerug) {
                System.out.println(Talen.rb().getString("meetpuntNietBekend"));
            }
        }
    }

    // Runt de functie voor het handmatig toevoegen van gewichtmeetpunten
    public void addGewichtMeetpunten(Profile patient){
        Scan eigenScan = new Scan();
        GewichtMeetPunt meetpunt;
        meetpunt = eigenScan.addGewichtMeetpunt();
        patient.aantalMeetpuntenPlusEen();
        meetpunt.setMeetpuntNummer(patient.getAantalMeetpunten());
        patient.getGewichtMeetPunten().add(meetpunt);
        System.out.println(Talen.rb().getString("meetpuntToegevoegd"));
    }

    // Runt de functie om een meetpunt te verwijderen
    public void deleteGewichtMeetpunt(Profile patient) {
        Scan eigenScan = new Scan();
        if (patient.getGewichtMeetPunten().size() == 0) {
            System.out.println(Talen.rb().getString("geenGewichtmeetpuntVerwijderen"));
            return;
        }
        boolean inListofMenuTerug = false;
        while (!inListofMenuTerug) {
            System.out.println(Talen.rb().getString("toetsMeetpuntNummerVerwijderen"));
            System.out.println(Talen.rb().getString("toets99"));
            int choice = eigenScan.getChoiceGewichtMeetpunt();
            Iterator<GewichtMeetPunt> it = patient.getGewichtMeetPunten().iterator();
            while (it.hasNext()) {
                GewichtMeetPunt i = it.next();
                if (choice == i.getMeetpuntNummer()) {
                    it.remove();
                    inListofMenuTerug = true;
                    System.out.println(Talen.rb().getString("meetpuntVerwijderd"));
                }
                if (choice == 99) {
                    inListofMenuTerug = true;
                }
            }
            if (!inListofMenuTerug){
                System.out.println(Talen.rb().getString("meetpuntNietBekend"));
            }
        }
    }
}
