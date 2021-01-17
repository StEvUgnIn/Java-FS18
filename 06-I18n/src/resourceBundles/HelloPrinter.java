package resourceBundles;

import java.util.*;
public class HelloPrinter {

  public static void main(String[] args) throws MissingResourceException {
    ResourceBundle rb;
    String hi, bye;
    String defaultLocale = Locale.getDefault().toLanguageTag();

    rb = ResourceBundle.getBundle("resourceBundles.HelloResourceBundle");
    hi = rb.getString("hi"); bye = rb.getString("bye");
    System.out.println("Default locale: " + defaultLocale
		     + " -> " + hi + ", " + bye);

    rb = ResourceBundle.getBundle("resourceBundles.HelloResourceBundle", Locale.GERMAN);
    hi = rb.getString("hi"); bye = rb.getString("bye");
    System.out.println("German -> " + hi + ", " + bye);

    rb = ResourceBundle.getBundle("resourceBundles.HelloResourceBundle",
				  Locale.forLanguageTag("de-CH"));
    hi = rb.getString("hi"); bye = rb.getString("bye");
    System.out.println("Swiss German -> " + hi + ", " + bye);
  }
}
