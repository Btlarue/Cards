/*
 * The MIT License
 *
 * Copyright (c) 2018 Frijolie.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.frijolie.cards;

import java.util.Objects;

/**
 * A concrete class used to implement behavior of an individual playing card. This implements the Card
 * interface. Each PlayingCard has a <code>Rank</code> and a <code>Suit</code>.
 *
 * @author  Frijolie
 * @version 0.1
 * @since   0.1
 * @see     Card
 * @see     Rank
 * @see     Suit
 */
public class PlayingCard implements Card {

  private final Rank rank;
  private final Suit suit;
  private boolean isFaceUp;

  /**
   * Class constructor. Used to initialize instance variables with constant values. There are no
   * default values to provide. Rank and Suit always need to be supplied to instantiate a card.
   *
   * @param rank  the cards rank
   * @param suit  the cards suit
   * @see   Rank
   * @see   Suit
   */
  public PlayingCard(final Rank rank, final Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  /**
   * An accessor method which returns the <code>Suit</code> of the card. The values of a PlayingCard
   * suit are are: Hearts, Clubs, Diamonds, or Spades.
   *
   * @return the card suit Hearts, Clubs, Spades, or Diamonds
   * @see     Suit
   * @since   0.1
   */
  @Override
  public Suit getSuit() {
    return suit;
  }

  /**
   * An accessor method which returns the <code>Color</code> of the card, usually associated with the
   * card's <code>Suit</code>. Color values of a PlayingCard are: Red or Black
   *
   * @return the color of the cards suit: Red or Black
   * @see     Color
   * @see     Suit
   * @see     Suit#getColor()
   * @since   0.1
   */
  public Color getColor() {
    return suit.getColor();
  }

  /**
   * An accessor method which returns the <code>Rank</code> of the card. Values of a card rank are:
   * Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, and King.
   *
   * @return the Rank of the playing card: [A,2,3,4,5,6,7,8,9,10,J,Q,K]
   * @see     Rank
   * @since   0.1
   */
  @Override
  public Rank getRank() {
    return rank;
  }

  /**
   * Displays a description phrase of the card, utilizing the rank letter and suit symbol.
   * For example, "A(Heart)"
   *
   * @return a string description of the card utilizing the rank letter and suit symbol
   * @see     Rank#getLetter()
   * @see     Suit#getSymbol()
   * @since   0.1
   */
  @Override
  public String toString() {
    return rank.getLetter() + suit.getSymbol();
  }

  /**
   * Displays the card using the standard output
   *
   * @see   #toString()
   * @since 0.1
   */
  @Override
  public void displayCard() {
    System.out.println(toString());
  }

  /**
   * Returns the int value of the card. PlayingCard value is coupled with the card Rank.
   *
   * @return the int value of the card.
   * @see     Rank
   * @see     Rank#getValue()
   * @since   0.1
   */
  @Override
  public int getValue() {
    return rank.getValue();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(final Object o) {
    Objects.requireNonNull(o);
    boolean isEqual;
    if (!(o instanceof Card)) {
      isEqual = false;
    } else if (this == o) {
      isEqual = true;
    } else {
      var card = (Card) o;
      isEqual = (this.getRank().equals(card.getRank()) && this.suit.equals(card.getSuit()));
    }
    return isEqual;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    int suitMultiplier = suit.ordinal() + 2;
    int rankMultiplier = rank.ordinal() + 3;
    return (suitMultiplier * rankMultiplier) * 31;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void flip() {
    isFaceUp = !isFaceUp;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isFaceUp() {
    return isFaceUp;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int compareTo(Card o) {
    var card = Objects.requireNonNull(o);
    var suitCompareResult = this.suit.compareTo(card.getSuit());
    if (suitCompareResult != 0) {
      return suitCompareResult;
    } else {
      return this.rank.compareTo(card.getRank());
    }
  }

}