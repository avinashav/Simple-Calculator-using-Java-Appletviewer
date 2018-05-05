import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class calciav extends Applet implements ActionListener {
    
    char OP;
    int v1,v2,result;
    TextField t1;
    
    Button b[]=new Button[10];
    Button add,mul,div,sub,eq;
    
    public void init(){
        
        Color k=new Color(190,190,190);             //setting background color to Light Grey 
		setBackground(k);
        
        t1=new TextField(5);                     //TextField for Displaying output
        
        GridLayout gl=new GridLayout(4,5);          //using rectangular grid to display the buttons
		setLayout(gl);
        
        for(int i=0;i<10;i++)
        {
            b[i]=new Button(""+i);                //buttons for taking 0 to 9 digit as input
        } 
        
        add=new Button("add");                    //buttons for addition, substraction
        sub=new Button("sub");                     // multiplication, division operation
        mul=new Button("mul"); 
        div=new Button("div");
        eq=new Button("Equal");                    //button for equating the result
        
        add(t1);                                    //adding textbox to application
        
        for(int i=0;i<10;i++)
        {
            add(b[i]);                          //adding all defined buttons to application
        }
        add(add);
        add(sub);
        add(mul);
        add(div);
        add(eq);

        t1.addActionListener(this);             //registering action listiner for textbox
        
        for(int i=0;i<10;i++)
        {
            b[i].addActionListener(this);       // registering action-listener for all buttons
        }
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        eq.addActionListener(this);    
    }
        public void actionPerformed(ActionEvent ae){
            String str=ae.getActionCommand();           //returns the command string associated with the action
            char ch=str.charAt(0);
            if(Character.isDigit(ch))                   //if the first character is a digit count it for performing operation
                t1.setText(t1.getText()+str);           
            else                                 //else any of the addition or sub or multiplication operation to be performed
		if(str.equals("add"))                    //comparing string for which operation to perform
		{
			v1=Integer.parseInt(t1.getText());
			OP='+';
			t1.setText("");                     //clear the Textfield
		}
            else if(str.equals("sub"))
		{
			v1=Integer.parseInt(t1.getText());
			OP='-';
			t1.setText("");
		}
		else if(str.equals("mul"))
		{
			v1=Integer.parseInt(t1.getText());
			OP='*';
			t1.setText("");
		}
		else if(str.equals("div"))
		{
			v1=Integer.parseInt(t1.getText());
			OP='/';
			t1.setText("");
		}
                else if(str.equals("Equal"))            //if equal button was pressed output the result of operation performed
                {
                    v2=Integer.parseInt(t1.getText());
                    if(OP=='+')
                        result=v1+v2;
                    else if(OP=='-')
                        result=v1-v2;
                    else if(OP=='*')
                        result=v1*v2;
                    else if(OP=='/')
			result=v1/v2;  
                    t1.setText(""+result);
                }
        }
        public void paint(Graphics g){
            g.drawString("Simple-Calculator-by-Avinash_Kr",150,150);        //displaying text on the screen
        }
    }