class Twitter {

    private HashMap<Integer, Set<Integer>> followMap; //followerId, <followeeId>
    private HashMap<Integer, List<Tweet>> tweetMap; //userId, <count, tweetIds>
    private int count;
    private static int timestamp = 0;

    //To track when each tweet was posted, so that we can: 
    //Compare tweets across users, 
    //Sort tweets in most-recent-first order (like a Twitter feed).

    private class Tweet{
        int time;
        int id;

        Tweet(int time, int id){
            this.time = time;
            this.id = id;
        }
    }

    private class TweetInfo {
        Tweet tweet;
        int userId;
        int tweetIndex;

        TweetInfo(Tweet tweet, int userId, int tweetIndex) {
            this.tweet = tweet;
            this.userId = userId;
            this.tweetIndex = tweetIndex;
        }
    }





    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k-> new ArrayList<>()).add(new Tweet(++timestamp, tweetId));  
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        PriorityQueue<TweetInfo> maxHeap = new PriorityQueue<>((a, b) -> b.tweet.time - a.tweet.time);

        for(int followeeId : followMap.getOrDefault(userId, new HashSet<>())){
            List<Tweet> tweets = tweetMap.get(followeeId);

            if(tweets!=null && !tweets.isEmpty()){
                int lastInd = tweets.size() - 1;
                maxHeap.offer(new TweetInfo(tweets.get(lastInd), followeeId, lastInd-1));
            }
        }

        while(!maxHeap.isEmpty() && res.size() < 10){
            //It keeps picking the tweet with the latest timestamp from the maxHeap (priority queue)
            TweetInfo info = maxHeap.poll(); 
            
            //Adds that tweet’s ID to your result list.
            res.add(info.tweet.id);

            //If that user has more tweets, it pushes the next one into the heap.
            if(info.tweetIndex >= 0){
                Tweet nextTweet = tweetMap.get(info.userId).get(info.tweetIndex);
                maxHeap.offer(new TweetInfo(nextTweet, info.userId, info.tweetIndex-1));
            }
            //Stops after collecting 10 tweets or when the heap is empty.
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)){
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
        //one liner : 
        //followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);   
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */