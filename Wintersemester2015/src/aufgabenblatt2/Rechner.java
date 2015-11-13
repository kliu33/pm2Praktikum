package aufgabenblatt2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;


/**
 * soll eine simplen Rechner simulieren
 * @author wilhelm
 *
 */
public class Rechner {

  /**
   * Liste mit Operation als Schlüssel und einer Rechenoperation als Wert.
   */
  private Map<Operation,BinaryOperator<Double>> grundrechenarten =
      new HashMap<Operation, BinaryOperator<Double>>();
  
  /**
   * Konstruktor
   */
  public Rechner(){
    grundrechenarten.put(Operation.ADDITION,( x, y)->x+y);
    grundrechenarten.put(Operation.SUBTRAKTION,( x, y)->x-y);
    grundrechenarten.put(Operation.MULTIPLIKATION,( x, y)->x*y);
    grundrechenarten.put(Operation.DIVISION,( x, y)->x/y);
  }
  
  /**
   * Die Methode berechnet abhängig von der Operation das Ergebnis.
   * @param oper  was gerechnet werden soll
   * @param zahl1 1 Zahl
   * @param zahl2  2 Zahl
   * @return Ergebnis der Operation
   */
  public double berechne(Operation oper, double zahl1, double zahl2){
    return  grundrechenarten.get(oper).apply(zahl1, zahl2);
  }
  
  /**
   * main
   * @param args
   *  Kommandozeilenparameter
   */
  public static void main(String []args){
    Rechner rech = new Rechner();
    System.out.println(""+rech.berechne(Operation.DIVISION,3,4.0));
    DoubleDoubleZuDouble lambda1 = (double x, double y)->x*y;
    DoubleDoubleZuDouble lambda2 = (double x, double y)->-(y/x);
    lambda1.werteAus(2, 3);
    System.out.println(lambda1.werteAus(2, 3));

    System.out.println(lambda2.werteAus(2, 3));
  }
}