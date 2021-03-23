
import java.awt.*;
import java.awt.event.*;

public class Lab6 extends Frame implements ActionListener {

	private Label headerLabel1, responseLabel1; 
	private Label headerLabel2, responseLabel2; 
	private Label fillerLabel1, fillerLabel2, fillerLabel3;
	private Label fillerLabel4, fillerLabel5;
	
	Button yes1 = new Button("Yes");
	Button no1 = new Button("No");
	Button yes2 = new Button("Yes");
	Button no2 = new Button("No");
	
	public Lab6()
	{
	    setLayout(new GridLayout(9,1));
	    setSize(400, 400);
	    setBackground(Color.WHITE);
		addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });  
		fillerLabel1 = new Label("");
		fillerLabel2 = new Label("");
		fillerLabel3 = new Label("");
		fillerLabel4 = new Label("");
		fillerLabel5 = new Label("");
		
		headerLabel1 = new Label("Do you like my program?", Label.CENTER);
	    
	    yes1 = new Button("Yes");
	    yes1.setBackground(Color.GREEN);
	    yes1.setForeground(Color.BLACK); 
	    
	    no1 = new Button("No");
	    no1.setBackground(Color.RED);
	    no1.setForeground(Color.BLACK); 
	    
	    responseLabel1 = new Label();        
	    responseLabel1.setAlignment(Label.CENTER);
	    
	    add(headerLabel1);
	    add(fillerLabel1);
	    add(yes1);
	    add(no1);
	    add(responseLabel1);
	    add(fillerLabel2);
	    add(fillerLabel3);
	    add(fillerLabel4);

	    headerLabel2 = new Label("Is it too simple?", Label.CENTER);
	    
	    yes2 = new Button("Yes");
	    yes2.setBackground(Color.GREEN);
	    yes2.setForeground(Color.BLACK); 
	    
	    no2 = new Button("No");
	    no2.setBackground(Color.RED);
	    no2.setForeground(Color.BLACK); 
	    
	    responseLabel2 = new Label();        
	    responseLabel2.setAlignment(Label.CENTER);
	    
	    add(headerLabel2);
	    add(fillerLabel5);
	    add(yes2);
	    add(no2);
	    add(responseLabel2);
	   
	    setVisible(true);
	    addListener();
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("Gabrielle Lyons", 290, 390);
	}
	public void addListener() 
	{
	    yes1.addActionListener(this);
	    no1.addActionListener(this);
	    yes2.addActionListener(this);
	    no2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) 
	{	
		if (e.getSource() == yes1) 
		{
		 	responseLabel1.setText("Yay! Happy to hear!");
		} 
		if (e.getSource() == no1) 
			
		{
			responseLabel1.setText("Damn, too bad.");
		} 
		if (e.getSource() == yes2) 
		{
		 	responseLabel2.setText("Sorry, I'm still learning.");
		} 
		if (e.getSource() == no2) 
		{
			responseLabel2.setText("Okay, awesome!");
		} 
	}
	
	public static void main(String[] args)
	{
		Lab6 myLab = new Lab6();
	}
}
