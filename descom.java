
    import javax.swing.*;
import java.awt.*;
import java.util.*;
public class descom{
    public static void main (char [] args){ 
        Hashtable<Integer, String> dic = new Hashtable<Integer, String>();
        int i=0;
        while(i<=(args.length)/2){
            String letra = Character.toString(args[i]);
            int num = args[i+1]-48;
            dic.put(num, letra);
            i+=2;
        }
        System.out.println(dic);
        String entrada =JOptionPane.showInputDialog("Ingresa compreso: ");
        String [] arr = entrada.split(","); 
        //String entrada = "aaabbbbbbaabaaba";    0,2,1,
        String salida = dic.get(0);
        int value=args.length/2;
        for(int p=1; p<arr.length; p++){
            int q=p-1;
            int letra = Integer.parseInt(arr[p]);
            int atras = Integer.parseInt(arr[q]);
            if(dic.containsKey(letra)){
                //valor de q + primer caracter del valor de p
                String c = dic.get(letra);
                salida+=c;
                char L = dic.get(letra).charAt(0);
                String nuevo = dic.get(atras) + Character.toString(L); 
                dic.put(value, nuevo);
            }else{
                //crear string
                //valor de q + primer caracter del valor de q
                
                char L = (dic.get(atras)).charAt(0);
                String nuevo = dic.get(atras) + Character.toString(L);
                salida+=nuevo;
                dic.put(value, nuevo);
            }
            value++;
        }
        System.out.println("Descompreso: " + salida + dic);
    }
}