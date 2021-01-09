
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Threadlerin Interruptları

InterruptedException hangi durumlarda oluşur?

Threadleri yarıda kesmek isteyeceğimiz durumlar...
*/
public class Main {
    public static void main(String[] args) {
       // List<Integer> list = new LinkedList<Integer>();
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                System.out.println("Thread Çalışıyor");
                for(int i = 0 ;i<10;i++){
                    try {
                        System.out.println("Thread Yazıyor :"+i);
                        
                        Thread.sleep(1000);
                        System.out.println("Uykumun "+i+" nci saniyesindeyim....");
                    } catch (InterruptedException ex) {
                       // Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                       /*
                       Bu Exceptionlar hangi zamanlarda oluşabilirler == 
                       bizim wait() metodumuzdada oluşabiliyordu(hatırlatma)
                       InterruptedException oluşması 2 yol ile gerçekleşir.
                       
                      1) Threadimizi Bilgisayarımız kendi sonlandırıyordur
                      2) Programcı thredi belirli bir süre interrupt'a uğratmak(yarıda kesmek) istiyordur.
                       
                       *Thread uyurken interrupt gelirse thread exceptiona girer.
                       !!!İnterrupt kesinlikle bir threadi bitirmez SADECE O THREADİ YARIDA KESİYOR...
                       Mesela Thread uyuyorsa uyandırıyor,Thread belirli bir yerde bekliyorsa beklediği yerden çıkarıyor.
                       
                       Intterruptlarım değişik yollar ile oluşablirler...
                       */
                        System.out.println("Thread uykusu bölündü");
                    }
                }
            }
        });
        t1.start();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        t1.interrupt();//threadi yarıda kesmek istediğimi ifade ettim bu metod sayesinde.Interrupt çalışmayı öldürmüyor sadece yarıda kesiyor.
        //ben belirli bir interrupt olduğunda threadin çalışmasını tamamen durdurmak istiyorsam = 
        
    }
    
}
