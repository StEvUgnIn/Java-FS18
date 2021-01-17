package locales;

import java.util.*;

public class LocalePrinter {

  public static void main(String [] args) {
    Locale loc = Locale.getDefault();

    System.out.println("Default locale: " + loc.toLanguageTag());
    System.out.println(" - Language: " + loc.getLanguage() + "  " +
		       loc.getDisplayLanguage());
    System.out.println(" - Country: " + loc.getCountry() + "  " +
		       loc.getDisplayCountry());
    System.out.println(" - Name: " + loc.getDisplayName());

    System.out.println("In german...");
    System.out.println(" - Language: " + loc.getDisplayLanguage(Locale.GERMAN));
    System.out.println(" - Country: " + loc.getDisplayCountry(Locale.GERMAN));
    System.out.println(" - Name: " + loc.getDisplayName(Locale.GERMAN));

    Locale.setDefault(Locale.FRENCH);
    System.out.println("In french...");
    System.out.println(" - Language: " + loc.getDisplayLanguage());
    System.out.println(" - Country: " + loc.getDisplayCountry());
    System.out.println(" - Name: " + loc.getDisplayName());
  }
}

