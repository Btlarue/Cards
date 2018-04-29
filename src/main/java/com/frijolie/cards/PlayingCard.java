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
 * A concrete class used to implement behavior of a playing card. Implements the interface Card.
 *
 * <p>This object assumes that each card has a <code>Rank</code>, <code>Suit</code>, and value.</p>
 * @author  Frijolie
 * @version 0.1
 * @since   0.1
 * @see     Rank
 * @see     Suit
 */
public class PlayingCard implements Card {

  private final Rank rank;
  private final Suit suit;

  /**
   * Class constructor. Used to initialize instance variables with values.
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
   * An accessor method which returns the <code>Suit</code> of the card
   *
   * @return  the card suit (Hearts, Clubs, Spades, or Diamonds)
   * @see     Suit
   * @since   0.1
   */
  @Override
  public Suit getSuit() {
    return suit;
  }

  /**
   * An accessor method which returns the <code>Color</code> of the card <code>Suit</code>.
   *
   * @return  the cards suit color
   * @see     Color
   * @see     Suit
   * @see     Suit#getColor()
   * @since   0.1
   */
  public Color getColor() {
    return suit.getColor();
  }

  /**
   * An accessor method which returns the <code>Rank</code> of the card.
   *
   * @return  the card Rank enumeration value.
   * @see     Rank
   * @since   0.1
   */
  @Override
  public Rank getRank() {
    return rank;
  }

  /**
   * Displays a phrase of a card, utilizing the letter and symbol. For example, "A(Heart)"
   *
   * @return  a string representation of the card utilizing the letter and symbol
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
   * Returns the int value of the card.
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