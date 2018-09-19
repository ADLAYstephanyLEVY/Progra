import java.util.*;
public class shit{
    public static void main (String [] args){
        //meter numeros aleatorios de 0 a 1500, hacer dos arrays, despues pasar los numeros
        //del primer array al otro en orden con las respectivas condicones
        //public ArrayList(int arr=100);
      // public ArrayList(int arr2>0 extends arr2<arr);
      ArrayList<Integer> arr = new ArrayList<Integer>();
      
         for (int f=0; f<100; f++){
            int num = (int)(Math.random()*1500);
            //arr.add((int))(Math.random()+1500);
            arr.add(num);  // añadir desde el principio
        }
        //poner la lista dentro del array
        //ArrayList<Integer> arr2 = new ArrayList<Integer>();
        // Pasa el ArrayList a un Array 
        //Object[] array = nombreArrayList.toArray();   
        ArrayList arreglo [] = new ArrayList [100];
        for(int i =0; i<100; i++){
            arreglo[i]= new ArrayList();
        }
        
       for(int i=1; i<4; i++){
             // Devuelve la posición de la primera ocurrencia ('Elemento') 
             //en el ArrayList  
             //nombreArrayList.indexOf("Elemento");
             // Devuelve la posición de la última ocurrencia ('Elemento') 
             //en el ArrayList   
             //nombreArrayList.lastIndexOf("Elemento");
                int valor = arr.remove(arr);
               int rec= arr.get(valor);
            
                if(i==1){
              if (rec<10){
                    arreglo[rec]=arr.add(valor);//(arr.indexOf(valor));//agregar desde el principio
                }else if(valor>=10){
                    int a = rec % 10;
                    arreglo[a]=arr.add(arr.indexOf(valor));//agregar desde el principio
                }
              }
              if(i==2){                                  
                if (rec<10){
                   arreglo[0]=arr.add(valor); //agregar final
                }else if(rec>=10 && rec<100){
                    int a = rec/10;
                    arreglo[a]=arr.add(valor);//agregar final
                }else if(rec>=100 && rec<1000){
                    int a = rec % 100;
                    int b = a/10;
                    arreglo[b]=arr.add(valor);//agregar final
                }else if(rec>=1000 && rec<1501){
                    int a = rec %1000;
                    int b = a % 100;
                    int c = b/10;
                    arreglo[c]=arr.add(value);//agregar final
                }
              }
            if(i==3){
                if(rec>=0 && rec<100){
                    arreglo[0]=arr.add(valor); //agregar fin
                }else if(rec>=100 && rec<1000){
                    int a = rec / 100;
                    arreglo[a]=arr.add(valor);//agregar fin
                }else if(rec>=1000 && rec<1501){
                    int a = rec %1000;
                    int b = a / 100;
                    arreglo[b]=arr.add(valor); //agregar fin
                }
            }
            if(i==4){
                 if (rec>=0 && rec<1000){
                    arreglo[0]=arr.add(valor);//agregar fin
                }else if(rec>=1000 && rec<1501){
                    int a = rec/1000;
                    arreglo[a]=arr.add(valor);//agregar fin
                }
            }
        }
    

    
    for(int f=0; f<arreglo.length; f++){

        while(arreglo[f].get(arr)!=null){
            arr.add(arreglo[f]).remove(arr);
        }

    }
   
    System.out.println();
    }
}	