import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener {
JFrame frame; 
JTextField textfield;
JButton[] numbuttons = new JButton[10];
JButton [] function = new JButton[8];
JButton addbtn,subbtn,multbtn,divbtn;
JButton decbtn,equalbtn,delbtn,clrbtn;
JPanel panel;
Font myfont;
double num1 =0,num2 =0,result =0;
char operator;

Calculator(){
	frame = new JFrame ("Calculator");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame .setSize(420,550);
	frame.setResizable(false);
	frame.setLayout(null);
	Font myFont = new Font("ink Free", Font.BOLD,30);
	textfield = new JTextField();
	textfield.setBounds(50,25,300,50);
	textfield.setFont(myFont);
	textfield.setEditable(true);//show text field can't be edited
	//buttons
	addbtn = new JButton("+");
	subbtn = new JButton("-");
	multbtn = new JButton("*");
	divbtn = new JButton("/");
	decbtn = new JButton(".");
	equalbtn = new JButton("=");
	delbtn = new JButton("Delete");
	clrbtn = new JButton("Clear");
	//adding button to array
	function[0] = addbtn; 
	function[1] = subbtn; 
	function[2] = multbtn; 
	function[3] = divbtn; 
	function[4] = decbtn; 
	function[5] = equalbtn; 
	function[6] = delbtn; 
	function[7] = clrbtn; 
	for(int i =0; i<8; i++) {
		function[i].addActionListener(this);
		function[i].setFont(myfont);
		function[i].setFocusable(false);
		
	}
	//numbers button
	for(int i =0; i<10; i++) {
		numbuttons[i]= new JButton(String.valueOf(i));
		numbuttons[i].addActionListener(this);
		numbuttons[i].setFont(myfont);
		numbuttons[i].setFocusable(false);
	}
	delbtn.setBounds(50,430,145,50);
	clrbtn.setBounds(205,430,145,50);
	//panel to hold numbers
	panel = new JPanel();
	panel.setBounds(50,100,300,300);
	panel.setLayout(new GridLayout(4,4,10,10));
	panel.setBackground(Color.gray);
	
//add buttons
	panel.add(numbuttons[1]);
	panel.add(numbuttons[2]);
	panel.add(numbuttons[3]);
	panel.add(addbtn);
	panel.add(numbuttons[4]);
	panel.add(numbuttons[5]);
	panel.add(numbuttons[6]);
	panel.add(subbtn);
	panel.add(numbuttons[7]);
	panel.add(numbuttons[8]);
	panel.add(numbuttons[9]);
	panel.add(multbtn);
	panel.add(numbuttons[0]);
	panel.add(decbtn);
	panel.add(equalbtn);
	panel.add(divbtn);
	frame.add(panel);
	frame.add(delbtn);
	frame.add(clrbtn);
	frame.add(textfield);
	frame.setVisible(true);
	
}
	public static void main(String[] args) {
		
Calculator calc = new Calculator();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//updating text field when number is clicked

		for(int i =0;i<10 ;i++) {
			if(e.getSource()==numbuttons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
				
			}
		}
			if(e.getSource()==decbtn) {
				textfield.setText(textfield.getText().concat("."));
			}
			if(e.getSource()==addbtn) {
		    num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
			}
			if(e.getSource()==subbtn) {
				num1 = Double.parseDouble(textfield.getText());
				operator = '-';
				textfield.setText("");
				
				
				}
			if(e.getSource()==multbtn) {
				num1 = Double.parseDouble(textfield.getText());
				operator = '*';
				textfield.setText("");
				}
			if(e.getSource()==divbtn) {
				num1 = Double.parseDouble(textfield.getText());
				operator = '/';
				textfield.setText("");
				}
			if(e.getSource()==equalbtn) {
				num2 = Double.parseDouble(textfield.getText());
				//maths
				switch(operator) {
				case'+':
					result = num1+num2;
					break;
				case'-':
					result = num1-num2;
					break;
				case'*':
					result = num1*num2;
					break;	
				case'/':
					result = num1/num2;
					break;	
				}
				textfield.setText(String.valueOf(result));
				num1 =result;
				}
		if(e.getSource()==clrbtn) {
			textfield.setText("");
		}
		if(e.getSource()==delbtn) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i =0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
	}

}
