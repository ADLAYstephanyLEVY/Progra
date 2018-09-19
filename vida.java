import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class vida extends JFrame implements ActionListener
{
    private JButton sig, fin, play;
    int m [][] = new int [20][20];
    int g [][] = new int [20][20];
    Random azar = new Random ();
    private JPanel panel;
    public static void main (String[] args){
        vida demo = new vida ();
        demo.setSize(500, 500);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel ();
        panel.setPreferredSize(new Dimension(300, 300));
        panel.setBackground(Color.white);
        window.add(panel);

        play = new JButton ("Ejecutar");
        window.add(play);
        play.addActionListener(this);

        sig = new JButton ("Siguiente generación");
        window.add(sig);
        sig.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event){
        Graphics papel = panel.getGraphics ();
        char estrella = '*';
        String mensaje = " ";
        for (int e=0; e<=40; e++){
            int f, c;
            do{
                f = azar.nextInt(20);
                c = azar.nextInt(20);
            } while(m[f][c]=='*');
            m[f][c]= '*';
        }
         papel.setColor(Color.white);
                papel.fillRect(0, 0, 300, 300);
        for(int f=0; f<m.length; f++){
            for(int c=0; c<m[f].length; c++){

                if (m[f][c]==0){
                    mensaje += " " + "   ";

                }/*else if (m[f][c]==42){
                mensaje += "*" + "   ";
                }*/
                else if(m[f][c]==42){
                    int color = azar.nextInt(10);
                    if(color==0){
                        papel.setColor(Color.red);
                    } else if (color==1){
                        papel.setColor(Color.green);
                    }else if (color==2){
                        papel.setColor(Color.blue);
                    } else if (color==3){
                        papel.setColor(Color.magenta);
                    }else if (color==4){
                        papel.setColor(Color.orange);
                    }else if (color==5){
                        papel.setColor(Color.yellow);
                    }else if (color==6){
                        papel.setColor(Color.cyan);
                    }else if (color==7){
                        papel.setColor(Color.gray);
                    }else if (color==8){
                        papel.setColor(Color.lightGray);
                    }else if (color==9){
                        papel.setColor(Color.pink);
                    }
                    int x = azar.nextInt(300);
                    int y = azar.nextInt(300);
                    int z = 5;
                    papel.fillOval(x, y, z, z);
                }

            }
            mensaje += "\n";
        }
        System.out.print(mensaje);

        if(event.getSource() == sig){
            
            for (int i=0; i<m.length; i++){
                for(int j=0; j<m[i].length; j++){
                    int totalVecinos = cuentaVecino(i,j);
                    if(m[i][j]=='*' && totalVecinos==3 || totalVecinos==2){
                        g[i][j]='*';
                    }else if (m[i][j]=='-' && totalVecinos==3){
                        g[i][j]='*';
                    }

                }
            }
            m=g;
            g = new int [100][100];
            
               
            } 
            

        }

    

    public int cuentaVecino(int fil, int col){
        int cont=0;
        for(fil=0; fil<m.length; fil++){
            for(col=0; col<m[fil].length; col++){
                cont=0;
                if(m[fil][col]==0){
                    if (fil-1>=0 && col-1>=0 && m[fil-1][col-1]==42){
                        cont++;
                    }else if(col-1>=0 && m[fil][col-1]==42){
                        cont++;
                    }else if(fil+1<m.length && col-1>=0 && m[fil+1][col-1]==42){
                        cont++;
                    }else if (fil-1>=0 && m[fil-1][col]==42){
                        cont++;
                    }else if (fil+1<m.length && m[fil+1][col]==42){
                        cont++;
                    }else if (fil-1>=0 && col+1<m.length && m[fil-1][col+1]==42){
                        cont++;
                    }else if (col+1<m.length && m[fil][col+1]==42){
                        cont++;
                    }else if (fil+1<m.length && col+1<m.length && m[fil+1][col+1]==42){
                        cont++;
                    }
                }

            }
        }
        return cont;
    }
}

