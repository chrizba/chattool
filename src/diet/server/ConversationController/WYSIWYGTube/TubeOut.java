/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diet.server.ConversationController.WYSIWYGTube;

import diet.server.ConversationController.WYSIWYGTube.Content.TubeFakeInsertedText;
import diet.server.ConversationController.WYSIWYGTube.Content.TubeControlFakeDelay;
import diet.message.MessageWYSIWYGDocumentSyncFromClientInsert;
import diet.server.ConversationController.Dyadic_WYSIWYGInterface_Manipulation;
import diet.server.Participant;
import java.util.Date;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author LX1C
 */
public class TubeOut extends Thread{

   
    
        public int maxDelayBetweenCharactersWhenFlushingBufferPostIntervention = 300;
        public int minDelayBetweenCharactersWhenFlushingBufferPostIntervention = 50;

    public int getMaxDelayBetweenCharactersWhenFlushingBufferPostIntervention() {
        return maxDelayBetweenCharactersWhenFlushingBufferPostIntervention;
    }

    public void setMaxDelayBetweenCharactersWhenFlushingBufferPostIntervention(int maxDelayBetweenCharactersWhenFlushingBufferPostIntervention) {
        this.maxDelayBetweenCharactersWhenFlushingBufferPostIntervention = maxDelayBetweenCharactersWhenFlushingBufferPostIntervention;
    }

    public int getMinDelayBetweenCharactersWhenFlushingBufferPostIntervention() {
        return minDelayBetweenCharactersWhenFlushingBufferPostIntervention;
    }

    public void setMinDelayBetweenCharactersWhenFlushingBufferPostIntervention(int minDelayBetweenCharactersWhenFlushingBufferPostIntervention) {
        this.minDelayBetweenCharactersWhenFlushingBufferPostIntervention = minDelayBetweenCharactersWhenFlushingBufferPostIntervention;
    }
         
    
    
    
         public Vector incoming = new Vector();
         public Vector<Participant> incoming_senders = new Vector();
         
         
         public Dyadic_WYSIWYGInterface_Manipulation dw;
         //Hashtable<MessageWYSIWYGDocumentSyncFromClientInsert,Participant> ht = new Hashtable();
         
    
         
         
         
         public TubeOut(Dyadic_WYSIWYGInterface_Manipulation dw){
             this.dw=dw;
             this.start();
         }
         
         public synchronized void add(Participant sender, MessageWYSIWYGDocumentSyncFromClientInsert mWYSIWYGInsert){
             incoming.addElement( mWYSIWYGInsert);
             incoming_senders.add(sender);
             
             //ht.put(mWYSIWYGInsert, sender);
             notifyAll();
         }
         
         public synchronized void addFakeTurn( TubeFakeInsertedText wfi){
              incoming.addElement( wfi);
              incoming_senders.add(new Participant(null,"server","server")); //This is a hack!  
         }
         
         
         
         public void run(){
             doloop();
         }
         
         
         boolean processingintervention=false;
         
         Random r = new Random();
         private synchronized void doloop(){
             while(2<5){
                 try{
                     wait(); 
                     System.err.println("CHECKING TO SEE IF BIGGER THAN 0");
                     while (incoming.size()>0){
                         System.err.println("BIGGER THAN");
                         Object o = incoming.elementAt(0);
                         if(o instanceof  MessageWYSIWYGDocumentSyncFromClientInsert){
                              boolean textIsFirstTextAfterIntervention = false;
                              if(processingintervention)textIsFirstTextAfterIntervention=true;
                              processingintervention=false;
                              
                              
                              MessageWYSIWYGDocumentSyncFromClientInsert mWYSIWYGInsert = (MessageWYSIWYGDocumentSyncFromClientInsert)o;
                              Participant sender = this.incoming_senders.elementAt(0);
                             
                              System.err.println(mWYSIWYGInsert.getTimeOfReceipt());
                              
                              
                              dw.processWYSIWYGTextInserted_AfterManipulationByQueue(sender, mWYSIWYGInsert);
                              incoming.removeElementAt(0);
                              incoming_senders.removeElementAt(0);
                              
                              if(textIsFirstTextAfterIntervention){
                                  Vector newIncoming = new Vector();
                                  Vector newIncoming_senders = new Vector();
                             
                                  for(int i=0; i < incoming.size();i++){
                                     newIncoming.add(incoming.elementAt(i));
                                     newIncoming_senders.add(incoming_senders.elementAt(i));                                 
                                     long gap =(long) this.minDelayBetweenCharactersWhenFlushingBufferPostIntervention+ r.nextInt(this.maxDelayBetweenCharactersWhenFlushingBufferPostIntervention-this.minDelayBetweenCharactersWhenFlushingBufferPostIntervention);
                                     
                                     TubeControlFakeDelay fd = new TubeControlFakeDelay();
                                     fd.delay=gap;
                                     newIncoming.add(fd);
                                     newIncoming_senders.add(new Participant(null,"server","server")); //This is a hack!  
                                     
                                  
                                 }
                                 this.incoming=newIncoming;
                                 this.incoming_senders=newIncoming_senders;
                                 //System.exit(-56678);
                              }
                              
                              
                         }
                         else if (o instanceof TubeFakeInsertedText ){
                             processingintervention=true;
                             //System.exit(-567);
                             TubeFakeInsertedText wfi = (TubeFakeInsertedText )o;
                             long wakeUpTime = new Date().getTime()+wfi.delayBeforeSending;
                             
                             try{
                                  while(new Date().getTime()<wakeUpTime){
                                      long timeRemaining = wakeUpTime-new Date().getTime();
                                      if(timeRemaining<1)timeRemaining=1;
                                      wait(timeRemaining);
                                  }
                                 
                                 
                             }catch(Exception e){
                                 e.printStackTrace();
                             }
                             
                             
                             dw.processWYSIWYGTextInserted_AfterManipulationByQueue(wfi);
                             incoming.removeElementAt(0);
                             incoming_senders.removeElementAt(0);
                             
                             //Now need to add delays...
                             
                             
                             
                         }
                         else if (o instanceof TubeControlFakeDelay){
                             // System.exit(-567);

                             TubeControlFakeDelay wfd = (TubeControlFakeDelay )o;
                             long wakeUpTime = new Date().getTime()+wfd.delay;
                             
                             try{
                                  while(new Date().getTime()<wakeUpTime){
                                      long timeRemaining = wakeUpTime-new Date().getTime();
                                      if(timeRemaining<1)timeRemaining=1;
                                      //System.exit(-56);
                                      wait(timeRemaining);
                                  }
                                 
                                 
                             }catch(Exception e){
                                 e.printStackTrace();
                             }
                             incoming.removeElementAt(0);
                             incoming_senders.removeElementAt(0);
                         }
                         else{
                             System.err.println(o.getClass().toString());
                         }
                         
                              
                        
                     }
                     
                 }catch(Exception e){
                     e.printStackTrace();
                 }
             }
         }
         
     }

    
