package tpPharma.regexPharma;

public class Regex {
    public static final String LETTRE = "^\\p{L}+$";

    public static final String EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public static final String DATE = "^\\d{4}-\\d{2}-\\d{2}$";

    public static final String CODE_POSTAL = "^\\d{5}$";

    public static final String TELEPHONE = "^(0\\d)([\\s.-]?\\d{2}){4}$";

    public static final String SECURITE_SOCIALE = "^[12]\\d{2}\\d{2}\\d{2}\\d{3}\\d{3}\\d{2}$";

    // Méthodes utilitaires de validation
    public static boolean isValid(String value, String regex) {
        return value != null && value.matches(regex);
    }
}
