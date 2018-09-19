import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class cho extends JFrame implements ActionListener
{
    private JButton btn;
    boolean [] d = new boolean [10000];
    
    public static void main (String[] args){
        cho demo = new cho ();
        demo.setSize(150, 150);
        demo.createGUI();
        demo.setVisible(true);
    }
    private void createGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );
        
        btn = new JButton ("Do");
        window.add(btn);
        btn.addActionListener(this);        
    }
    public void actionPerformed(ActionEvent event){
        
        String men = "";
        for (int i=0; i<d.length; i++){
            d[i]=true;
        }   
        /*for(int a=2; a<d.length; a++){
            if (a == a/2){
                d[a]=false;
            }else if(){
            }         
        }*/
        for(int i=2; i<d.length; i++){
            if(d[i]==true){
                for(int j = i+i; j<d.length; j+=i){
                    d[j]=false;
                }
            }
        }
        //JOptionPane.showMessageDialog(null, );    
        //imprimir arreglo y que no se salga del tamaño que es.
        for(int i=1; i<d.length; i++){
            if (d[i]==true){
                JOptionPane.showMessageDialog(null, i);
            }
        }
    }
}
