355. Design Twitter

/*

Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);
*/

private static int timestamp = 0;

    public class Tweet {
         public int id;
         public int time;
         public Tweet next;
         public Tweet(int id) {
             this.id = id;
             time = timestamp++;
             next = null;
         }
    }
 
    public class User{
        public int id;
        public Set<Integer> followed;
        public Tweet head;
        
        public User(int id){
            this.id = id;
            followed = new HashSet<Integer>();
            head = null;
            followed.add(id);
        }
        public void follow(int id){
            followed.add(id);
        }
        public void unfollow(int id){
            followed.remove(id);
        }
        public void post(int id){
            Tweet t = new Tweet(id);
            t.next = head;
            head = t;
        }
    }
    
    private Map<Integer, User> userMap;
    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<Integer, User>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)){
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<Integer>();
        if (!userMap.containsKey(userId)){
            return list;
        }
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(new Comparator<Tweet>(){
            public int compare(Tweet a, Tweet b){
                return b.time - a.time;
            }
        });
        for (int user : users){
            Tweet t = userMap.get(user).head;
            if (t != null){
                pq.offer(t);
            }
        }
        int count = 0;
        while (!pq.isEmpty() && count < 10){
            count++;
            Tweet t = pq.poll();
            list.add(t.id);
            if (t.next != null){
                pq.offer(t.next);
            }
        }
        return list;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)){
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)){
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId){
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }