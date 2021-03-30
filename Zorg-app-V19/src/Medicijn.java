public class Medicijn {

    private String medicijnNaam;
    private String soort;
    private String dosering;

    // Constructor voor medicijn
    public Medicijn(String medNaam, String medSoort, String medDosering) {
        medicijnNaam = medNaam;
        soort        = medSoort;
        dosering     = medDosering;
    }

    // Print de medicijnspecificaties
    public void printMedicijnen() {
        System.out.println(Talen.rb().getString("medName") + medicijnNaam);
        System.out.println(Talen.rb().getString("medSoort") + soort);
        System.out.println(Talen.rb().getString("medDosering") + dosering);
        System.out.println();
    }

    // Returned de naam van het medicijn
    public String getMedicijnNaam() {
        return medicijnNaam;
    }
}
