public class MaxPointsFromCards {
    static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        for (int i = 0; i < k; i++) {
            total += cardPoints[i];
        }

        int max = total;
        for (int i = 0; i < k; i++) {
            total -= cardPoints[k - 1 - i];
            total += cardPoints[n - 1 - i];
            max = Math.max(max, total);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println("Max points from cards: " + maxScore(cardPoints, k));
    }
}