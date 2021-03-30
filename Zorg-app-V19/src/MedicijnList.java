import java.util.ArrayList;
import java.util.Iterator;

public class MedicijnList {

    private ArrayList<Medicijn> completeLijst = new ArrayList<Medicijn>();

    // Constructor
    public MedicijnList() {

    }

    // Returned de complete medicijnlijst
    public ArrayList<Medicijn> getCompleteLijst() {
        Medicijn paracetamol = new Medicijn("Paracetamol", Talen.rb().getString("tegenHoofdpijn"), Talen.rb().getString("eenmaalDaagsPil"));
        Medicijn ibuprofen   = new Medicijn("Ibuprofen", Talen.rb().getString("tegenOnsteking"), Talen.rb().getString("eenmaalDaagsPil"));
        Medicijn antibiotica = new Medicijn(Talen.rb().getString("antibiotica"), Talen.rb().getString("tegenBacterien"), Talen.rb().getString("eenmaalDaagsPil"));
        Medicijn diazepam    = new Medicijn("Diazepam", Talen.rb().getString("troubleSleeping"), Talen.rb().getString("eenmaalDaagsMg"));

        ArrayList<Medicijn> lijst = new ArrayList<Medicijn>();
        lijst.add(paracetamol);
        lijst.add(ibuprofen);
        lijst.add(antibiotica);
        lijst.add(diazepam);

        completeLijst = lijst;
        return completeLijst;
    }

/*/////////////////////////////////////

    BEWERK METHODS

*//////////////////////////////////////

    // Medicatie toevoegen
    public void addMedicijnen(Profile patient) {
        Scan eigenScan = new Scan();
        boolean inListofMenuTerug = false;
        while (!inListofMenuTerug) {
            String invoer = eigenScan.scanForAddOrDelete(1);
            if (checkForDuplicate(invoer, patient.getMedicijnenPatient())) {
                return;
            }
            for (Medicijn m : getCompleteLijst()) {
                if (invoer.equals(m.getMedicijnNaam())) {
                    inListofMenuTerug = true;
                    patient.getMedicijnenPatient().add(m);
                    System.out.println(Talen.rb().getString("toegevoegd") + m.getMedicijnNaam() + "\n");
                }
                if (invoer.equals("9")) {
                    inListofMenuTerug = true;
                }
            }
            if (!inListofMenuTerug) {
                System.out.println(Talen.rb().getString("medNietInSysteem"));
            }
        }
    }

    // Medicatie verwijderen
    public void deleteMedicijnen(Profile patient) {
        Scan eigenScan = new Scan();
        if (checkIfListIsEmpty(patient)) {
            return;
        }
        boolean inListofMenuTerug = false;
        while (!inListofMenuTerug) {
            String invoer = eigenScan.scanForAddOrDelete(2);
            Iterator<Medicijn> it = patient.getMedicijnenPatient().iterator();
            while (it.hasNext()) {
                Medicijn i = it.next();
                if (invoer.equals(i.getMedicijnNaam())) {
                    it.remove();
                    inListofMenuTerug = true;
                    System.out.println(Talen.rb().getString("verwijderd") + i.getMedicijnNaam() + "\n");
                }
                if (invoer.equals("9")) {
                    inListofMenuTerug = true;
                }
            }
            if (!inListofMenuTerug) {
                System.out.println(Talen.rb().getString("medNietInSysteem"));
            }
        }
    }

    // Checken of de medicatie niet al in de lijst van de patient opgenomen staat
    public boolean checkForDuplicate(String invoer, ArrayList<Medicijn> lijstPatient) {
        for (Medicijn m : lijstPatient) {
            if (invoer.equals(m.getMedicijnNaam())) {
                System.out.println(Talen.rb().getString("medAlInLijst"));
                return true;
            }
        }
        return false;
    }

    // Checken of de lijst van de patient leeg is
    public boolean checkIfListIsEmpty(Profile patient) {
        if (patient.getMedicijnenPatient().size() == 0) {
            System.out.println(Talen.rb().getString("geenMedsTeVerwijderen"));
            return true;
        }
        return false;
    }

    // Print de complete medicijnlijst (database)
    public void printCompleteMedicijnLijst() {
        System.out.println(Talen.rb().getString("completeMedicijnlijst"));
        for (Medicijn m : getCompleteLijst()) {
            System.out.println(m.getMedicijnNaam());
        }
        System.out.println();
    }
}
