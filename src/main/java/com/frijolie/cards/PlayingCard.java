package com.frijolie.cards;

import java.util.Objects;

/**
 * A PlayingCard is a concrete class used to represent a single card in a deck of cards. Every
 * playing card will have a {@link Rank} and {@link Suit}. Each of these cards will need to be
 * compared with other PlayingCards.
 *
 * @author Frijolie
 * @version 0.1
 * @see Rank
 * @see Suit
 */
public class PlayingCard implements Card, Comparable {

  /**
   * The cards Rank. Values are ACE, TWO, THREE ... TEN, JACK, QUEEN, KING.
   */
  private final Rank rank;
  /**
   * The card's Suit. Valid values are: CLUBS, DIAMONDS, SPADES, or HEARTS.
   */
  private final Suit suit;

  /**
   * Constructor. Must provide a {@link Rank} and {@link Suit}
   * @param rank of the card
   * @param suit of the card
   */
  public PlayingCard(final Rank rank, final Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  @Override
  public int getValue() {
    return rank.getValue();
  }

  @Override
  public Rank getRank() {
    return rank;
  }

  /**
   * Returns the representation of the Card rank, as a single character. For example, '5' or 'Q'
   * @return a character representation of the card Rank
   */
  public char getRankLetter() {
    return rank.getLetter();
  }

  /**
   * Returns the representation of the Card rank as a word. For example, "Ten" or "King"
   *
   * @return the string representation of the card Rank
   */
  public String getRankName() {
    return rank.getName();
  }

  @Override
  public Suit getSuit() {
    return suit;
  }

  public String getSuitName() {
    return suit.getName();
  }

  @Override
  public CardColor getColor() {
    return suit.getColor();
  }

  /**
   * Returns the representation of the cards suit as a unicode character.
   * @return the cards rank, represented as a symbol
   */
  public char getSymbol() {
    return suit.getSymbol();
  }

  @Override
  public boolean equals(Object o) {
    Objects.requireNonNull(o, "The object for comparison must not be null");
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card that = (Card) o;
    return getRank() == that.getRank() && getSuit() == that.getSuit();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getRank(), getSuit());
  }

  @Override
  public int compareTo(Object o) {
    Objects.requireNonNull(o, "The card used for comparison must not be null");
    Card card = (Card) o;
    int suitOrdinal = suit.compareTo(card.getSuit());
    if (suitOrdinal != 0) {
      return suitOrdinal;
    } else {
      return rank.compareTo(card.getRank());
    }
  }

  @Override
  public String toString() {
    return Character.toString(getRankLetter()) + Character.toString(suit.getSymbol());
  }

  /**
   * Returns {@code true} if the color of this card is the same as the one being compared.
   * @param card to be compared with this card
   * @return {@code true} if the colors are the same
   */
  public boolean sameColor(Card card) {
    Objects.requireNonNull(card, "You must pass a non null card for comparison.");
    return getColor() == card.getColor();
  }

}