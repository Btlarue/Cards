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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @author Frijolie
 * @version 0.1
 * @since 0.1
 */
public class UnitTestPlayingCard {

  private PlayingCard aceOfHearts;
  private PlayingCard nineOfDiamonds;
  private PlayingCard aceOfSpades;

  @BeforeEach
  void setUp() throws Exception {
    aceOfHearts = new PlayingCard(Rank.ACE, Suit.HEARTS);
    nineOfDiamonds = new PlayingCard(Rank.NINE, Suit.DIAMONDS);
    aceOfSpades = new PlayingCard(Rank.ACE, Suit.SPADES);
  }

  @AfterEach
  void tearDown() throws Exception {
    aceOfHearts = null;
    nineOfDiamonds = null;
    aceOfSpades = null;
  }

  @Test
  @Disabled
  void testDisplayCard() {
    aceOfHearts.displayCard();
    nineOfDiamonds.displayCard();
    aceOfSpades.displayCard();
  }

  @Test
  void testGetSuit_AceOfHeartsSuitShouldBeSuit_HEARTS() {
    assertEquals(aceOfHearts.getSuit(), Suit.HEARTS,
        "Was expecting Suit.HEARTS, instead received: " + aceOfHearts.getSuit());
  }

  @Test
  void testGetColor_AceOfHeartsColorShouldBeColor_Red() {
    assertEquals(aceOfHearts.getColor(), Color.RED,
        "Was expecting Color.RED, instead color was: " + aceOfHearts.getColor());
  }

  @Test
  void testGetRank_AceOfHeartsRankShouldBeACE() {
    assertEquals(aceOfHearts.getRank(), Rank.ACE,
        "Was expecting Rank.ACE, instead rank was: " + aceOfHearts.getRank());
  }

  @Test
  void testToString_AceOfHeartsShouldReturnAce_Of_Hearts() {
    assertEquals(aceOfHearts.toString(), "A(Heart)");
  }

  @Test
  void testGetValue_AceOfHeartsShouldReturnInt_1() {
    assertEquals(aceOfHearts.getValue(), 1);
  }

  @Test
  void testCompareTo_AceOfHeartsComparedToNineOfDiamondsShouldReturnPositive2() {
    // Hearts suit.ordinal = 3, Diamonds suit.ordinal = 1. 3 - 1 = 2. Should return '2'
    assertEquals(aceOfHearts.compareTo(nineOfDiamonds), 2);
  }

  @Test
  void testCompareTo_NineOfDiamondsComparedToAceOfHeartsShouldReturnNegative2() {
    // Diamonds suit.ordinal = 1, Hearts suit.ordinal = 3. 1 - 3 = -2. Should return '-2'
    assertEquals(nineOfDiamonds.compareTo(aceOfHearts), -2);
  }

  @Test
  void testCompareTo_AceOfHeartsComparedToAceOfSpadesShouldReturnPositive1() {
    // Ace has a value of 1. rank is equal (1 = 1). Now need to compare suits.
    // ♥ ordinal + 1 = 4, ♠ ordinal + 1 = 3. ♥(4) > ♠(3). compareTo should return 1
    assertEquals(aceOfHearts.compareTo(aceOfSpades), 1);
  }

  @Test
  void testEquals_AceOfHeartsEqualToAceOfSpacesShouldBeFalse() {
    assertFalse(aceOfHearts.equals(aceOfSpades));
  }

  @Test
  void testEquals_AceOfHeartsEqualToAceOfHeartsShouldBeTrue() {
    assertTrue(aceOfHearts.equals(aceOfHearts));
  }

  @Test
  void testHashCode_AceOfSpadesHashShouldBe372() {
    // ♠ ordinal + 2 = 5. ace ordinal + 3 = 3. (5x3) * 31 = 465
    assertEquals(aceOfSpades.hashCode(), 372);
  }

  @Test
  void testHashCode_AceOfHeartsHashShouldBe465() {
    // ♥ ordinal + 2 = 4. ace ordinal + 3 = 3. (4x3) * 31 = 372
    assertEquals(aceOfHearts.hashCode(), 465);
  }

}