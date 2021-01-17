package ex1;

/**
   This class collects a pair of elements of the same type.
*/
public class Pair<T> {

  private T first;
  private T second;

  /**
     Constructs a pair containing two given elements.
     @param firstElement the first element
     @param secondElement the second element
  */
  public Pair(T firstElement, T secondElement) {
    first = firstElement;
    second = secondElement;
  }

  /**
     Gets the first element of this pair.
     @return the first element
  */
  public T getFirst() { return first; }

  /**
     Gets the second element of this pair.
     @return the second element
  */
  public T getSecond() { return second; }

  /**
     Sets the first element of this pair.
     @param value the value of the first element
  */
  public void setFirst(T value) { first = value; }

  /**
     Sets the second element of this pair.
     @param value the value of the second element
  */
  public void setSecond(T value) { second = value; }

}
