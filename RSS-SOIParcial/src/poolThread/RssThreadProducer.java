/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poolThread;

import MainRSS.BufferRss;
import static java.lang.Thread.sleep;
import rss.Feed;
import rss.FeedMessage;
import rss.RSSFeedParser;

/**
 *
 * @author Jimmy
 */
public class RssThreadProducer implements Runnable{
    
    private BufferRss bufferP;
    
    private String link;
    private RSSFeedParser parser;
    private Feed feed;
    //private Boolean firstRun;
    private FeedMessage currentFeed;
    private int timeBF;
    
    public RssThreadProducer(BufferRss buffer,String s,int time){
        this.bufferP = buffer;
        this.link=s;
        this.currentFeed= new FeedMessage();
        this.currentFeed.setTitle("");
        this.timeBF=time*1000;
        System.out.println("Comienza prod");
        //this.firstRun=false;
    }
 
    @Override
    public void run() {
        while(true){
            parser = new RSSFeedParser(link);
            feed = parser.readFeed();
            if((currentFeed.getTitle()).compareTo(feed.getEntries().get(0).getTitle())!=0){
                currentFeed = feed.getEntries().get(0);
                bufferP.putDown(currentFeed);
            }
            System.out.println("Producer");
            try{
                sleep(timeBF);
            }
            catch(InterruptedException e){}
//        if(firstRun){
//            for ( FeedMessage f : feed.getEntries()){
//                System.out.println(f.getTitle()+"\n");
//                System.out.println(f.getDescription()+"\n");
//            }
//            firstRun=false;
//        }
//        else{
        }
    }
}
