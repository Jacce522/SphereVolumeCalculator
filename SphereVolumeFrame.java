import spherePackage.*; //importing our FooParameterization class here
import javax.swing.*;
import java.awt.event.*;

public class SphereVolumeFrame extends JFrame 
{
    
	private static final long serialVersionUID = 1L;
	private JTextField radiusField;
  private JLabel volumeLabel;

    public SphereVolumeFrame() 
    {
    	//Set the frame and the size of the frame with title 
    	//This frame is flexible and there's room for more buttons and calculations to be used as needed
        setTitle("Sphere Volume Calculator"); 
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add a label and text field for the user to enter sphere radius
        //Add a button to calculate 
        
        JLabel radiusLabel = new JLabel("Enter radius:");
        radiusField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate Volume");
        volumeLabel = new JLabel("");

        /*Once the calculate button is clicked then this action takes place that will call 
        the SphereVolumeCalculator method, the seperate class was imported in from the top*/
        
        calculateButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	/*try catch block, if they enter letters instead of numbers they will get 
            	the invalid input*/
                try {
                    double radius = Double.parseDouble(radiusField.getText());
                    double volume = FooParameterization.calculateSphereVolume(radius);
                    volumeLabel.setText("Volume: " + volume);
                } catch (NumberFormatException ex) {
                    volumeLabel.setText("Invalid input");
                }
            }
        });

        //Add the text field and calculate button to the JPanel frame. 
        
        JPanel panel = new JPanel();
        panel.add(radiusLabel);
        panel.add(radiusField);
        panel.add(calculateButton);
        panel.add(volumeLabel);
        add(panel);
    }

    public static void main(String[] args) 
    {
      //Driver to run the application
    	//main method will create a SphereVolumeFrame object and run until user exits 
    	new SphereVolumeFrame().setVisible(true);
    	
    	
    }
}
