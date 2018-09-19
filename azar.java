import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
public class azar extends JFrame implements ActionListener {
    private JPanel panel;
    private JButton dato, draw, nuevo, resolver;
    int n;
    Random random = new Random();
    LinkedList <nodo2> celdas = new LinkedList <nodo2>();
    LinkedList <nodo2> vecinos = new LinkedList <nodo2>();
    Stack <nodo2> pila = new Stack <nodo2>();
    int fOrig=0, cOrig=0;
    public static void main(String[] args) { 
        azar a = new azar();
        a.setSize(800, 800); 
        a.createGUI();  
        a.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        Container window = getContentPane(); 
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 600));
        panel.setBackground(Color.white); 
        window.add(panel);

        dato = new JButton("Ingresar medidas del laberinto");
        window.add(dato);
        dato.addActionListener(this);

        draw = new JButton("Nuevo laberinto");
        window.add(draw);
        draw.addActionListener(this);

        resolver = new JButton("Resolver");
        window.add(resolver);
        resolver.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==dato){
            String medidas = JOptionPane.showInputDialog("Ingresa un número: "); 
            n = Integer.parseInt(medidas);
            if(n%2==0){
                n++;
            }
        }
        int [][] m = new int [n][n];

        for(int f=1; f<m.length-1; f++){
            for(int c=1; c<m[f].length-1; c++){                
                if(f%2!=0 && c%2!=0){
                    m[f][c]=3;   
                }
            }   
        }

        for(int f=0; f<m.length; f++){
            for(int c=0; c<m[f].length; c++){
                if(m[f][c]<0){
                    System.out.print("  " + m[f][c]);
                }else if(m[f][c]<10){
                    System.out.print("   " + m[f][c]);
                }else if(m[f][c]<100){
                    System.out.print("  " + m[f][c]);
                }else {
                    System.out.print(" " + m[f][c]);
                }
            }
            System.out.println();
        }
        int row =0;
        int column =0;
        do{     
            row =random.nextInt(m.length);
            column =random.nextInt(m.length);  
        }while(row%2==0 || column%2==0);   
        m[row][column]=2;
        celdas.add(new nodo2(row, column));

        while(celdas.size()!=0){
            int posicion = random.nextInt(celdas.size());
            nodo2 num = celdas.remove(posicion);
            int fila = num.getF();
            int col = num.getC();
            m[fila][col]=1;
            if(fila-2>0 && m[fila-2][col]==3 ){                   
                m[fila-2][col]=2;
                celdas.add(new nodo2 (fila-2, col));             
            }else if(fila-2>0 && m[fila-2][col]==1){
                vecinos.add(new nodo2 (fila-1, col));
            }
            if(col+2<m.length && m[fila][col+2]==3){
                m[fila][col+2]=2;
                celdas.add(new nodo2 (fila, col+2));
            }else if(col+2<m.length && m[fila][col+2]==1){
                vecinos.add(new nodo2 (fila, col+1));
            }          
            if(fila+2<m.length && m[fila+2][col]==3){
                m[fila+2][col]=2;
                celdas.add(new nodo2 (fila+2, col));
            }else if(fila+2<m.length && m[fila+2][col]==1){
                vecinos.add(new nodo2 (fila+1, col));
            } 
            if(col-2>0 && m[fila][col-2]==3 ){                   
                m[fila][col-2]=2;
                celdas.add(new nodo2 (fila, col-2));             
            }else if(col-2>0 && m[fila][col-2]==1){
                vecinos.add(new nodo2 (fila, col-1));
            }             
            while(vecinos.size()!=0){
                int coordenada = random.nextInt(vecinos.size());
                nodo2 guardado = vecinos.remove(coordenada);
                int x = guardado.getF();
                int y = guardado.getC();
                m[x][y]=1;
                vecinos.clear();
            }
        }

        for(int f=0; f<m.length; f++){
            for(int c=0; c<m[f].length; c++){
                if(m[f][c]<0){
                    System.out.print("  " + m[f][c]);
                }else if(m[f][c]<10){
                    System.out.print("   " + m[f][c]);
                }else if(m[f][c]<100){
                    System.out.print("  " + m[f][c]);
                }else {
                    System.out.print(" " + m[f][c]);
                }
            }
            System.out.println();
        }

        Graphics papel = panel.getGraphics();
        if(e.getSource()==draw){
            papel.setColor(Color.white);
            papel.fillRect(0,0,600,600);
            for(int f=0; f<m.length; f++){
                for(int c=0; c<m[f].length; c++){   
                    if(m[f][c]==0){
                        papel.setColor(Color.lightGray);
                        papel.fillRect(c*7,f*7,7,7);
                    }else if(m[f][c]==1){
                        papel.setColor(Color.lightGray);
                        papel.drawRect(c*7,f*7,7,7);
                    }
                }
            }

            for(int i=0; i<2; i++){
                do{     
                    fOrig =random.nextInt(m.length);
                    cOrig =random.nextInt(m.length);  
                }while(fOrig%2==0 || cOrig%2==0);
                m[fOrig][cOrig]=-7;
                papel.setColor(Color.red);
                papel.fillRect(cOrig*7,fOrig*7,7,7);
            }
        }

        if(e.getSource()==resolver){
            pila.push(new nodo2 (fOrig, cOrig));
            nodo2 temp = pila.peek();
            int x = temp.getF();
            int y = temp.getC();
            while(!pila.empty()){  
                System.out.println("Ya entré");
                if( x+1<m.length&&m[x+1][y]==-2 || x-1>=0&&m[x-1][y]==-2 || y-1>=0&&m[x][y-1]==-2 || y+1<m.length&&m[x][y+1]==-2){
                    System.out.println("Encontré la salida");
                    break;
                }
                if( x-1>=0&& m[x-1][y]==1){
                    m[x][y]=5;
                    pila.push(new nodo2(x,y));                    
                    if(m[x][y]==5){
                        papel.setColor(Color.yellow);
                        papel.fillRect(y*7, x*7, 7, 7);
                    }
                    x--;
                }else if( x+1<m.length&& m[x+1][y]==1){
                    m[x][y]=5;
                    pila.push(new nodo2(x,y));
                    if(m[x][y]==5){
                        papel.setColor(Color.yellow);
                        papel.fillRect(y*7, x*7, 7, 7);
                    }  
                    x++;
                }else if( y-1>=0&& m[x][y-1]==1){
                    m[x][y]=5;
                    pila.push(new nodo2(x,y)) ; 
                    if(m[x][y]==5){
                        papel.setColor(Color.yellow);
                        papel.fillRect(y*7, x*7, 7, 7);
                    }
                    y--;
                }else if( y+1<m.length&& m[x][y+1]==1){
                    m[x][y]=5; 
                    pila.push(new nodo2(x,y));
                    if(m[x][y]==5){
                        papel.setColor(Color.yellow);
                        papel.fillRect(y*7, x*7, 7, 7);
                    }
                    y++;
                } else if(!pila.empty()){                   
                    m[x][y]=-3;                  
                    papel.setColor(Color.magenta);
                    papel.fillRect(y*7, x*7, 7, 7);  
                    temp = pila.pop();
                    x = temp.getF();
                    y = temp.getC();
                }
            }
            m[x][y]=5;
            papel.setColor(Color.yellow);
            papel.fillRect(y*7, x*7, 7, 7);
            m[fOrig][cOrig]=-2;
            papel.setColor(Color.red);
            papel.fillRect(cOrig*7, fOrig*7, 7, 7);
        }
    }

}