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
 * An enumeration of all possible ranks of a playing Card. Possible values range from Ace to King.
 * <p>These values are listed in ascending order. Along with the constant value, there are other
 * convenience properties of a rank. The name is the full String representation of the constant, the
 * letter is an abbreviated form of the name. The integer value is used for scoring purposes.</p>
 *
 * @author  Frijolie
 * @version 0.1
 * @since   0.1
 * @see     Card
 */
public enum Rank {

  ACE("Ace", "A", 1),
  TWO("Two", "2", 2),
  THREE("Three", "3", 3),
  FOUR("Four", "4", 4),
  FIVE("Five", "5", 5),
  SIX("Six", "6", 6),
  SEVEN("Seven", "7", 7),
  EIGHT("Eight", "8", 8),
  NINE("Nine", "9", 9),
  TEN("Ten", "10", 10),
  JACK("Jack", "J", 10),
  QUEEN("Queen", "Q", 10),
  KING("King", "K", 10);

  private final String name;
  private final String letter;
  private final int value;

  /**
   * Rank enum constructor. Used to instantiate each constant value.
   *
   * @param name    the string representation of the constant value
   * @param letter  an abbreviated form of the name
   * @param value   an integer value of the constant
   * @since 0.1
   */
  Rank(final String name, final String letter, final int value) {
    this.name = name;
    this.letter = letter;
    this.value = value;
  }

  /**
   * Returns a word to represent the Rank constant value.
   *
   * @return  a word representing the constant value. For example, "Queen"
   * @since   0.1
   */
  @Override
  public String toString() {
    return name;
  }

  /**
   * This method returns the int value of the Rank constant.
   *
   * @return  value, in integer form, for the Rank constant
   * @since   0.1
   */
  public final int getValue() {
    return value;
  }

  /**
   * Returns a letter to represent the Rank constant value.
   *
   * @return  a single letter representing the constant value. For example, "Q"
   * @since   0.1
   */
  public final String getLetter() {
    return letter;
  }

}