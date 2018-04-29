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
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author Frijolie
 * @version 0.1
 * @since 0.1
 */
public class TestDeck implements Deck {

  private List<Card> deck;
  private boolean isShuffled;

  public TestDeck() {
    isShuffled = false;
    deck = new ArrayList<>();
    deck.clear();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        deck.add(new PlayingCard(rank, suit));
      }
    }
  }

  @Override
  public void shuffle() {
    Collections.shuffle(deck);
    isShuffled = true;
  }

  @Override
  public boolean isShuffled() {
    return isShuffled;
  }

  @Override
  public int numberOfCards() {
    return deck.size();
  }

  @Override
  public Card removeCard(Card card) {
    if (deck.contains(Objects.requireNonNull(card))) {
      int index = deck.indexOf(card);
      return deck.remove(index);
    } else {
      throw new IllegalArgumentException(
          "This card did not exist in the Deck. It cannot be removed");
    }
  }

  @Override
  public Collection<Card> getCollection() {
    return deck;
  }

}