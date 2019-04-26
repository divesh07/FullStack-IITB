package designpattern;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

public final class Singleton {
     private static Singleton instance;

     private Singleton(){
     }

     public static Singleton getObject() {
         if ( instance == null) {
             instance = new Singleton();
         }
         return instance;
    }
}

class  Test{
    public static void main(String[] args) {
        Singleton obj = Singleton.getObject();
        Singleton obj2 = Singleton.getObject();

    }
}
