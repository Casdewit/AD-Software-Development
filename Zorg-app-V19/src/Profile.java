import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Profile {
    private String        voornaam;
    private String        achternaam;
    private int           leeftijd;
    private double        gewicht;
    private final double  lengte;
    private int           aantalMeetpunten;
    private ArrayList<Medicijn>        medicijnenPatient        = new ArrayList<Medicijn>();
    private ArrayList<GewichtMeetPunt> gewichtMeetpuntenPatient = new ArrayList<>();

    // Constructor
    public Profile(String firstName, String lastName, int age, double weight, double length) {
        voornaam   = firstName;
        achternaam = lastName;
        leeftijd   = age;
        gewicht    = weight;
        lengte     = length;
    }

/*/////////////////////////////////////

    PRINT METHODS

*//////////////////////////////////////

    // Weergeeft het volledige profiel van een patiënt
    public void printProfile() {
        System.out.println(Talen.rb().getString("voornaam")   + voornaam);
        System.out.println(Talen.rb().getString("achternaam") + achternaam);
        System.out.println(Talen.rb().getString("leeftijd")   + leeftijd);
        System.out.println(Talen.rb().getString("gewicht")    + gewicht + "kg");
        System.out.println(Talen.rb().getString("lengte")     + lengte + "m");
        getBMI();
    }

    // Print de medicijnenlijst van de patiënt uit
    public void printMedicijnenPatient() {
        if (medicijnenPatient.size() == 0) {
            System.out.println(Talen.rb().getString("geenMedsTeWeergeven"));
        }
        for (Medicijn m : medicijnenPatient) {
            m.printMedicijnen();
        }
    }

    // Print de meetpunten vanuit de arraylist uit met printMeetpunten
    public void printGewichtMeetpunten() {
        if (getGewichtMeetPunten().size() == 0) {
            System.out.println(Talen.rb().getString("geenGewichtmeetpunten"));
            return;
        }
        for (GewichtMeetPunt g : gewichtMeetpuntenPatient) {
            g.printMeetpunt();
        }
    }

/*/////////////////////////////////////

    BEWERK METHODS

*//////////////////////////////////////

    // Namen bewerken
    public void setNames() {
        Scan eigenScan = new Scan();
        System.out.println(Talen.rb().getString("vulNieuweVoornaamIn"));
        setVoornaam(eigenScan.nieuweNaam());
        System.out.println(Talen.rb().getString("vulNieuweAchternaamIn"));
        setAchternaam(eigenScan.nieuweNaam());
        System.out.println(Talen.rb().getString("voornaam") + voornaam + "   " + Talen.rb().getString("achternaam") + achternaam);
    }

    // Leeftijd bewerken
    public void setAge() {
        Scan eigenScan = new Scan();
        System.out.println(Talen.rb().getString("huidigeLeeftijd") + leeftijd);
        setLeeftijd(eigenScan.nieuweLeeftijd());
        System.out.println(Talen.rb().getString("leeftijd") + leeftijd);
    }

    // Gewicht bewerken en toevoegen meetpunt
    public void setWeight() {
        Scan eigenScan = new Scan();
        System.out.println(Talen.rb().getString("huidigGewicht") + gewicht);
        setGewicht(eigenScan.nieuwGewicht());
        System.out.println(Talen.rb().getString("nieuwGewicht") + gewicht);

        // Toevoegen aan gewichtmeetpunten
        GewichtMeetPunt meetpunt = new GewichtMeetPunt(LocalDateTime.now(), gewicht);
        aantalMeetpunten++;
        meetpunt.setMeetpuntNummer(aantalMeetpunten);
        gewichtMeetpuntenPatient.add(meetpunt);
    }

/*/////////////////////////////////////

    GETTERS EN SETTERS

*//////////////////////////////////////

    // Vult de voornaam in
    public void setVoornaam(String firstName) {
        voornaam = firstName;
    }

    // Haalt de voornaam op
    public String getVoornaam() {
        return voornaam;
    }

    // Vult de achternaam in
    public void setAchternaam(String lastName) {
        achternaam = lastName;
    }

    // Haalt de achternaam op
    public String getAchternaam() {
        return achternaam;
    }

    // Vult de leeftijd in
    public void setLeeftijd(int age) {
        leeftijd = age;
    }

    // Vult het gewicht in
    public void setGewicht(double weight) {
        gewicht = weight;
    }

    // Haalt het gewicht op
    public double getGewicht() {
        return gewicht;
    }

    // Haalt de medicijnenlijst van de patiënt op
    public ArrayList<Medicijn> getMedicijnenPatient() {
        return medicijnenPatient;
    }

    // Haalt de gewichtmeetpunten van de patiënt op
    public ArrayList<GewichtMeetPunt> getGewichtMeetPunten() {
        return gewichtMeetpuntenPatient;
    }

    // Doet een meetpunt bij bij het aantal meetpunten
    public void aantalMeetpuntenPlusEen(){
        aantalMeetpunten++;
    }

    // Returned het aantal meetpunten
    public int getAantalMeetpunten(){
        return aantalMeetpunten;
    }

    // Weergeeft de BMI
    public void getBMI() {
        double bmi;
        DecimalFormat df = new DecimalFormat("##.##");
        bmi = gewicht / (lengte * lengte);
        System.out.println("BMI: " + df.format(bmi));
    }
}