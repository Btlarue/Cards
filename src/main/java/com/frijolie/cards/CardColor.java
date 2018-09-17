package com.frijolie.cards;

/**
 * An enumeration of all possible values for a {@link PlayingCard} color. Valid values are: RED or
 * BLACK. The colors are always associated with a card {@link Suit}.
 *
 * @author Frijolie
 * @version 0.1
 * @see Card
 * @see PlayingCard
 * @see Suit
 */
public enum CardColor {
  /**
   * PlayingCard suits that are red: DIAMONDS and HEARTS
   */
  RED("Red"),
  /**
   * PlayingCard suits that are black: CLUBS and SPADES
   */
  BLACK("Black");

  /**
   * A String used to represent the name of the color
   */
  String name;

  /**
   * Constructor.
   * @param name to assign to the constant.
   */
  CardColor(final String name) {
    this.name = name;
  }

  /**
   * Returns the CardColor name as a string. For example, "Red"
   * @return
   */
  @Override
  public String toString() {
    return name;
  }

}