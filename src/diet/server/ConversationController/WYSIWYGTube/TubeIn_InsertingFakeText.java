/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diet.server.ConversationController.WYSIWYGTube;

import diet.server.ConversationController.WYSIWYGTube.Content.TubeFakeInsertedText;
import diet.message.MessageWYSIWYGDocumentSyncFromClientInsert;
import diet.server.ConversationController.Dyadic_WYSIWYGInterface_Manipulation;
import diet.server.ConversationController.ui.CustomDialog;
import diet.server.Participant;
import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author LX1C
 */
public class TubeIn_InsertingFakeText extends Thread implements WYSIWYGTube{
          
         TubeOut to ;
    
    
        // Vector<MessageWYSIWYGDocumentSyncFromClientInsert> incoming = new Vector();
        // Vector<Participant> incoming_senders = new Vector();
         
         
         Hashtable<Participant,Vector> htEachParticipantsText = new Hashtable();
         
         
         public String targetToDetect = "pilot";
         public String query = "Sorry why the pilot?";
         public int interventionMinPreInterventionGap = 1000;
         public int interventionMaxPreInterventionGap = 1500;
         public int interventionMinIntraWordGap =20;
         public int interventionMaxIntraWordGap =300;
         public int interventionMinInterWordGap =150; 
         public int interventionMaxInterWordGap =400; 
         public int postInterventionMaxDelayBetweenCharactersWhenFlushingBuffer = 300;
         public int postInterventionMinDelayBetweenCharactersWhenFlushingBuffer = 50;

         Dyadic_WYSIWYGInterface_Manipulation dw;
         //Hashtable<MessageWYSIWYGDocumentSyncFromClientInsert,Participant> ht = new Hashtable();
         
         public TubeIn_InsertingFakeText(Dyadic_WYSIWYGInterface_Manipulation dw){
             this.dw=dw;
             to=new TubeOut(dw);
             
             boolean dosetup =CustomDialog.getBoolean("Do you want to customize the intervention settings?", "Customize", "Use default");
             if(dosetup)this.doSetup();
             
             
             this.start();
         }
         
         public void doSetup(){
             this.targetToDetect= CustomDialog.getString("Fake turn:\nWhat is the target turn that 'triggers' the fake turn?",  "pilot");
             this.query=CustomDialog.getString("What is the fake turn?", "sorry why the pilot?");
             
            interventionMinPreInterventionGap= CustomDialog.getInteger("Fake turn:\nWhat is minumum response time?\n(Milliseconds after detecting target)", interventionMinPreInterventionGap);
            interventionMaxPreInterventionGap = CustomDialog.getInteger("Fake turn:\nWhat is maximum response time?\n(Milliseconds after detecting target)", interventionMaxPreInterventionGap);
          
            interventionMinIntraWordGap = CustomDialog.getInteger("Fake turn:\nWhat is minumum gap (millisecs) between characters? (Within words)", interventionMinIntraWordGap);
            interventionMaxIntraWordGap = CustomDialog.getInteger("Fake turn:\nWhat is maximum gap (millisecs) between characters? (Within words)", interventionMaxIntraWordGap);
        
            interventionMinInterWordGap = CustomDialog.getInteger("Fake turn:\nWhat is minumum gap (millisecs) between words?", interventionMinIntraWordGap); //Slightly hacky
            interventionMaxInterWordGap = CustomDialog.getInteger("Fake turn:\nWhat is maximum gap (millisecs) between words?", interventionMaxIntraWordGap);  //Slightly hacky
         
            interventionMinInterWordGap = CustomDialog.getInteger("After the intervention there might be text from participants that is buffered\nWhat is minumum gap between characters?", interventionMinInterWordGap); //Slightly hacky
            interventionMaxInterWordGap = CustomDialog.getInteger("After the intervention there might be text from participants that is buffered\nWhat is maximum gap between characters?", interventionMaxInterWordGap); //Slightly hacky
          
            to.setMaxDelayBetweenCharactersWhenFlushingBufferPostIntervention(postInterventionMaxDelayBetweenCharactersWhenFlushingBuffer);
            to.setMinDelayBetweenCharactersWhenFlushingBufferPostIntervention(postInterventionMinDelayBetweenCharactersWhenFlushingBuffer);
            
         }
         
         
         
