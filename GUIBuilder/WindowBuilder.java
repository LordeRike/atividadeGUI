import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import helper_classes.CustomFontLoader;
import helper_classes.OnClickEventHelper;
import helper_classes.OnFocusEventHelper;
import helper_classes.RoundedBorder;

public class WindowBuilder {
  public static void main(String[] args) {

    Conselho Conselho = new Conselho(0);
    
     JFrame frame = new JFrame("My Awesome Window");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(897, 485);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#1e1e1e"));

     JLabel textoID = new JLabel("Informe o ID do conselho:");
     textoID.setBounds(64, 26, 186, 22);
     textoID.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 15));
     textoID.setForeground(Color.decode("#D9D9D9"));
     panel.add(textoID);

     JTextField inputID = new JTextField("");
     inputID.setBounds(66, 56, 106, 22);
     inputID.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 15));
     inputID.setBackground(Color.decode("#B2B2B2"));
     inputID.setForeground(Color.decode("#656565"));
     inputID.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
     OnFocusEventHelper.setOnFocusText(inputID, "ID do Conselho", Color.decode("#353535"),   Color.decode("#656565"));
     panel.add(inputID);

     JButton botaoConselho = new JButton("Conselho");
     botaoConselho.setBounds(65, 92, 106, 29);
     botaoConselho.setBackground(Color.decode("#2e2e2e"));
     botaoConselho.setForeground(Color.decode("#D9D9D9"));
     botaoConselho.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 15));
     botaoConselho.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     botaoConselho.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(botaoConselho, Color.decode("#232323"), Color.decode("#2e2e2e"));

     botaoConselho.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent e) {
          
          String id = inputID.getText();
          
          if (id.trim().isEmpty()) {
              JOptionPane.showMessageDialog(frame, "Por favor, digite o ID do Conselho!", "Aviso", JOptionPane.WARNING_MESSAGE);
          } else {
            Conselho.consultar(id);  
            JOptionPane.showMessageDialog(frame, "Conselho " + id + "!" , "Conselhos", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(frame, Conselho.con, "Conselhos", JOptionPane.INFORMATION_MESSAGE); 
                                                   
          }
      }
      });
     panel.add(botaoConselho);

     frame.add(panel);
     frame.setVisible(true);

  }
}