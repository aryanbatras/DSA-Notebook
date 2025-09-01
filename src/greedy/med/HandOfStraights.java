package greedy.med;

public class HandOfStraights {
    // 846. Hand of Straights

    // Unsolved
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if( ( hand.length / groupSize ) >= groupSize) return true;
        else if(hand.length == groupSize) return true;
        else return false;
    }
    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int W = 3;
        System.out.println(new HandOfStraights( ).isNStraightHand(hand, W));
        int[] hand1 = {1, 2, 3, 4, 5};
        int W1 = 4;
        System.out.println(new HandOfStraights( ).isNStraightHand(hand1, W1));
        int[] hand2 = {1, 2, 3, 4, 6};
        int W2 = 3;
        System.out.println(new HandOfStraights( ).isNStraightHand(hand2, W2));
        int[] hand3 = {1, 2, 3, 4, 5};
        int W3 = 4;
        System.out.println(new HandOfStraights( ).isNStraightHand(hand3, W3));
    }
}
