import java.util.Locale;
import java.util.ResourceBundle;

public class Talen {

    private static String taal;

    // Constructor
    public Talen(){

    }

    // Instellen taal
    public static void setTaal(String s){
        taal = s;
    }

    // Ophalen woordenboek
    public static ResourceBundle rb(){
        Locale l = new Locale(taal);
        ResourceBundle rb = ResourceBundle.getBundle("Bundle", l);
        return rb;
    }
}
