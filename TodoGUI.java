import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class TodoGUI extends JFrame  {
	JLabel desLabel=new JLabel("Description");
	JTextField desText=null;
	JLabel dueLabel=new JLabel("Due date:");
	JTextField dueText=new JTextField(15);
	JLabel MonthLabel=new JLabel("Month");
	JTextField MonthText=new JTextField(15);
	JLabel displayLabel=null;
	
	
	JButton addButton=new JButton("Add item");
	
	
	
	
	
	public TodoGUI(){
		desText =new JTextField(15);
		setLayout (new GridBagLayout());
		
		// description label
		GridBagConstraints layoutCon=new GridBagConstraints();
		layoutCon.gridx=0;
		layoutCon.gridy=0;
		layoutCon.insets=new Insets(10,10,10,10);
		
		add(desLabel,layoutCon);
		
		//description textfield
		layoutCon.gridx=1;
		layoutCon.gridy=0;
		layoutCon.insets=new Insets(10,10,10,10);
		
		add(desText,layoutCon);
		
		
		// description label
				
				layoutCon.gridx=0;
				layoutCon.gridy=1;
				layoutCon.insets=new Insets(10,10,10,10);
				
				add(dueLabel,layoutCon);
				
				//description textfield
				layoutCon.gridx=1;
				layoutCon.gridy=1;
				layoutCon.insets=new Insets(10,10,10,10);
				
				add(dueText,layoutCon);
		
				// description label
				
				layoutCon.gridx=0;
				layoutCon.gridy=2;
				layoutCon.insets=new Insets(10,10,10,10);
				
				add(MonthLabel,layoutCon);
				
				//description textfield
				layoutCon.gridx=1;
				layoutCon.gridy=2;
				layoutCon.insets=new Insets(10,10,10,10);
				
				add(MonthText,layoutCon);	
				
				//add Interm Button
				layoutCon=new GridBagConstraints();
				layoutCon.gridx=0;
				layoutCon.gridy=3;
				layoutCon.insets=new Insets(10,10,10,10);
				
				addButton=new JButton("Add iterm");
				add(addButton,layoutCon);
				addButton.addActionListener(this);
				
				//Dispaly
				
				layoutCon=new GridBagConstraints();
				layoutCon.gridx=0;
				layoutCon.gridy=4;
				layoutCon.insets=new Insets(10,10,10,10);
				
				displayLabel=new JLabel("");
				add(displayLabel,layoutCon);
	}
				
		public void actionPerformed(ActionEvent e){
			//add item
			if (e.getActionCommand().equals("Add item")){
				TOdoItem item1+new TOdoItem(TaskText.getText(),Integer.parseInt(dateText.getText()),Integer.parseint(monthText.getText()));
				
			}
				

				
	}
	
	
	public static void main(String[] args){
		TOdoGUI topFrame=new TOdoGUI();
		topFrame.setVisible(true);
		topFrame.pack();
		topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
