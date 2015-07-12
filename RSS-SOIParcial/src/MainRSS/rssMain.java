package MainRSS;

import java.util.concurrent.ExecutorService;

import rss.Feed;
import rss.FeedMessage;
import rss.RSSFeedParser;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vanessa
 */
public class rssMain {
    public static void main(String[] args) {
        
        RSSFeedParser parser = new RSSFeedParser("http://www.eluniverso.com/rss/noticias.xml");
        Feed feed = parser.readFeed();
        for (FeedMessage message : feed.getEntries()) {
          System.out.println(message);

        }
    }
}
