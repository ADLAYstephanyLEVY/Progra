   import javax.swing.*;
import java.awt.*;
import java.util.*;
public class comp{
    public static void main (String [] args){
        Hashtable<String, Integer> dicc = new Hashtable<String, Integer>();
        int num=0;
        String t = JOptionPane.showInputDialog("Ingresa letras: ");
        /* capturar texto, crear diccionario inicial, ciclo para letras del 97 a 122, 
        si en el texto está la letra, meter en el diccionario(letra, valor),aumeta el valor*/
        
        for(int i=97; i<=122; i++){         
            //String letra = t.indexOf(i);
            if(t.indexOf(i)>=0){
                dicc.put(" "+ (char)i, num);
                num++;
            }            
        }
        System.out.println(dicc);
        String nuevo="";
        int a;
        for(int i=0;i<t.length();i++){
            char letra=t.charAt(i);
            nuevo+=letra;
            
             if(!dicc.containsKey(nuevo)){
                dicc.put(nuevo,num);
                System.out.print(nuevo+",");
                nuevo="";
                num++;
                i--;
            }else if(dicc.containsKey(nuevo)){
                a = dicc.get(nuevo);
            }
        }
        System.out.println(dicc);
        /*int valor=0, a=0;
        for(int i=0; i<key.length(); i++){
             a=key.indexOf(i);
            if(!dicc.contains(a)){
                dicc.put(Integer.toString(a), valor);
            }           
            valor++;

        }
        System.out.println("Diccionario: "+dicc);

        /*for(int j=0; j<key.length; j++){
        String letras = Integer.toString(key.indexOf(j));
        if(diccionario.containsKey(letras)){
        Srring dada = diccionario.get(letras);
        }
        }

        /*recorrer todo el texto
         *  tomar la letra y formar prefijos
         *      si el prefijo esta en el las llaves del diccionario
         *          variable le asignas el valor del key buscado
         *              si la encuentro posicion++
         *              si nono le hago pos´´ para que e ¿¿se quede en la misma poscion y 
         *              agregamos al dicionario el valor del prefijo(prefijo, valor)
         *              valor++;
         *              al comprimidio agregar el num 
         *              num le asigno -1
         *              limpiar prefijo
         */
        //int value = 0;
        //ArrayList <Integer> c = new ArrayList<Integer>();
        /*String letras = " ";

        for(int j=0; j<key.length(); j++){
        int c=key.indexOf(j);
        if(c>)
        letras = Integer.toString(key.indexOf(j));

        if(diccionario.containsKey()){
        diccionario.get(d)=value;                //j++;
        }else {
        c.add(value);
        diccionario.put(d,value);                                
        }
        value++;

        }
        while(value!=0){
        c.add(value);
        }/*/
        //imptimir diccionario y comprimido
        //System.out.println(diccionario);
        //System.out.print(comp);
    }

}
