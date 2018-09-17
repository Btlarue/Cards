package com.frijolie.cards;

/**
 * Rank is an enumeration of all possible {@link PlayingCard} ranks. Possible values (listed in
 * ascending order) are from Ace to King.
 *
 * @author Frijolie
 * @version 0.1
 */
public enum Rank {

  ACE("Ace", 'A', 1),
  TWO("Two", '2', 2),
  THREE("Three", '3', 3),
  FOUR("Four", '4', 4),
  FIVE("Five", '5', 5),
  SIX("Six", '6', 6),
  SEVEN("Seven", '7', 7),
  EIGHT("Eight", '8', 8),
  NINE("Nine", '9', 9),
  TEN("Ten", 'T', 10),
  JACK("Jack", 'J', 10),
  QUEEN("Queen", 'Q', 10),
  KING("King", 'K', 10);


  /**
   * The representation of rank in the form of a word. For example, "Jack"
   */
  private final String name;
  /**
   * The representation of rank in the form of a single character. For example, 'Q'
   */
  private final char letter;
  /**
   * The numerical value of rank in the form or an {@code int}. For example, 10
   */
  private final int value;

  /**
   * Constructor. Must provide a name, letter, and int value.
   * @param name the string representation to be assigned
   * @param letter the char representation to be assigned
   * @param value the int value to be assigned
   */
  Rank(String name, char letter, int value) {
    this.name = name;
    this.letter = letter;
    this.value = value;
  }

  /**
   * Returns the string representation of the Rank name in the form of a word. For example, "Queen"
   * @return the name of the rank in the form of a word
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the representation of the rank in the form of a single character. For example, 'K'
   * @return the letter of the rank in the form as a single character
   */
  public char getLetter() {
    return letter;
  }

  /**
   * Returns the numerical value of the rank in the form of an int. For example, 10
   *
   * @return the ranks numerical value
   */
  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return name;
  }

}