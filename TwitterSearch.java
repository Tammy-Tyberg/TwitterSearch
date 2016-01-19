package 

import java.util.List;
import java.util.Scanner;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterSearch {
	
	
		Scanner scan;
	

    public static void main(String[] args) {
    	
    	TwitterSearch ts = new TwitterSearch();
 
    			ts.restartSearch();
    			
    			
	
	
	
    }
    
    TwitterSearch(){
    	
    	scan = new Scanner(System.in).useDelimiter("\\n");
    }
    
    void restartSearch(){
    	
    	
    
    	//String searchTerm;
    	System.out.println("Enter search term");
    	searchTwitter(scan.next());
    	//return searchTerm = scan.next();
        
    }
    
    void searchTwitter(String searchTerm){
    	
    	if (searchTerm.length() < 1) {
            System.out.println("java twitter4j.examples.search.SearchTweets [query]");
            System.exit(-1);
        }
        Twitter twitter = new TwitterFactory().getInstance();
        try {
            Query query = new Query(searchTerm);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                	String rTChecker = "RT";
                	if(  tweet.getText().substring(0, 2).equals(rTChecker) ){
                	
                	}else{
                		System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                	}
                }
            } while ((query = result.nextQuery()) != null);
            System.out.println("Want to search a different term? Y or N");
            String c = scan.next();
            if( c.equals("Y") || c.equals("y") ){
            			
            	restartSearch();
            }else{
            	System.out.println("System exiting!");
            	System.exit(0);
            }
            
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    
    }

}
