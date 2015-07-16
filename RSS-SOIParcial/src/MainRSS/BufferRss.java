/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainRSS;

import java.util.Stack;
import rss.FeedMessage;

/**
 *
 * @author vanessa
 */
public class BufferRss {
    private Stack stackPrincipal;
    private boolean flagWrite;
    private boolean flagRead;
    
    public BufferRss(){
        stackPrincipal = new Stack();
        flagWrite=false;
        flagRead=true;
    }
    
    public synchronized FeedMessage pickUp(){
        while(!flagWrite){
            try{
                wait();
            }catch(InterruptedException ex){
                
            }
        }
        flagRead=false;
        flagWrite=false;
        notify();
        return (FeedMessage)stackPrincipal.pop();
    }
    
    public synchronized FeedMessage putDown(FeedMessage noti){
        while(flagWrite){
            try{
                wait();
            }catch(InterruptedException ex){
                
            }
        }
        FeedMessage f = (FeedMessage)stackPrincipal.push(noti);
        flagRead=true;
        flagWrite=true;
        notify();
        return f;
    }
}
