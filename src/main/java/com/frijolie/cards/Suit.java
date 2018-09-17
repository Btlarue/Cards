package com.frijolie.cards;

/**
 * Suit is an enumeration of all possible values for a {@link PlayingCard} suit. Each constant
 * contains a Name, Symbol, and {@link CardColor}. Valid values are: CLUBS, DIAMONDS, SPADES, and
 * HEARTS.
 * <p>
 * These values are listed in a specific order as to alternate colors so they are aesthetically
 * pleasing when displayed in a collection.
 *
 * @author Frijolie
 * @version 0.1
 * @see PlayingCard
 * @see CardColor
 */
public enum Suit {
  CLUBS("Clubs", '\u2663', CardColor.BLACK),
  DIAMONDS("Diamonds", '\u2666', CardColor.RED),
  SPADES("Spades", '\u2660', CardColor.BLACK),
  HEARTS("Hearts", '\u2764', CardColor.RED);

  /**
   * The representation of the Suit in the form of a word. For example, "Diamonds"
   */
  private final String name;
  /**
   * The representation of the Suit in the form of a single character. For example, ♠
   */
  private final char symbol;
  /**
   * The representation of the CardColor in the form of an enum Constant. For example,
   * CardColor.BLACK
   */
  private final CardColor color;

  /**
   * Constructor. Must supply a Name, Symbol, and CardColor.
   *
   * @param name the string representation of the card to be assigned
   * @param symbol the single character used to represent the suit.
   * @param color the color of the card
   */
  Suit(String name, char symbol, CardColor color) {
    this.name = name;
    this.symbol = symbol;
    this.color = color;
  }

  /**
   * Returns the String representation of the Suit in the form of a word. For example, "Hearts"
   *
   * @return the name of the Suit
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the char representation of the Suit in the form of a unicode character. For example, ♠
   *
   * @return the suit symbol as a single unicode character
   */
  public char getSymbol() {
    return symbol;
  }

  /**
   * Returns the CardColor of the suit. For example, CardColor.RED
   *
   * @return the color of the suit
   */
  public CardColor getColor() {
    return color;
  }

  @Override
  public String toString() {
    return name;
  }

}