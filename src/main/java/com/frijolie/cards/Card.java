package com.frijolie.cards;

/**
 * Card is an interface used to represent the required behavior of a {@link PlayingCard} in a
 * classic {@link Deck} of cards. It assumes all cards have a {@link Rank} and {@link Suit}. Valid
 * ranks of a playing card are: ACE, TWO, THREE, ... TEN, JACK, QUEEN, and KING. Valid playing card
 * suits are: Clubs, Diamonds, Spades, and Hearts. The values of each card are determined by rank.
 *
 * @author Frijolie
 * @version 0.1
 * @see PlayingCard
 * @see Rank
 * @see Suit
 * @see Deck
 */
public interface Card {

  /**
   * Returns the value of the Card as an int. This is determined by the card's {@link Rank}.
   *
   * @return the value of the Card as an {@code int}
   * @see Rank#getValue()
   */
  int getValue();

  /**
   * Returns the {@link Rank} enumeration value of the card. Values can be ACE, TWO, THREE, ... TEN,
   * JACK, QUEEN, or KING.
   *
   * @return the {@link Rank} enumeration value of the card.
   * @see Rank
   */
  Rank getRank();

  /**
   * Returns the {@link Suit} enumeration value of the card. Valid suits are: CLUBS, DIAMONDS,
   * SPADES, and HEARTS.
   *
   * @return the {@link Suit} enumeration value
   * @see {@link Suit}
   */
  Suit getSuit();

  /**
   * Returns the {@link CardColor} of the Card as an enumerated value. Valid CardColors are: RED and
   * BLACK.
   *
   * @return the enumerated value of {@link CardColor}.
   * @see {@link CardColor}
   */
  CardColor getColor();

}