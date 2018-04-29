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
 * An enumeration to list all possible values of a <code>Color</code> in a <code>Suit</code>.
 *
 * <p>Values are Black or Red. These are assigned to every <code>Suit</code></p>.
 *
 * @author  Frijolie
 * @version 0.1
 * @since   0.1
 * @see     Card
 * @see     Suit
 */
public enum Color {

  RED("Red"),
  BLACK("Black");

  private final String name;

  /**
   * Enumeration constructor. Used to instantiate enumeration constant with a String value.
   *
   * @param name a word used to represent the enumeration value
   * @since 0.1
   */
  Color(final String name) {
    this.name = name;
  }

  /**
   * An accessor method used to return the representation of the enumeration value in the form of a string.
   *
   * @return  a word used to represent the enumeration value of a Color
   * @since   0.1
   */
  @Override
  public String toString() {
    return name;
  }

}