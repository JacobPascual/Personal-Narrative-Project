import org.code.theater.*;
import org.code.media.*;

public class myStory extends Scene{
  
  private static String[] CLASS = {"Duelist", "Initiator", "Controller", "Sentinal"};
  
  private static String[][] AGENTS = {
    {"Jett", "Neon", "Reyna", "Yoru"},
    {"Skye", "Kayo", "Sova", "Tejo"},
    {"Astra", "Omen", "Viper", "Brimstone"},
    {"Sage", "Vyse", "Killjoy", "Chamber"}
  };


  private ImageFilter[][] agentImages;
  private ImageFilter[] roleImages;
  
  public myStory(ImageFilter[][] agentImages, ImageFilter[] roleImages){
    this.agentImages = agentImages;
    this.roleImages = roleImages;
  }


  //Draws everything
  public void drawScene(){
    
    drawTitle();
    playSound("valSong.wav");
    drawClasses();
    drawDuelists();
    drawInitiators();
    drawControllers();
    drawSentinels();
    drawSpikeScene();
    
    filteredAgents();

    endScene();
    
  }
  /*
   *Draws the initial start screen with the 
   *VALORANT logo and a few text messages
  */
  public void drawTitle(){
    //Clear scene
    clear("red");
    
    //Set text stuff
    setTextHeight(30);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    
    //Draw text/images/sounds
    drawImage("logo.png", 120, 0, 150);
    
    pause(1);
    drawText("5v5 Shooter", 100, 142);
    pause(1);
    drawText("Very Fun!", 110, 182);
    pause(1);
    drawText("Free!", 145, 222);
    pause(2);
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextColor("black");
    drawText("Learn more!", 130, 350, -30);
    
    //Pause
    pause(1);
  }

  /*
  *Draws the  four roles in valorant: 
  *Duelist, Controller, Initiator, Sentinel
  *by referencing the roleImages array. 
  *Also 
  */
  public void drawClasses(){
    clear("red");

    setTextHeight(15);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);

    drawImage(roleImages[0], 18, 18, 150);
    
    pause(1);
    drawImage(roleImages[1], 230, 18, 150);
    
    pause(1);
    drawImage(roleImages[2], 18, 245, 150);
    
    pause(1);
    drawImage(roleImages[3], 230, 245, 150);
    pause(0.5);
    drawText("Pick a role...", 150, 220);

    
    /*
                                              //FILTER #1
    * Pixelates all of the role images
    */
    for(int i = 0; i < roleImages.length; i++){
      roleImages[i].pixelate(10);
    }
    
