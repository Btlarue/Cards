package com.frijolie.cards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Hand is a concrete class used to provide behavior of a collection of playing cards in a Player's
 * hand. Cards in the player's hand are traditionally dealt from a deck of cards. There are methods
 * to add and remove cards from the hand. Each hand should have some sort of int value and have the
 * ability to be compared to other similar hands.
 *
 * @author Frijolie
 * @version 0.1
 * @since 0.1
 * @see     PlayingCard
 * @see     Card
 */
public class Hand implements Comparable<Hand> {

  private List<Card> cards;

  public Hand() {
    cards = new ArrayList<>();
  }

  /**
   * A method to add a specific card to the hand.
   *
   * @param card the element to add to the collection
   * @see Card
   */
  public void addCard(Card card) {
    cards.add(Objects.requireNonNull(card));
  }

  /**
   * A method to remove a specific card from the hand.
   *
   * @param card the element to remove from the collection
   * @return the card that was recently removed from the hand
   * @see Card
   * @since 0.1
   */
  public Card removeCard(Card card) {
    if (cards.contains(Objects.requireNonNull(card))) {
      int index = cards.indexOf(card);
      return cards.remove(index);
    } else {
      throw new IllegalArgumentException(
          "This card did not exist in the hand. It cannot be removed");
    }
  }

  /**
   * A method to calculate the cumulative value of all cards in the hand.
   *
   * @return an int value of all the cards in the hand
   * @see Rank#getValue()
   * @since 0.1
   */
  public int calculateValue() {
    var handValue = 0;
    for (Card card : cards) {
      handValue += card.getRank().getValue();
    }
    return handValue;
  }

  /**
   * A method to remove all cards from the hand.
   */
  public void clearHand() {
    cards.clear();
  }

  /**
   * A method to return the number of cards remaining in the hand.
   *
   * @return a count of the number of cards remaining in the hand
   */
  public int numberOfCards() {
    return cards.size();
  }

  /**
   * A method to return an unmodifiable collection representing the hand.
   *
   * @return an unmodifiable collection containing all the elements in the hand.
   */
  public Collection<Card> getUnmodifiableCollection() {
    return Collections.unmodifiableCollection(cards);
  }

  /**
   * A method used to compare one Hand to another.
   *
   * @param otherHand the other Hand being compared
   * @return an int value
   */
  public int compareTo(final Hand otherHand) {
    return this.calculateValue() - otherHand.calculateValue();
  }

  /**
   * A method to sort the cards in the hand by suit. Does not factor rank within the suit. This will
   * sort cards in this order: all clubs, then all diamonds, then spaces, then hearts.
   *
   * @see Suit
   * @see Card#getSuit()
   * @since 0.1
   */
  public void sortBySuit() {
    cards.sort(Comparator.comparing(Card::getSuit));
  }

  /**
   * A method to sort the cards in the hand by color. Does not factor suit within the color. This
   * will sort cards in this order: all red cards, then all black cards.
   *
   * @see CardColor
   * @see Card#getColor()
   * @since 0.1
   */
  public void sortByColor() {
    cards.sort(Comparator.comparing(Card::getColor));
  }

  /**
   * A method to sort all the cards in the hand by Rank in ascending order. This method does not
   * factor suit within the ranks. It will sort cards in this order: A, 2, 3, ..., 10, J, Q, K
   *
   * @see Rank
   * @see Card#getRank()
   * @since 0.1
   */
  public void sortByRank() {
    cards.sort(Comparator.comparing(Card::getRank));
  }

}