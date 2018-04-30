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
 * Deck is used to represent a collection of classic playing cards.
 *
 * <p>A default deck is populated with 52 playing cards.
 *
 * @author Frijolie
 * @version 0.1
 * @since 0.1
 * @see     Card
 * @see     Rank
 * @see     Suit
 */
public class Deck {

  private boolean isShuffled;
  private List<Card> deck;

  /**
   * Default constructor. Will initialize the collection with a single deck of 52 cards
   *
   * @since 0.1
   */
  public Deck() {
    this(1);
  }

  /**
   * Overloaded constructor. Will initialize the collection with multiple decks of cards
   *
   * @param numberOfDecks an integer value to represent the number of decks to initialize
   * @since 0.1
   */
  public Deck(int numberOfDecks) {
    deck = new ArrayList<>();
    clearDeck();
    for (int i = 0; i < numberOfDecks; i++) {
      populateDeck();
    }
  }

  /**
   * A method to shuffle the collection. By default, will shuffle only once.
   *
   * @since 0.1
   */
  public void shuffle() {
    shuffle(1);
  }

  /**
   * Overloaded shuffle method. Will accept input to shuffle multiple times.
   *
   * @param numberOfTimes the amount of times to shuffle the collection
   * @since 0.1
   */
  public void shuffle(int numberOfTimes) {
    isShuffled = true;
    for (int i = 0; i < numberOfTimes; i++) {
      Collections.shuffle(deck);
    }
  }

  /**
   * A method which returns a boolean value indicating if the collection has been shuffled.
   *
   * @return <code>true</code> if the collection has ever been shuffled
   * @since 0.1
   */
  public boolean isShuffled() {
    return isShuffled;
  }

  /**
   * A method which returns a value representing the number of cards remaining in the deck.
   *
   * @return the number of cards remaining in the deck
   * @see 0.1
   */
  public int numberOfCards() {
    return deck.size();
  }

  /**
   * A method to remove a card from the deck.
   *
   * @param card the card to remove from the deck
   * @return the card which has been removed from the deck
   * @see Card
   * @since 0.1
   */
  public Card removeCard(Card card) {
    if (deck.contains(Objects.requireNonNull(card))) {
      int index = deck.indexOf(card);
      return deck.remove(index);
    } else {
      return null;
    }
  }

  /**
   * A method to determine if a certain card is contained in the deck
   *
   * @param card the card to check if it resides in the deck
   * @return <code>true</code> if the card is in the deck
   * @since 0.1
   */
  public boolean containsCard(Card card) {
    return deck.contains(Objects.requireNonNull(card));
  }

  /**
   * A method to populate the deck with all possible 52 cards.
   *
   * @see Card
   * @since 0.1
   */
  public void populateDeck() {
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        deck.add(new PlayingCard(rank, suit));
      }
    }
  }

  /**
   * A method to remove all cards from the deck.
   *
   * @since 0.1
   */
  public void clearDeck() {
    deck.clear();
  }

  /**
   * An abstract method to return a generic collection.
   *
   * @return the collection of cards (deck)
   * @since 0.1
   */
  public Collection<Card> getCollection() {
    return deck;
  }

}