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
 * Card is an interface representing the required behavior of a card in a classic deck of playing cards.
 * It assumes all cards have a <code>Rank</code>, <code>Suit</code> and a value. Valid PlayingCard
 * rank values are Ace, 2, 3,...10, Jack, Queen, and King. Valid suits are: Clubs, Diamonds, Spades,
 * and Hearts. PlayingCard values are determined by the rank of the card. Each card will inevitably
 * need to be compared with other cards. Therefore all classes that implement this interface will
 * need to override equals(), hashcode(), and compareTo() to provide a means of comparison among cards.
 *
 * @author  Frijolie
 * @version 0.1
 * @see     Rank
 * @see     Suit
 * @since   0.1
 */
public interface Card extends Comparable<Card> {

  /**
   * An accessor method that returns the int value of the <code>Card</code>. The value is inherently
   * coupled with the <code>Rank</code> of the card
   *
   * @return  an int value of a card
   * @since   0.1
   * @see     Rank
   * @see     Rank#getValue()
   */
  int getValue();

  /**
   * An accessor method which returns the Rank of the card. Rank is an enumeration of values a card
   * could possess. A card rank could return a value from Ace, 2, 3, ... , 10, Jack, Queen, or King.
   *
   * @return a constant value of the Rank enum type
   * @see     Rank
   * @since   0.1
   *
   */
  Rank getRank();

  /**
   * An accessor method which returns the Suit of the card. Suit is an enumeration of values a card
   * could possess. A card Suit could return a value from Hearts, Clubs, Diamonds, or Spades.
   *
   * @return a constant value of the Suit enum type.
   * @see     Suit
   * @since   0.1
   */
  Suit getSuit();

  /**
   * An accessor method which returns the Color of the card. Color is an enumeration of values a card
   * coulc possess. A card Color could return a value of either Red or Black.
   *
   * @return the color of the suit of the card. Will return either Color.RED or Color.BLACK
   * @since 0.1
   * @see     Suit
   */
  Color getColor();

  /**
   * A method to display the card onscreen, whether it be in the console or a graphical interface.
   *
   * @since 0.1
   */
  void displayCard();

  /**
   * {@inheritDoc}
   *
   * @since 0.1
   */
  boolean equals(final Object o);

  /**
   * {@inheritDoc}
   *
   * @since   0.1
   */
  int hashCode();

  /**
   * A method to flip the card face up (if face down) or face down (if face up).
   *
   * @since 0.1
   */
  void flip();

  /**
   * A method to determine if the card is face up. Should display the card back if face down.
   *
   * @return <code>true</code> if the card is face up.
   * @since 0.1
   */
  boolean isFaceUp();

}