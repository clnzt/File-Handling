import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class faculty extends JFrame{
	//panel 1
	FlowLayout lay1 = new FlowLayout(FlowLayout.LEFT);
	JPanel number = new JPanel();
	JPanel name = new JPanel();
	JLabel fnum = new JLabel("Faculty Number:");
	JLabel fname = new JLabel("Faculty Name:    ");
	JTextField txt1 = new JTextField(20);
	JTextField txt2 = new JTextField(20);
	
	//panel 2
	private JPanel pan2 = new JPanel();
	private GridLayout grid2 =  new GridLayout(3,4);
	//radiobutton
	private JLabel ST = new JLabel("Employment Status:");
	private JRadioButton rb1 = new JRadioButton("Permanent",true);
	private JRadioButton rb2 = new JRadioButton("Temporary");
	private JRadioButton rb3 = new JRadioButton("Part-Time");
	//private checkbutton
	//combobox
	private JLabel DPT = new JLabel("Department:");
	String[] dept = {"Computer Science", "Information Science", "Information Technology"};
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox<String> dpcb = new JComboBox(dept);
	//checkbox
	private JLabel SUBT = new JLabel("Subjects Taught:");
	
	//pannel 3
	private JPanel pan3 = new JPanel();
	private GridLayout grid3 =  new GridLayout(3,3);
	//checkbox
	private JCheckBox chk1 = new JCheckBox("Programming"); //CS, IS,IT
	private JCheckBox chk2 = new JCheckBox("Database"); //CS,IS,IT
	private JCheckBox chk3 = new JCheckBox("Elective"); //CS,IS,IT
	private JCheckBox chk4 = new JCheckBox("Thesis"); //CS
	private JCheckBox chk5 = new JCheckBox("Discrete"); //IS,IT
	private JCheckBox chk6 = new JCheckBox("Networking"); //IS
	private JCheckBox chk7 = new JCheckBox("Research"); //IS
	private JCheckBox chk8 = new JCheckBox("Modelling"); //IT
	private JCheckBox chk9 = new JCheckBox("Capstone"); //IT
	
	//panel 4
	private JPanel pan4 = new JPanel();
	private FlowLayout lay4 = new FlowLayout();
	private JButton bt1 = new JButton("Add");
	private JButton bt2 = new JButton("Clear");
	private JButton bt3 = new JButton("Exit");
	
	//panel 5
	private JPanel pan5 = new JPanel();
	private BorderLayout br5 = new BorderLayout();
	private JTextArea txt = new JTextArea(20,70);
	//private JScrollPane sp = new JScrollPane(txt);
	private Font font2 = new Font("Verdana",Font.ROMAN_BASELINE, 30);
	
	public String eStats = "";
	public String msg, msgFinal = "", dep = "";
	private String c1, c2, c3, c4, c5, c6, c7, c8, c9;
	private String h = ("Employee Number:\tEmployee Name:\tStatus\tDepartment\t\tSubject\n");
	
	public faculty(String x) {
		super(x);
		Container s = getContentPane();
		// Set layout for the content pane
        s.setLayout(new BorderLayout());
		
		//panel 1
        JPanel panel1 = new JPanel(new GridLayout(2,1));
    	number.setLayout(lay1);
    	number.add(fnum); number.add(txt1);
    	panel1.add(number);

    	name.setLayout(lay1);
    	name.add(fname); name.add(txt2);
    	panel1.add(name);
		
    	JPanel center = new JPanel(new GridLayout(3,1));
		//panel 2
        pan2.setLayout(grid2);
       
        // Employment Status row
        pan2.add(ST);
        pan2.add(rb1); pan2.add(rb2); pan2.add(rb3);
        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        group.add(rb3);
        
        //department row
        pan2.add(DPT); pan2.add(dpcb);
        pan2.add(new JLabel()); pan2.add(new JLabel());
        //dpcbAction combox = new dpcbAction();
        //dpcb.addItemListener(combox);
        
        //Subject Taught 
        pan2.add(SUBT);
        pan2.add(new JLabel()); pan2.add(new JLabel());
        center.add(pan2);
        
        //panel 3
        pan3.add(new JLabel());
        pan3.setLayout(grid3);
        pan3.add(chk1); pan3.add(chk2); pan3.add(chk3);
        pan3.add(new JLabel());
        pan3.add(chk4); pan3.add(chk5); pan3.add(chk6);
        pan3.add(new JLabel());
        pan3.add(chk7); pan3.add(chk8); pan3.add(chk9);
        center.add(pan3);
        
        //panel 4
        pan4.setLayout(lay4);
        center.add(pan4);
        
        pan4.add(bt1);
        bt1.setMnemonic(KeyEvent.VK_A);
        
        pan4.add(bt2); 
        bt2.setMnemonic(KeyEvent.VK_C);
        
        pan4.add(bt3);
        bt3.setMnemonic(KeyEvent.VK_E);
        

        
        JPanel out5 = new JPanel(new BorderLayout());
        //panel 5
        pan5.setLayout(br5);
        pan5.add(txt);
        pan5.add(txt,BorderLayout.NORTH);
        pan5.add(new JScrollPane(txt), BorderLayout.CENTER);
        txt.setEditable(false);
        out5.add(pan5);
        
    	//panels in frame
		s.add(panel1,BorderLayout.NORTH);
		s.add(center,BorderLayout.CENTER);
		s.add(out5,BorderLayout.SOUTH);
		s.setFont(font2);
		
		txt.setText(h);
		
		rbEvnt rbe = new rbEvnt();
		rb1.addItemListener(rbe); rb2.addItemListener(rbe); rb3.addItemListener(rbe);
		
		rbEvnt cbe = new rbEvnt();
		dpcb.addItemListener(cbe);
		
		rbEvnt chs = new rbEvnt();
		chk1.addItemListener(chs);
		chk2.addItemListener(chs);
		chk3.addItemListener(chs);
		chk4.addItemListener(chs);
		chk5.addItemListener(chs);
		chk6.addItemListener(chs);
		chk7.addItemListener(chs);
		chk8.addItemListener(chs);
		chk9.addItemListener(chs);
		
		Event2 btn = new Event2();
		bt1.addActionListener(btn);
		bt2.addActionListener(btn);
		bt3.addActionListener(btn);
		
		setResizable(false);
		setSize(600,600);
		setVisible(true);
	}
		
		public class rbEvnt implements ItemListener{
			public void itemStateChanged(ItemEvent ie){
				
				
	            if (ie.getSource() == rb1) {
	            	eStats = "Permanent";
	            } else if (ie.getSource() == rb2) {
	                eStats = "Temporary";
	            } else if (ie.getSource() == rb3) {
	                eStats = "Part-time";
	            }
	            
	            if (dpcb.getSelectedIndex() == 0){
	            	dep = (String)dpcb.getItemAt(dpcb.getSelectedIndex());
	            	chk1.setEnabled(true);
                    chk2.setEnabled(true);
                    chk3.setEnabled(true);
                    chk4.setEnabled(true);
                    chk5.setEnabled(false);
                    chk6.setEnabled(false);
                    chk7.setEnabled(false);
                    chk8.setEnabled(false);
                    chk9.setEnabled(false);
	            } else if (dpcb.getSelectedIndex() == 1){
	            	dep = (String)dpcb.getItemAt(dpcb.getSelectedIndex());
	            	chk1.setEnabled(true);
                    chk2.setEnabled(true);
                    chk3.setEnabled(true);
                    chk4.setEnabled(false);
                    chk5.setEnabled(true);
                    chk6.setEnabled(true);
                    chk7.setEnabled(true);
                    chk8.setEnabled(false);
                    chk9.setEnabled(false);
	            } else if (dpcb.getSelectedIndex() == 2){
	            	dep = (String)dpcb.getItemAt(dpcb.getSelectedIndex());
	            	chk1.setEnabled(true);
                    chk2.setEnabled(true);
                    chk3.setEnabled(true);
                    chk4.setEnabled(false);
                    chk5.setEnabled(true);
                    chk6.setEnabled(false);
                    chk7.setEnabled(false);
                    chk8.setEnabled(true);
                    chk9.setEnabled(true); 	
	            }
	            
	        	if(chk1.isSelected())
					c1 = chk1.getText() + ", ";
				else c1 = "";
				if(chk2.isSelected())
					c2 = chk2.getText() + ", ";
				else c2 = "";
				if(chk3.isSelected())
					c3 = chk3.getText() + ", ";
				else c3 = "";
				if(chk4.isSelected())
					c4 = chk4.getText() + ", ";
				else c4 = "";
				if(chk5.isSelected())
					c5 = chk5.getText() + ", ";
				else c5 = "";
				if(chk6.isSelected())
					c6 = chk6.getText() + ", ";
				else c6 = "";
				if(chk7.isSelected())
					c7 = chk7.getText() + ", ";
				else c7 = "";
				if(chk8.isSelected())
					c8 = chk8.getText() + ", ";
				else c8 = "";
				if(chk9.isSelected())
					c9 = chk9.getText() + ", ";
				else c9 = "";
	            
				
				
			}
			
		}
		
		public class Event2 implements ActionListener{
			
			public void actionPerformed(ActionEvent ae){
				msg = txt1.getText() + "\t\t" + txt2.getText() + "\t\t" + eStats + "\t" + dep + "\t" + c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + "\n";
				msgFinal = msgFinal + msg; 
				
				txt.setText(null);
				if(ae.getSource() == bt1)
					txt.setText(h + msgFinal);	
				else if(ae.getSource() == bt2) {
		            txt1.setText("");
	            	txt2.setText("");
	            	dpcb.setSelectedItem(dept[2]);
	            	rb1.setSelected(true);
	            	rb2.setSelected(false);
	            	rb3.setSelected(false);
	            	chk1.setSelected(false);
	            	chk2.setSelected(false);
	            	chk3.setSelected(false);
	            	chk4.setSelected(false);
	            	chk5.setSelected(false);
	            	chk6.setSelected(false);
	            	chk7.setSelected(false);
	            	chk8.setSelected(false);
	            	chk9.setSelected(false);
					txt.setText("" + h);					
				}else
					System.exit(DISPOSE_ON_CLOSE);
				
				
			}

				
			
		}
    
	//main
	public static void main(String[] args) {
		faculty fcinfo = new faculty ("PUPSJ Faculty Records");
		fcinfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
	
