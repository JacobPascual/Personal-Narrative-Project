import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {


    ImageFilter[][] agentImages = {
      {new ImageFilter("jett.png"), new ImageFilter("neon.png"), new ImageFilter("reyna.png"), new ImageFilter("yoru.png")}, 
      {new ImageFilter("skye.png"), new ImageFilter("kayo.png"), new ImageFilter("sova.png"), new ImageFilter("tejo.png")}, 
      {new ImageFilter("astra.png"), new ImageFilter("omen.png"), new ImageFilter("viper.png"), new ImageFilter("brimstone.png")}, 
      {new ImageFilter("sage.png"), new ImageFilter("vyse.png"), new ImageFilter("killjoy.png"), new ImageFilter("chamber.png")}
    };
    ImageFilter[] roleImages = {new ImageFilter("duelist.png"), new ImageFilter("initiator.png"), new ImageFilter("controller.png"), new ImageFilter("sentinel.png")};
    
    Scene j = new Scene();
    myStory nathan = new myStory(agentImages, roleImages);
    
    
    nathan.drawScene();


    

    
    Theater.playScenes(nathan);
  }
}