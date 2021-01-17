package locales;

import java.util.*;

public class LocaleList {

  public static void main(String [] args) {
    String[] languageCodes = Locale.getISOLanguages();
    System.out.println("Language Codes:");
    for (String code : languageCodes) {
      Locale loc = new Locale(code);
      System.out.println(code + " -> " + loc.getDisplayLanguage());
    }
    
    String[] countryCodes = Locale.getISOCountries();
    System.out.println("\nCountry Codes:");
    for (String code : countryCodes) {
      Locale loc = new Locale("", code);
      System.out.println(loc.getCountry() + " -> " + loc.getDisplayCountry());
    }
  }
}

