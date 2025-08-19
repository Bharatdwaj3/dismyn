import java.util.*;

public class Twitter {
    private Map<Integer, List<int[]>> tweets;
    private Map<Integer, Set<Integer>> follows;
    private int time;

    public Twitter() {
        tweets = new HashMap<>();
        follows = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        follows.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for (int followee : follows.get(userId)) {
            List<int[]> userTweets = tweets.getOrDefault(followee, new ArrayList<>());
            for (int[] tweet : userTweets) maxHeap.offer(tweet);
        }
        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty() && result.size() < 10) {
            result.add(maxHeap.poll()[1]);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            follows.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println("News Feed: " + twitter.getNewsFeed(1));
    }
}