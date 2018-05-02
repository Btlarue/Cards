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
import java.util.Objects;
import java.util.Stack;

/**
 * The Deck class represents a collection of all possible cards in a deck of playing cards. A standard
 * deck contains 52 cards and does not contain Jokers. The default constructor creates a single deck.
 * An overloaded constructor provides the ability to create more than one deck at instantiation. This
 * class provides means to shuffle the deck one or more times. The deck will also know if it has been
 * shuffled. The deck can also be cleared and repopulated. Purposely there are no methods which allow
 * cards to be added to the deck. Cards may be removed but never added. An unmodifiable collection
 * is returned when requested.
 *
 * @author Frijolie
 * @version 0.1
 * @since 0.1
 * @see     Rank
 * @see     Suit
 */
public class Deck {

  private boolean isShuffled;
  private Stack<Card> deck;

  /**
   * Default constructor. Will initialize the deck with 52 cards
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
    deck = new Stack<>();
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
   * Overloaded shuffle method. Will allow shuffling the deck multiple times
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
   * A method which returns a boolean value indicating if the collection has ever been shuffled.
   *
   * @return  <code>true</code> if the collection has ever been shuffled
   * @since 0.1
   */
  public boolean isShuffled() {
    return isShuffled;
  }

  /**
   * A method which returns a value representing the number of cards remaining in the deck.
   *
   * @return the number of cards remaining in the deck
   * @see     0.1
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
   * A method to determine if a specific card is contained in the deck
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
   * A method to return an unmodifiable collection which represents the deck. All mutations have to
   * be done within the Class which implements the Deck interface.
   *
   * @return the collection of cards (deck)
   * @since 0.1
   */
  public Collection<Card> getUnmodifiableCollection() {
    return new ArrayList<>(deck);
  }

  /**
   * A method to return the first element in the list. Will throw an EmptyStackExcpetion if the
   * deck is empty.
   *
   * @return Card that was removed from the collection
   * @throws java.util.EmptyStackException if the deck is empty
   * @since 0.1
   */
  public Card pop() {
    return deck.pop();
  }

}