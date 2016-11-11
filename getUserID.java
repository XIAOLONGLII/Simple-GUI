import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class getUserID extends JFrame implements ActionListener {
	
		//instance variables
		JLabel firstNameLabel=null;
		JTextField firstNameText=null;
		JLabel lastNameLabe=null;
		JTextField lastNameText=null;
		JLabel GetUserID=null;
		JButton getUserIDButton=null;
		JLabel ansLable=null;
		
	
		//constructor
		public getUserID(){
			setLayout(new GridBagLayout());
			getUserIDButton= new JButton("User ID");
			
			
			
		//****Label fullName
			GridBagConstraints layoutCon = new GridBagConstraints();
	        layoutCon.gridx = 0;
	        layoutCon.gridy = 0;
	        layoutCon.insets = new Insets(10,10,10,10);
			JLabel firstNameLabel = new JLabel("Enter your first name:");
			add(firstNameLabel,layoutCon);
		
		//Text first name
		 layoutCon = new GridBagConstraints();
	        layoutCon.gridx = 1;
	        layoutCon.gridy = 0;
	        layoutCon.insets = new Insets(10,10,10,10);
	        
	        firstNameText = new JTextField(20);
	        add(firstNameText, layoutCon);
	    // **** Label lastName
	        
	        layoutCon.gridx = 0;
	        layoutCon.gridy = 1;
	        layoutCon.insets = new Insets(10,10,10,10);
			JLabel lastNameLabel = new JLabel("Enter your last name:");
			add(lastNameLabel,layoutCon);
		// Text last name
			
			layoutCon = new GridBagConstraints();
	        layoutCon.gridx = 1;
	        layoutCon.gridy = 1;
	        layoutCon.insets = new Insets(10,10,10,10);
	        JLabel lastName = new JLabel("Enter your last name:");
	        
	        lastNameText = new JTextField(20);
	        add(lastNameText, layoutCon);
			
	    
		//ADD getUserID
			
			layoutCon = new GridBagConstraints();
	        layoutCon.gridx = 0;
	        layoutCon.gridy = 2;
	        layoutCon.insets = new Insets(10,10,10,10);
	        
	        GetUserID = new JLabel("User ID");
	        add(getUserIDButton,layoutCon);   // added label to JFrame  
	        getUserIDButton.addActionListener(this);
	        
	        //
	        
	        layoutCon = new GridBagConstraints();
	        layoutCon.gridx = 1;
	        layoutCon.gridy = 2;
	        layoutCon.insets = new Insets(10,10,10,10);
	        
	        ansLable = new JLabel("Answer");
	        add(ansLable,layoutCon);   // added label to JFrame  
	        

	}

		@Override
		public void actionPerformed(ActionEvent e) {
			String firstName=firstNameText.getText();
			String lastName=lastNameText.getText();

			
			String userID = "";
	        // check if the first name is less than 3 characters long
	        if (firstName.length() < 3) {
	            // if so, use the whole first name
	            userID = firstName;
	        }
	        else {
	            userID = firstName.substring(0,3);
	        }
	        
	        // check if the last name is less than 3 characters long
	        if (lastName.length() < 3) {
	            // if so, use the whole first name
	            userID = userID + lastName;
	        }
	        else {
	            userID = userID + lastName.substring(0,3);
	        }
	        
	        // add on the length of the two names
	        userID = userID + (firstName.length() + lastName.length());
	        e.getActionCommand().equals("Use ID");
	        ansLable.setText(userID);
	        
	        
	       
		}
		public static void main(String[] args){
			getUserID calc= new getUserID();
			
			calc.pack();    // resizes window (JFrame) so you can see the elements in it
	        calc.setVisible(true);   // make window visible
	        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit program when close window
			
		}
}
