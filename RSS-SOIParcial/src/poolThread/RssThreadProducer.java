/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poolThread;

import java.util.EmptyStackException;
import java.util.Stack;
import rss.Feed;
import rss.FeedMessage;
import rss.RSSFeedParser;

/**
 *
 * @author Jimmy
 */
public class RssThreadProducer implements Runnable{

    private String link;
    private RSSFeedParser parser;
    private Feed feed;
    private Boolean firstRun;
    private FeedMessage currentFeed;
    private Stack stackP;
    
    public RssThreadProducer(String s, Stack stack){
        this.link=s;
        this.firstRun=false;
        this.stackP=stack;
    }
 
    @Override
    public void run() {
        refresh();
        if(firstRun){
            for ( FeedMessage f : feed.getEntries()){
                System.out.println(f.getTitle()+"\n");
                System.out.println(f.getDescription()+"\n");
            }
            firstRun=false;
        }
        else{
            currentFeed = feed.getEntries().get(0);
            try{
                stackP.push(currentFeed);
            } catch (EmptyStackException e){
                e.printStackTrace();
            }
                
        }
    }
    
    private void refresh() {
        parser = new RSSFeedParser(link);
        feed = parser.readFeed();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public String toString(){
        return this.link;
    }
    
}
