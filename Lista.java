 


/**
 * Write a description of class Lista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Queue;
import java.util.LinkedList;
public class Lista
{
    private Nodo raiz;
    
    //Cosntructors
    public Lista(){
        raiz=null;
    }
    public Lista(Nodo raiz){
        this.raiz=raiz;
    }
    
    //Getter y Setter
    public Nodo getRaiz(){
        return raiz;
    }
    public void setRaiz(Nodo raiz){
        this.raiz=raiz;
    }
    
    //Metodo para agregar
    
    //****************** AGREGAR POR NODO Y SIN CREAR UN NODO *****************************************
    
    public void agregar(int x,Object y){
        Nodo nod=new Nodo(x,y);
        
        if(raiz==null){
            raiz=nod;
        }
        else{
            Nodo tmp=buscar(x,raiz);
            //Nodo tmp=raiz;
            if(tmp.getNum()==x){
                tmp.setValor(nod.getValor());
            }
            else if(x<tmp.getNum()){
                tmp.setIzquierda(nod);
            }
            else if(x>tmp.getNum()){
                tmp.setDerecha(nod);
            }
        }
        
    }
      public void agregar(Nodo x){
        if(raiz==null){
            raiz=x;
        }
        else{
            Nodo tmp=buscar(x.getNum(),raiz);
            //Nodo tmp=raiz;
            if(tmp.getNum()==x.getNum()){
                tmp.setValor(x.getValor());
            }
            else if(x.getNum()<tmp.getNum()){
                tmp.setIzquierda(x);
            }
            else if(x.getNum()>tmp.getNum()){
                tmp.setDerecha(x);
            }
        }
        
    }
    
    //******************ELIMINAR POR NODO Y POR KEY********************************
    
    public Nodo eliminar(Nodo x){
        Nodo tmp=buscar(x.getNum(),raiz);
        //Es una hoja
        if(tmp.getIzquierda()==null &&  tmp.getDerecha()==null){
            if(x==raiz){
                x=null;
            }
            else{
                Nodo padre=dad(x,raiz);
                if(padre.getIzquierda()==x){
                    padre.setIzquierda(null);
                }
                else{
                    padre.setDerecha(null);
                }
            }
        }
        else if(tmp.getIzquierda()==null && tmp.getDerecha()!=null){
             if(tmp==raiz){
                raiz=tmp.getDerecha();
                tmp.setDerecha(null);
            }
            else{
                Nodo padre=dad(tmp,raiz);
                if(padre.getIzquierda()==tmp){
                    padre.setIzquierda(tmp.getDerecha());
                }
                else{
                    padre.setDerecha(tmp.getDerecha());
                }
                tmp.setDerecha(null);
            }
        }
        else if(tmp.getIzquierda()!=null && tmp.getDerecha()==null){
            if(tmp==raiz){
                raiz=tmp.getIzquierda();
                tmp.setIzquierda(null);
            }
            else{
                Nodo padre=dad(tmp,raiz);
                if(padre.getIzquierda()==tmp){
                    padre.setIzquierda(tmp.getIzquierda());
                }
                else{
                    padre.setDerecha(tmp.getIzquierda());
                }
                tmp.setIzquierda(null);
            }
        }
        else{
            Nodo reemplazo=allLeft(tmp.getDerecha());
            tmp.setNum(reemplazo.getNum());
            tmp.setValor(reemplazo.getValor());
            if(reemplazo.getDerecha()!=null){
                Nodo padre=dad(reemplazo,raiz);
                if(padre.getIzquierda()==reemplazo){
                    padre.setIzquierda(reemplazo.getDerecha());
                }
                else{
                    padre.setDerecha(reemplazo.getDerecha());
                }
            }
            else{
                Nodo padre=dad(reemplazo,raiz);
                if(padre.getIzquierda()==reemplazo){
                    padre.setIzquierda(null);
                }
                else{
                    padre.setDerecha(null);
                }
            }
        }
        
        
        return tmp;
    }
    
    public Nodo eliminar(int k){
        Nodo tmp=buscar(k,raiz);
        //Es una hoja
        if(tmp.getIzquierda()==null && tmp.getDerecha()==null){
            Nodo padre=dad(tmp,raiz);
            if(padre.getIzquierda()==tmp){
                padre.setIzquierda(null);
            }
            else{
                padre.setDerecha(null);
            }
        }
        
        else if(tmp.getIzquierda()==null && tmp.getDerecha()!=null){
            if(tmp==raiz){
                raiz=tmp.getDerecha();
                tmp.setDerecha(null);
            }
            else{
                Nodo padre=dad(tmp,raiz);
                if(padre.getIzquierda()==tmp){
                    padre.setIzquierda(tmp.getDerecha());
                }
                else{
                    padre.setDerecha(tmp.getDerecha());
                }
                tmp.setDerecha(null);
            }
        }
        else if(tmp.getIzquierda()!=null && tmp.getDerecha()==null){
            if(tmp==raiz){
                raiz=tmp.getIzquierda();
                tmp.setIzquierda(null);
            }
            else{
                Nodo padre=dad(tmp,raiz);
                if(padre.getIzquierda()==tmp){
                    padre.setIzquierda(tmp.getIzquierda());
                }
                else{
                    padre.setDerecha(tmp.getIzquierda());
                }
                tmp.setIzquierda(null);
            }
        }
        else{
            Nodo reemplazo=allLeft(tmp.getDerecha());
            tmp.setNum(reemplazo.getNum());
            tmp.setValor(reemplazo.getValor());
            if(reemplazo.getDerecha()!=null){
                Nodo padre=dad(reemplazo,raiz);
                if(padre.getIzquierda()==reemplazo){
                    padre.setIzquierda(reemplazo.getDerecha());
                }
                else{
                    padre.setDerecha(reemplazo.getDerecha());
                }
            }
            else{
                Nodo padre=dad(reemplazo,raiz);
                if(padre.getIzquierda()==reemplazo){
                    padre.setIzquierda(null);
                }
                else{
                    padre.setDerecha(null);
                }
            }
        }
        return tmp;
    }
    
    //************************** 1 a la izquierda todo a la derecha y veiceversa***********************************
    
    private Nodo allLeft(Nodo x){
        if(x.getIzquierda()!=null){
            x=allLeft(x.getIzquierda());
        }
        else{
            return x;
        }
        return x;
    }
    private Nodo allRight(Nodo x){
        if(x.getDerecha()!=null){
            x=allRight(x.getDerecha());
        }
        else{
            return x;
        }
        return x;
    }
    
    //****************** BUSCAR AL PAPÃ?* ********************************
    
    private Nodo dad(Nodo x,Nodo tmp){
        if(tmp.getIzquierda()==x || tmp.getDerecha()==x){
            return tmp;
        }
        else if(tmp.getNum()<x.getNum()){
            if(tmp.getDerecha()!=x){
                tmp=dad(x,tmp.getDerecha());
                //return tmp;
            }
            else{
                return tmp;
            }        
        }
        else if(tmp.getNum()>x.getNum()){
            if(tmp.getIzquierda()!=x){
                tmp=dad(x,tmp.getIzquierda());
                //return tmp;
            }
            else{
                return tmp;
            }
        }
        return tmp;
    }
    
    public Nodo buscar(int k, Nodo tmp){
        if(tmp.getNum()==k){
            return tmp;
        }
        else if(tmp.getNum()<k){
            if(tmp.getDerecha()!=null){
                tmp=buscar(k,tmp.getDerecha());
                //return tmp;
            }
            else{
                return tmp;
            }        
        }
        else if(tmp.getNum()>k){
            if(tmp.getIzquierda()!=null){
                tmp=buscar(k,tmp.getIzquierda());
                //return tmp;
            }
            else{
                return tmp;
            }
        }
        return tmp;
    }
    
    //Imprimir
    //******************* TODOS LOS METODOS PARA IMPRIMIR *******************************************
    public void imprimirNivel(Nodo x){
        Queue <Nodo> cola=new LinkedList <Nodo>();
        do{
            if(x!=null){
                System.out.print(x.getNum()+",");
                if(x.getIzquierda()!=null){
                    cola.offer(x.getIzquierda());
                }
                if(x.getDerecha()!=null){
                    cola.offer(x.getDerecha());
                }
            }
        }while(!cola.isEmpty());
    }
    
    public void imprimirOrden(Nodo x){
        if(x!=null){
            if(x.getIzquierda()!=null){
                imprimirOrden(x.getIzquierda());
            }
            System.out.print(x.getNum());
            if(x.getDerecha()!=null){
                imprimirOrden(x.getDerecha());
            }
        }
    }
    public void imprimirPreOrden(Nodo x){
        if(x!=null){
            System.out.print(x.getNum());
            if(x.getIzquierda()!=null){
                imprimirPreOrden(x.getIzquierda());
            }
            
            if(x.getDerecha()!=null){
                imprimirPreOrden(x.getDerecha());
            }
        }
    }
    public void imprimirPostOrden(Nodo x){
        if(x!=null){
            if(x.getIzquierda()!=null){
                imprimirPostOrden(x.getIzquierda());
            }
            
            if(x.getDerecha()!=null){
                imprimirPostOrden(x.getDerecha());
            }
            System.out.print(x.getNum());
        }
    }
    public void imprimirPreOrden(Nodo x,int n){
        if(x!=null){
            System.out.print(x.getValor());
            if(x.getIzquierda()!=null){
                imprimirPreOrden(x.getIzquierda(),1);
            }
            
            if(x.getDerecha()!=null){
                imprimirPreOrden(x.getDerecha(),1);
            }
            
        }
    }
    
}
