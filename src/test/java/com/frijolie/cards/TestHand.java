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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author Frijolie
 * @version 0.1
 * @since 0.1
 */
public class TestHand implements Hand {

  private List<Card> hand;
  private int handValue;

  public TestHand() {
    hand = new ArrayList<>();
  }

  public void sortBySuit() {
    hand.sort((Card first, Card second) -> first.getSuit().compareTo(second.getSuit()));
  }

  public void sortByColor() {
    hand.sort((Card first, Card second) -> first.getSuit().getColor()
        .compareTo(second.getSuit().getColor()));
  }

  public void sortByRank() {
    hand.sort((Card first, Card second) -> first.getRank().compareTo(second.getRank()));
  }

  public void sort() {
    hand.sort((Card first, Card second) -> first.compareTo(second));
  }

  @Override
  public void addCard(Card card) {
    hand.add(Objects.requireNonNull(card));
  }

  @Override
  public Card removeCard(Card card) {
    if (hand.contains(Objects.requireNonNull(card))) {
      int index = hand.indexOf(card);
      return hand.remove(index);
    } else {
      throw new IllegalArgumentException(
          "This card did not exist in the hand. It cannot be removed");
    }
  }

  @Override
  public void displayHand() {
    System.out.println(hand);
  }

  @Override
  public int calculateValue() {
    for (Card card : hand) {
      handValue += card.getRank().getValue();
    }
    return handValue;
  }


  @Override
  public void clearHand() {
    hand.clear();
  }


  @Override
  public int numberOfCards() {
    return hand.size();
  }


  @Override
  public Collection<Card> getCollection() {
    return hand;
  }

  @Override
  public int compareTo(Hand otherHand) {
    return this.calculateValue() - otherHand.calculateValue();
  }

}