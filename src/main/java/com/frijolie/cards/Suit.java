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
 * An enumeration of all possible suits of a <code>Card</code>. Values are: Clubs, Diamonds, Spades, and Hearts.
 *
 * <p>These values are listed in specific order as to alternate colors so they are aesthetically pleasing.
 * There are other convenience properties of a <code>Suit</code>. The symbol is a unicode character
 * used to represent the suit. Each suit is inherently associated with a <code>Color</code> (Black or Red).
 *
 * @author  Frijolie
 * @version 0.1
 * @since   0.1
 * @see     Card
 * @see     Color
 */
public enum Suit {

  CLUBS("Clubs", '\u2663', Color.BLACK),
  DIAMONDS("Diamonds", '\u2666', Color.RED),
  SPADES("Spades", '\u2660', Color.BLACK),
  HEARTS("Hearts", '\u2764', Color.RED);

  private final String name;
  private final char symbol;
  private final Color color;

  /**
   * Suit constructor. Used to instantiate constant values.
   *
   * @param name  a word used to represent the constant value
   * @param symbol  a unicode character used to represent the suit
   * @param color an enumerated Color value (Black or Red)
   * @see   Color
   */
  Suit(final String name, final char symbol, final Color color) {
    this.name = name;
    this.symbol = symbol;
    this.color = color;
  }

  /**
   * An accessor method to retrieve the Suit symbol.
   *
   * @return  the unicode character which represents the Suit symbol
   * @since   0.1
   */
  public char getSymbol() {
    return symbol;
  }

  /**
   * An accessor method to retrieve the Suit Color enumerated value
   *
   * @return  the value of the Color enumerated value (Black or Red)
   * @since   0.1
   */
  public Color getColor() {
    return color;
  }

  /**
   * A method which returns a String representation of a Suit value.
   *
   * @return  a word used to represent the Suit constant value
   * @since   0.1
   */
  @Override
  public String toString() {
    return name;
  }

}