    drawImage(roleImages[0], 18, 18, 150);
    pause(0.5);
    drawImage(roleImages[1], 230, 18, 150);
    pause(0.5);
    drawImage(roleImages[2], 18, 245, 150);
    pause(0.5);
    drawImage(roleImages[3], 230, 245, 150);
    pause(1);
  }

  //Draws the duelist images in all four corners of the screen
  public void drawDuelists(){
    clear("gray");

    setTextHeight(15);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);

    // add sound
    
    drawImage(agentImages[0][0], 18, 18, 130);
    drawText("Jett", 100, 40);
    
    pause(0.5);
    drawImage(agentImages[0][1], 230, 18, 130);
    drawText("Neon", 234, 40);
    
    pause(0.5);
    drawImage(agentImages[0][2], 18, 245, 120);
    drawText("Reyna", 20, 360);
    
    pause(0.5);
    drawImage(agentImages[0][3], 230, 240, 130);
    drawText("Yoru", 236, 269);
    
    pause(1); 
    drawText("Duelists", 150, 220);
    pause(1);


  }
  
  //Draws the initiator images in all four corners of the screen
  public void drawInitiators(){
    clear("gray");

    // add sound
    
    setTextHeight(15);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);

    drawImage(agentImages[1][0], 18, 18, 130);
    drawText("Skye", 25, 52);
    
    pause(0.5);
    drawImage(agentImages[1][1], 230, 18, 130);
    drawText("Kayo", 234, 40);
    
    pause(0.5);
    drawImage(agentImages[1][2], 18, 245, 120);
    drawText("Sova", 96, 265);
    
    pause(0.5);
    drawImage(agentImages[1][3], 230, 240, 130);
    drawText("Tejo", 236, 269);
    
    pause(1); 
    drawText("Initiators", 150, 220);
    pause(1);


  }
  
  //Draws the controllers images in all four corners of the screen
  public void drawControllers(){
    clear("gray");

    // add sound
    
    setTextHeight(15);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);

    drawImage(agentImages[2][0], 18, 18, 130);
    drawText("Astra", 20, 48);
    
    pause(0.5);
    drawImage(agentImages[2][1], 230, 18, 130);
    drawText("Omen", 234, 40);
    
    pause(0.5);
    drawImage(agentImages[2][2], 18, 245, 120);
    drawText("Viper", 92, 265);
    
    pause(0.5);
    drawImage(agentImages[2][3], 230, 240, 130);
    drawText("Brimstone", 236, 380);
    
    pause(1); 
    drawText("Controllers", 150, 220);
    pause(1);

 
  }
  
  //Draws the sentinels images in all four corners of the screen
  public void drawSentinels(){
    clear("gray");

    // add sound
    
    setTextHeight(15);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);

    drawImage(agentImages[3][0], 18, 18, 130);
    drawText("Sage", 111, 35);
    
    pause(0.5);
    drawImage(agentImages[3][1], 230, 18, 130);
    drawText("Vyse", 232, 190);
    
    pause(0.5);
    drawImage(agentImages[3][2], 18, 245, 120);
    drawText("Killjoy", 24, 256);
    
    pause(0.5);
    drawImage(agentImages[3][3], 230, 240, 130);
    drawText("Chamber", 236, 254);
    
    pause(1); 
    drawText("Sentinels", 150, 220);
    pause(1);
  }
  
  /*
  *Draws the spike image and then randomly displays
  *the String "*beep*" across the screen using the randomBeeps() method. 
  *Filters the spike image using explodeSpike() to imitate an 
  *"explosion"
  */
  public void drawSpikeScene(){
    clear("white");
    ImageFilter j = new ImageFilter("spikeplanted.png");
    setTextHeight(20);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);

    drawImage(j, 0, 0, 400);
    drawText("Oh no! They planted the Spike!", 31, 34);
    pause(0.5);
    setTextHeight(15);
    drawText("Quickly! Hold 4 to defuse", 12, 71);
    pause(2);


    drawImage(j, 0, 0, 400);
    setTextHeight(30);
    pause(1);
    
    randomBeeps();


    setTextHeight(15);
                                              //FILTER #2 (STUDENT CREATED)
    j.explodeSpike(120);
                                              //FILTER #3
    j.motionBlur(15, "horizontal");
    drawImage(j, 0, 0, 400);
     
    drawText("You failed :(   it exploded...", 31, 34);
    pause(3);
  }
  
  /*
  *Filters the agentImages array using the 
  *corresponding names in the AGENTS array; 
  *if the images name in AGENTS is greater than or equal to 5,
  *the threshold filter will be applied to the image. 
  *If not, a motion blur filter will be applied
  */
  public void filteredAgents(){
    for(int r = 0; r < AGENTS.length; r++){
      for(int c = 0; c < AGENTS[0].length; c++){
        if(AGENTS[r][c].length() >= 5){
                                                        //FILTER #4
          agentImages[r][c].threshold(150);
        }else{
                                                        //FILTER #5
          agentImages[r][c].motionBlur(10, "diagonal");
        }
      }
    }
    clear("white");

    setTextHeight(20);
    setTextColor("black");
    setTextStyle(Font.MONO, FontStyle.BOLD);

    drawText("Here are the", 10, 250);
    drawText("agents through a filter", 10, 300);
    pause(1);
    drawDuelists();
    drawInitiators();
    drawControllers();
    drawSentinels();
    pause(1);
  }
  
  /*
  *Clears the background to white and displays "the end",
  *then draws the flash image
  */
  public void endScene(){
    pause(0.5);
    setTextColor("black");
    clear("white");
    drawText("the end", 180, 200);
    pause(1);
    drawImage("image_2025-01-30_212304639.png", 0, 0, 400);
    drawImage("image_2025-01-30_212304639.png", 0, 288, 400);
  }

  /*
  * Randomly draws the text "*beep*" across the screen with random rotations
  */
  public void randomBeeps(){
    drawText("*beep*", 200, 34, -20);
    pause(1);
    drawText("*beep*", 90, 150, -46);
    pause(1);
    drawText("*beep*", 256, 300, 50);
    pause(1);
    drawText("*beep*", 53, 340, -65);
    pause(1);
    drawText("*beep*", 302, 353, -150);
    pause(1);
    drawText("*beep*", 215, 185, 455);
    pause(1);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.5);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.5);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.5);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.5);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.5);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.5);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.25);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.25);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.25);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.25);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.11);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.11);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.11);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.11);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.11);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.11);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.11);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.11);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.11);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.11);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.05);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.05);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.05);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.05);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.05);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.05);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.05);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.05);
    drawText("*beep*", (int)(Math.random()*400), (int)(Math.random()*400), (int)(Math.random()*360));
    pause(0.05);
  }

}//Ending bracket