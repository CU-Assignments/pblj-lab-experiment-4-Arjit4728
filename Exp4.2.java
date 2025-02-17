Experiment 4.2: Card Collection System

import java.util.*;

class Card {
    String suit;
    String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return Objects.equals(suit, card.suit) && Objects.equals(rank, card.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }
}

public class CardCollectionSystem {
    private static HashMap<String, HashSet<Card>> cardCollection = new HashMap<>();

    public static void addCard(String suit, String rank) {
        cardCollection.putIfAbsent(suit, new HashSet<>());
        Card newCard = new Card(suit, rank);
        if (cardCollection.get(suit).contains(newCard)) {
            System.out.println("Error: Card \"" + rank + " of " + suit + "\" already exists.");
        } else {
            cardCollection.get(suit).add(newCard);
            System.out.println("Card added: " + newCard);
        }
    }

    public static void removeCard(String suit, String rank) {
        if (cardCollection.containsKey(suit) && cardCollection.get(suit).remove(new Card(suit, rank))) {
            System.out.println("Card removed: " + rank + " of " + suit);
        } else {
            System.out.println("Error: Card \"" + rank + " of " + suit + "\" not found.");
        }
    }

    public static void displayCardsBySuit(String suit) {
        if (cardCollection.containsKey(suit) && !cardCollection.get(suit).isEmpty()) {
            System.out.println("Cards of suit " + suit + ": " + cardCollection.get(suit));
        } else {
            System.out.println("No cards found for " + suit + ".");
        }
    }

    public static void displayAllCards() {
        if (cardCollection.isEmpty()) {
            System.out.println("No cards found.");
        } else {
            for (Map.Entry<String, HashSet<Card>> entry : cardCollection.entrySet()) {
                for (Card card : entry.getValue()) {
                    System.out.println(card);
                }
            }
        }
    }

    public static void main(String[] args) {
        
        System.out.println("Test Case 1: Display All Cards (No Cards Initially)");
        displayAllCards();

  
        System.out.println("\nTest Case 2: Adding Cards");
        addCard("Spades", "Ace");
        addCard("Hearts", "King");
        addCard("Diamonds", "10");
        addCard("Clubs", "5");

      
        System.out.println("\nTest Case 3: Finding Cards by Suit");
        displayCardsBySuit("Hearts");

      
        System.out.println("\nTest Case 4: Searching Suit with No Cards");
        displayCardsBySuit("Diamonds");

     
        System.out.println("\nTest Case 5: Displaying All Cards");
        displayAllCards();


        System.out.println("\nTest Case 6: Preventing Duplicate Cards");
        addCard("Hearts", "King");


        System.out.println("\nTest Case 7: Removing a Card");
        removeCard("Diamonds", "10");
    }
}

1. Card Structure:
Each card consists of a symbol (suit) and a value (rank).

Example card representations:
Ace of Spades
King of Hearts
10 of Diamonds
5 of Clubs

2. Operations Required:
Add Cards → Store card details in a collection.
Find Cards by Symbol (Suit) → Retrieve all cards belonging to a specific suit (e.g., all "Hearts").
Display All Cards → Show all stored cards.

3. Collections Usage:
ArrayList: To store cards in an ordered manner.
HashSet: To prevent duplicate cards.
HashMap<String, List<Card>>: To organize cards based on suits for faster lookup.


Test Cases

Test Case 1: No Cards Initially
Input:
Display All Cards
Expected Output:
No cards found.

Test Case 2: Adding Cards
Input:
Add Card: Ace of Spades
Add Card: King of Hearts
Add Card: 10 of Diamonds
Add Card: 5 of Clubs
Expected Output:
Card added: Ace of Spades
Card added: King of Hearts
Card added: 10 of Diamonds
Card added: 5 of Clubs

Test Case 3: Finding Cards by Suit
Input:
Find All Cards of Suit: Hearts
Expected Output:
King of Hearts

Test Case 4: Searching Suit with No Cards
Input:
Find All Cards of Suit: Diamonds
(If no Diamonds were added)
Expected Output:
No cards found for Diamonds.

Test Case 5: Displaying All Cards
Input:
Display All Cards
Expected Output:
Ace of Spades
King of Hearts
10 of Diamonds
5 of Clubs

Test Case 6: Preventing Duplicate Cards
Input:
Add Card: King of Hearts
Expected Output:
Error: Card "King of Hearts" already exists.

Test Case 7: Removing a Card
Input:
Remove Card: 10 of Diamonds
Expected Output:
Card removed: 10 of Diamonds
