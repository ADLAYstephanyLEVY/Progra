    import java.util.*;
public class pepito
{
    public static void main (String [] args){
        LinkedList <Integer> lista = new LinkedList <Integer>();

        for(int i=0; i<20; i++){
            lista.add(((int)(Math.random()*100))+500);
        }
        //int guardado = lista.getFirst();
        int mayor=0;
        int cont=0;
        for(Object guardado : lista){
            if((int)(guardado)>mayor){
                cont++;
                mayor=(int)(guardado);
            }
        }
        
        System.out.println(lista + "\n"+ cont);
    }
}