         public synchronized void add(Participant sender, MessageWYSIWYGDocumentSyncFromClientInsert mWYSIWYGInsert){
             
             this.to.add(sender, mWYSIWYGInsert);
             
             Vector participantsText = this.htEachParticipantsText.get(sender);
             if(participantsText==null){
                 participantsText = new Vector();
                 this.htEachParticipantsText.put(sender,participantsText );
             }
             participantsText.add(mWYSIWYGInsert);
             String targetIdentified = this.detectTarget(sender);
             if(targetIdentified!=null){
                    
                     Participant fakesender =dw.pp.getRecipients(sender).elementAt(0);
                     
                     this.addFakeText(fakesender, query,   this.interventionMinPreInterventionGap, this.interventionMaxPreInterventionGap ,              this.interventionMinIntraWordGap, this.interventionMaxIntraWordGap, this.interventionMinInterWordGap, this.interventionMaxInterWordGap);
                      
                      
                      
                 
             }
             
             notifyAll();
         }
         
         Random r = new Random();
         public void addFakeText(Participant fakeSender, String text,   int minPreInterventionGap ,int maxPreInterventionGap   ,int minIntraWordGap, int maxIntraWordGap, int minInterWordGap, int maxInterWordGap){
             
             if(text==null)return;
             if(text.equalsIgnoreCase(""))return;
             
             
              long gap=0;
              String charc = ""+ text.charAt(0);
              gap = (long)   minPreInterventionGap + r.nextInt(maxPreInterventionGap-minPreInterventionGap);
              TubeFakeInsertedText wfi = new TubeFakeInsertedText(fakeSender,charc);
              wfi.delayBeforeSending=gap;
              this.to.addFakeTurn(wfi);
              
              
             
             for(int i=1;i<text.length();i++){
                 
                 
                 
                 
                 charc = ""+ text.charAt(i);
                gap=0;
                 try{
                 if(!charc.equalsIgnoreCase(" ")){ 
                      gap = (long)   minIntraWordGap + r.nextInt(maxIntraWordGap-minIntraWordGap);
                 }else{
                      gap = (long)   minInterWordGap + r.nextInt(maxInterWordGap- minInterWordGap);
                 }
                 }catch(Exception e){
                     gap=0;
                     e.printStackTrace();
                 }
           
                 wfi = new TubeFakeInsertedText(fakeSender,charc);
                 wfi.delayBeforeSending=gap;
                 this.to.addFakeTurn(wfi);
             }
         }
         
         
         
         
         public String detectTarget(Participant sender){
            
             Vector<MessageWYSIWYGDocumentSyncFromClientInsert> participantsText = this.htEachParticipantsText.get(sender);
             if(participantsText==null)return null;
             String previousText ="";
             for(int i=participantsText.size()-1;i>=0 && i>=participantsText.size()-100;i--){
                 MessageWYSIWYGDocumentSyncFromClientInsert mWYSIWYGInsert = participantsText.elementAt(i);
                 if(mWYSIWYGInsert.getTextTyped().equalsIgnoreCase(" ")) break; // IT JUST DETECTS 
                 previousText = mWYSIWYGInsert.getTextTyped()+previousText;
             }
             if(previousText.endsWith(targetToDetect)){
                 System.err.println("PREVIOUS TEXT IS NONNULL:"+previousText);
                  return targetToDetect;
             }
             System.err.println("PREVIOUS TEXT IS NULL:"+previousText);
             return null;
             
         }
         
         
         public void addIntervention(){
             
         }
         
         
         
         
       
         
     }
