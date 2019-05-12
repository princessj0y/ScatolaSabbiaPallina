import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingGui {
       private JFrame frame;
      
       public SwingGui(DatiCondivisi datiCondivisi /*, Scatola scatola*/) {
        frame = new JFrame("Controls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // a panel where add buttons with flow layout
        JPanel controls = new JPanel();
        controls.setLayout(new FlowLayout());

        // define the button to show the animated figure
        JButton incBtn = new JButton("Incrementa");
        incBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               datiCondivisi.incInclinazione();
               //scatola.aggiornaSabbia();
            }
        });
        
        // define the button to hide the animated figure
        JButton delBtn = new JButton("Decrementa");
        delBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               datiCondivisi.decInclinazione();
               //scatola.aggiornaSabbia();
            }
        });

        // add the buttons to the panel
        controls.add(incBtn);
        controls.add(delBtn);
        // add the panel to the frame
        frame.add(controls);
        frame.setSize(400, 80);
    }

    public void show() {
        frame.setVisible(true);
    }
}
