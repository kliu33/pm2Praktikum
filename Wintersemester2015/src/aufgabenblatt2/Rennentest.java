package aufgabenblatt2;

import java.util.LinkedList;
import java.util.List;

public class Rennentest {

  public static void main(String []args){
    List<Rennauto> autoliste = new LinkedList<Rennauto>();
    Rennauto auto1 = new Rennauto(1, 10, "Alonso");
    Rennauto auto2 = new Rennauto(1, 10, "Vettel");
    Rennauto auto3 = new Rennauto(1, 10, "Button");
    autoliste.add(auto1);
    autoliste.add(auto2);
    autoliste.add(auto3);
    Rennsimulation simu = new Rennsimulation(autoliste);
    simu.rennstart();
  }
}
