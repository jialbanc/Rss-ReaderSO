/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poolThread;

import MainRSS.BufferRss;
import MainRSS.noticiasFeed;
import static java.lang.Thread.sleep;
import java.util.Stack;
import javax.swing.JPanel;
import rss.FeedMessage;

/**
 *
 * @author vanessa
 */
public class RssThreadConsumer implements Runnable{
    
    private BufferRss bufferP;
    
    private noticiasFeed panelNoticias;
    private JPanel panelP;
    private Stack stackP;
    private int timeBF;

    
    public RssThreadConsumer(BufferRss buffer, JPanel panel, int time){
        this.bufferP=buffer;
        this.panelP=panel;
        this.timeBF=time*1000;
    }
    
    @Override
    public void run() {
        while(true){
            FeedMessage currentFeed;
            panelNoticias = new noticiasFeed();
            currentFeed = bufferP.pickUp();
            panelNoticias.cargarPanel(currentFeed.getTitle(), currentFeed.getDescription());
            panelP.add(panelNoticias);
            panelP.updateUI();
            System.out.println("Consumer");
            try{
                sleep(timeBF);
                
            }
            catch(InterruptedException e){}
        }
    }
 
}
