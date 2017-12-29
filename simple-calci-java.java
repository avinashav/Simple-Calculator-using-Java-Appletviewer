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
        t1=new TextField(5);
        for(int i=0;i<10;i++)
        {
            b[i]=new Button(""+i);
        } 
        add=new Button("add");
        sub=new Button("sub");
        mul=new Button("mul");
        div=new Button("div");
        eq=new Button("eq");
        add(t1);
        for(int i=0;i<10;i++)
        {
            add(b[i]);
        }
        add(add);
        add(sub);
        add(mul);
        add(div);
        add(eq);

        t1.addActionListener(this);
        for(int i=0;i<10;i++)
        {
            b[i].addActionListener(this);
        }
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        eq.addActionListener(this);    
    }
        public void actionPerformed(ActionEvent ae){
            String str=ae.getActionCommand();
            char ch=str.charAt(0);
            if(Character.isDigit(ch))
                t1.setText(t1.getText()+str);
            else
		if(str.equals("add"))
		{
			v1=Integer.parseInt(t1.getText());
			OP='+';
			t1.setText("");
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
                else if(str.equals("eq"))
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
            g.drawString("Avinash",200,200);
        }
    }