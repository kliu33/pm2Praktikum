package aufgabenblatt3;

public class Simulation implements Runnable {
  

  
  private Rangierbahnhof bahnhof;
  
  public Simulation(int anzahlDerGleise) throws IllegalArgumentException{
    if(anzahlDerGleise < 1 || anzahlDerGleise > 6){
      throw new IllegalArgumentException();
    }
     bahnhof = new Rangierbahnhof(anzahlDerGleise);
  }

  @Override
  public void run() {
    
    int gleisnummer =0;
    LokFuehrer lokfuehrer;
    
    while (true) {
      
      if(gleisnummer==bahnhof.getAnzahlDerGleise()){
        gleisnummer = 0;
      }
      
      int zufallszahl = (int) (Math.random() * 2);
      if (zufallszahl == 0) {
        lokfuehrer = new LokFuehrer(new Einfahren(gleisnummer,bahnhof));
      } else {
        lokfuehrer = new LokFuehrer(new Ausfahren(gleisnummer,bahnhof));
      }
      lokfuehrer.start();
      gleisnummer++;
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // Exception - (wird nicht interrupted)
      }
    }
  }
  
  public Rangierbahnhof getBahnhof(){
    return bahnhof;
  }
  


}
