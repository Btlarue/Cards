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

/**
 * Card is an interface representing a playing card in a classic deck of cards. It assumes all cards
 * have a <code>Rank</code> (Ace through King), <code>Suit</code> (Hearts, Clubs, Spades, and Diamonds)
 * and a value. Each card will inevitably need to be compared (ranked) against other similar cards.
 * These cards are intended to be reused in various games that involve a playing card.
 *
 * @author  Frijolie
 * @version 0.1
 * @see     Rank
 * @see     Suit
 * @since   0.1
 */
public interface Card extends Comparable<Card> {

  /**
   * returns a String representation of the card containing a <code>Rank</code> and <code>Suit</code>.
   *
   * @return  "&lt;rank&gt; of &lt;suit&gt;";
   * @since   0.1
   */
  String toString();

  /**
   * An accessor method that returns the int value of the <code>Card</code>.
   * <p>This value is inherently coupled with the <code>Rank</code> of the card</p>
   *
   * @return  an int value of a card
   * @since   0.1
   */
  int getValue();

  /**
   * An accessor method which returns the Rank of the card.
   * <p>Rank is an enumeration, it could return a value from Ace through King.</p>
   *
   * @return  a constant of the Rank enum type
   * @see     Rank
   * @since   0.1
   *
   */
  Rank getRank();

  /**
   * An accessor method which returns the Suit of the card.
   * <p>Suit is an enumeration, it could return HEARTS, CLUBS, DIAMONDS, or SPADES.</p>
   *
   * @return  a constant of the Suit enum type.
   * @see     Suit
   * @since   0.1
   */
  Suit getSuit();

  /**
   * A method to display the card onscreen, currently in the console.
   *
   * @since 0.1
   */
  void displayCard();

  /**
   * A method used to test for equality between Cards.
   *
   * @param o the card being compared to this card
   * @return  <code>false</code> if is not an instanceof Card or they are not equal.
   *          <code>true</code> if this card and the one compared reference the same Object
   */
  boolean equals(final Object o);

  /**
   * A method to generate a unique integer value for every card.
   * <p>A salt value is added to the ordinal values of Rank and Suit. This value is then multiplied
   * by another salt value to generate the hashcode of a card.</p>
   *
   * @return  an int value of a card
   * @see     Rank
   * @see     Suit
   * @since   0.1
   */
  int hashCode();

}