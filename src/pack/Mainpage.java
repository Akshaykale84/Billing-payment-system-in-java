package pack;

import java.awt.event.*;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;//2347350drift
import javax.swing.JMenuBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class Mainpage extends JFrame {
	private JTextField textprice;
	private JTextField textquantity;
	private JTextField textproductID;
	private JTextField textPname;
	private JTextField textsprice;
	private JTextField textsquantity;
	private JTextField textpid;
	private JButton btnNew;
	private JButton btnPrint;
	ButtonGroup bg1;
	String nquantity;
	int check=0;
	double totalamt=0;
	
	int s=0;

	void clear()
	{
		textprice.setText(null);
		textquantity.setText(null);
		textpid.setText(null);
		textquantity.setEditable(false);
		
	}

	
	public Mainpage() {
		
        JFrame frame = new JFrame("Payment Billing System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1650, 1080);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//product panels
		JPanel graphic_p = new JPanel();
		graphic_p.setBounds(232, 100, 320, 220);
		contentPane.add(graphic_p);
		graphic_p.setLayout(null);
		graphic_p.setVisible(false);
		
		JPanel processor_p = new JPanel();
		processor_p.setBounds(232, 100, 320, 220);
		contentPane.add(processor_p);
		processor_p.setLayout(null);
		processor_p.setVisible(false);
		
		JPanel RAM_p = new JPanel();
		RAM_p.setBounds(232, 100, 320, 220);
		contentPane.add(RAM_p);
		RAM_p.setLayout(null);
		RAM_p.setVisible(false);
		
		JPanel harddisk_p = new JPanel();
		harddisk_p.setBounds(232, 100, 320, 220);
		contentPane.add(harddisk_p);
		harddisk_p.setLayout(null);
		harddisk_p.setVisible(false);
		
		JPanel monitor_p = new JPanel();
		monitor_p.setBounds(232, 100, 320, 220);
		contentPane.add(monitor_p);
		monitor_p.setLayout(null);
		monitor_p.setVisible(false);
		
		JPanel ssd_p = new JPanel();
		ssd_p.setBounds(232, 100, 320, 220);
		contentPane.add(ssd_p);
		ssd_p.setLayout(null);
		ssd_p.setVisible(false);
		
		JPanel pendrive_p = new JPanel();
		pendrive_p.setBounds(232, 100, 320, 220);
		contentPane.add(pendrive_p);
		pendrive_p.setLayout(null);
		pendrive_p.setVisible(false);
		
		//price and quantity
		textprice = new JTextField();
		textprice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textprice.setEditable(false);
		textprice.setBounds(615, 201, 185, 20);
		contentPane.add(textprice);
		textprice.setColumns(10);
		
		textquantity = new JTextField();
		textquantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textquantity.setColumns(10);
		textquantity.setBounds(615, 263, 185, 20);
		contentPane.add(textquantity);
		textquantity.setEditable(false);
		
		//labels
		JLabel lblSelectProduct = new JLabel("Select Product:");
		lblSelectProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelectProduct.setBounds(10, 16, 169, 30);
		contentPane.add(lblSelectProduct);
		
		JLabel lblSelectType = new JLabel("Select Type:");
		lblSelectType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelectType.setBounds(232, 16, 169, 30);
		contentPane.add(lblSelectType);
		lblSelectType.setVisible(false);
		
		JLabel lblPriceDetails = new JLabel("Price Details:");
		lblPriceDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPriceDetails.setBounds(615, 16, 169, 30);
		contentPane.add(lblPriceDetails);
		
		//receipt area
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea.setBounds(879, 11, 458, 681);
		contentPane.add(textArea);
		JScrollPane sp = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(sp);
		sp.setBounds(879, 11, 458, 681);
		textArea.setEditable(false);
		textArea.setText(" Product Name            Price       Quantity    AMT\n-------------------------------------------------------");
		
		
		//product radiobuttons
		JRadioButton rbGC = new JRadioButton("Graphic Card");
		rbGC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbGC.setBounds(30, 263, 149, 20);
		contentPane.add(rbGC);
		rbGC.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					graphic_p.setVisible(true);
					processor_p.setVisible(false);
					RAM_p.setVisible(false);
					harddisk_p.setVisible(false);
					monitor_p.setVisible(false);
					lblSelectType.setVisible(true);
					ssd_p.setVisible(false);
					pendrive_p.setVisible(false);
					clear();
				}
				
			}
		});
		
		JRadioButton rbPR = new JRadioButton("Processor");
		rbPR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbPR.setBounds(30, 341, 149, 20);
		contentPane.add(rbPR);
		rbPR.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					processor_p.setVisible(true);
					graphic_p.setVisible(false);
					RAM_p.setVisible(false);
					harddisk_p.setVisible(false);
					monitor_p.setVisible(false);
					lblSelectType.setVisible(true);
					ssd_p.setVisible(false);
					pendrive_p.setVisible(false);
					clear();
				}
			}
		});
		
		JRadioButton rbRAM = new JRadioButton("RAM");
		rbRAM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbRAM.setBounds(30, 107, 149, 20);
		contentPane.add(rbRAM);
		rbRAM.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					RAM_p.setVisible(true);
					graphic_p.setVisible(false);
					processor_p.setVisible(false);
					harddisk_p.setVisible(false);
					monitor_p.setVisible(false);
					lblSelectType.setVisible(true);
					ssd_p.setVisible(false);
					pendrive_p.setVisible(false);
					clear();
				}
			}
		});
		
		JRadioButton rbHD = new JRadioButton("Hard Disk");
		rbHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbHD.setBounds(30, 184, 149, 20);
		contentPane.add(rbHD);
		rbHD.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					harddisk_p.setVisible(true);
					RAM_p.setVisible(false);
					graphic_p.setVisible(false);
					processor_p.setVisible(false);
					monitor_p.setVisible(false);
					lblSelectType.setVisible(true);
					ssd_p.setVisible(false);
					pendrive_p.setVisible(false);
					clear();
				}
			}
		});
		
		JRadioButton rbMN = new JRadioButton("Monitor");
		rbMN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbMN.setBounds(30, 427, 149, 23);
		contentPane.add(rbMN);
		rbMN.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					monitor_p.setVisible(true);
					harddisk_p.setVisible(false);
					RAM_p.setVisible(false);
					graphic_p.setVisible(false);
					processor_p.setVisible(false);
					lblSelectType.setVisible(true);
					ssd_p.setVisible(false);
					pendrive_p.setVisible(false);
					clear();
				}
			}
		});
		
		JRadioButton rbSSD = new JRadioButton("Solid State Drive");
		rbSSD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbSSD.setBounds(30, 517, 149, 23);
		contentPane.add(rbSSD);
		rbSSD.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					ssd_p.setVisible(true);
					RAM_p.setVisible(false);
					graphic_p.setVisible(false);
					processor_p.setVisible(false);
					monitor_p.setVisible(false);
					lblSelectType.setVisible(true);
					harddisk_p.setVisible(false);
					pendrive_p.setVisible(false);
					clear();
				}
			}
		});
		
		JRadioButton rbPD = new JRadioButton("Pendrive");
		rbPD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbPD.setBounds(30, 607, 149, 23);
		contentPane.add(rbPD);
		rbPD.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					ssd_p.setVisible(false);
					RAM_p.setVisible(false);
					graphic_p.setVisible(false);
					processor_p.setVisible(false);
					monitor_p.setVisible(false);
					lblSelectType.setVisible(true);
					harddisk_p.setVisible(false);
					pendrive_p.setVisible(true);
					clear();
				}
			}
		});
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbGC);
		bg.add(rbPR);
		bg.add(rbRAM);
		bg.add(rbHD);
		bg.add(rbMN);
		bg.add(rbSSD);
		bg.add(rbPD);
		
		//graphic card checkboxes
		JCheckBox cb2gbGC = new JCheckBox("2 GB Memory @RS.5000");
		cb2gbGC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb2gbGC.setBounds(22, 7, 204, 20);
		graphic_p.add(cb2gbGC);
		
		JCheckBox cb4gbGC = new JCheckBox("4 GB Memory @RS.10000");
		cb4gbGC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb4gbGC.setBounds(22, 50, 204, 20);
		graphic_p.add(cb4gbGC);
		
		JCheckBox cb8gbGC = new JCheckBox("8 GB Memory @RS.20000");
		cb8gbGC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb8gbGC.setBounds(22, 92, 204, 20);
		graphic_p.add(cb8gbGC);
		
		JCheckBox cb11gbGC = new JCheckBox("11 GB Memory @RS.30000");
		cb11gbGC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb11gbGC.setBounds(22, 137, 204, 20);
		graphic_p.add(cb11gbGC);
		
		//processor checkboxes
		JCheckBox cbpenPR = new JCheckBox("Pentium 4 @RS.3000");
		cbpenPR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbpenPR.setBounds(22, 7, 204, 20);
		processor_p.add(cbpenPR);
		
		JCheckBox cbi3PR = new JCheckBox("i3 7th gen @RS.7000");
		cbi3PR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbi3PR.setBounds(22, 50, 204, 20);
		processor_p.add(cbi3PR);
		
		JCheckBox cbi5PR = new JCheckBox("i5 7th gen @RS.15000");
		cbi5PR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbi5PR.setBounds(22, 92, 204, 20);
		processor_p.add(cbi5PR);
		
		JCheckBox cbi7PR = new JCheckBox("i7 7th gen @RS.30000");
		cbi7PR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbi7PR.setBounds(22, 137, 204, 20);
		processor_p.add(cbi7PR);
		
		//RAM checkboxes
		JCheckBox cb2gbRAM = new JCheckBox("2 GB DDR 3 @RS.1000");
		cb2gbRAM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb2gbRAM.setBounds(22, 7, 204, 20);
		RAM_p.add(cb2gbRAM);
		
		JCheckBox cb4gbRAM = new JCheckBox("4 GB DDR 3 @RS.2500");
		cb4gbRAM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb4gbRAM.setBounds(22, 50, 204, 20);
		RAM_p.add(cb4gbRAM);
		
		JCheckBox cb8gbRAM = new JCheckBox("8 GB DDR 3 @RS.4000");
		cb8gbRAM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb8gbRAM.setBounds(22, 92, 204, 20);
		RAM_p.add(cb8gbRAM);
		
		JCheckBox cb16gbRAM = new JCheckBox("16 GB DDR 3 @RS.8000");
		cb16gbRAM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb16gbRAM.setBounds(22, 137, 204, 20);
		RAM_p.add(cb16gbRAM);
		
		//HARD DISK checkboxes
		JCheckBox cb160HD = new JCheckBox("160 GB Memory @RS.1000");
		cb160HD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb160HD.setBounds(22, 7, 204, 20);
		harddisk_p.add(cb160HD);
		
		JCheckBox cb320HD = new JCheckBox("320 GB Memory @RS.1500");
		cb320HD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb320HD.setBounds(22, 50, 204, 20);
		harddisk_p.add(cb320HD);
		
		JCheckBox cb500HD = new JCheckBox("500 GB Memory @RS.2000");
		cb500HD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb500HD.setBounds(22, 92, 204, 20);
		harddisk_p.add(cb500HD);
		
		JCheckBox cb1TBHD = new JCheckBox("1 TB Memory @RS.2500");
		cb1TBHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb1TBHD.setBounds(22, 137, 204, 20);
		harddisk_p.add(cb1TBHD);
		
		//Monitor checkboxes
		JCheckBox cb14MN = new JCheckBox("14 Inch Display @RS.7000");
		cb14MN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb14MN.setBounds(22, 7, 204, 20);
		monitor_p.add(cb14MN);
		
		JCheckBox cb30MN = new JCheckBox("30 Inch Display @RS.10000");
		cb30MN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb30MN.setBounds(22, 50, 204, 20);
		monitor_p.add(cb30MN);
		
		JCheckBox cb40MN = new JCheckBox("40 Inch Display @RS.15000");
		cb40MN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb40MN.setBounds(22, 92, 204, 20);
		monitor_p.add(cb40MN);
		
		JCheckBox cb50MN = new JCheckBox("50 Inch Display @RS.20000");
		cb50MN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb50MN.setBounds(22, 137, 204, 20);
		monitor_p.add(cb50MN);
		
		//SSD checkboxes
		JCheckBox cb120SSD = new JCheckBox("120 GB Storage @RS.5000");
		cb120SSD.setFont(new Font("Tahoma",Font.PLAIN,14));
		cb120SSD.setBounds(22, 7, 204, 20);
		ssd_p.add(cb120SSD);
		
		JCheckBox cb240SSD = new JCheckBox("240 GB Storage @RS.10000");
		cb240SSD.setFont(new Font("Tahoma",Font.PLAIN,14));
		cb240SSD.setBounds(22, 50, 204, 20);
		ssd_p.add(cb240SSD);
		
		JCheckBox cb500SSD = new JCheckBox("500 GB Storage @RS.15000");
		cb500SSD.setFont(new Font("Tahoma",Font.PLAIN,14));
		cb500SSD.setBounds(22, 92, 204, 20);
		ssd_p.add(cb500SSD);
		
		JCheckBox cb1TBSSD = new JCheckBox("1 TB Storage @RS.20000");
		cb1TBSSD.setFont(new Font("Tahoma",Font.PLAIN,14));
		cb1TBSSD.setBounds(22, 137, 204, 20);
		ssd_p.add(cb1TBSSD);
		
		//Pendrive checkboxes
		JCheckBox cb32PEN = new JCheckBox("32 GB Storage @RS.1000");
		cb32PEN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb32PEN.setBounds(22, 7, 204, 20);
		pendrive_p.add(cb32PEN);
		
		JCheckBox cb64PEN = new JCheckBox("64 GB Storage @RS.2000");
		cb64PEN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb64PEN.setBounds(22, 50, 204, 20);
		pendrive_p.add(cb64PEN);
		
		JCheckBox cb128PEN = new JCheckBox("128 GB Storage @RS.5000");
		cb128PEN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb128PEN.setBounds(22, 92, 204, 20);
		pendrive_p.add(cb128PEN);
		
		JCheckBox cb256PEN = new JCheckBox("256 GB Storage @RS.7000");
		cb256PEN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb256PEN.setBounds(22, 137, 204, 20);
		pendrive_p.add(cb256PEN);
		
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(cb2gbGC);
		bg1.add(cb4gbGC);
		bg1.add(cb8gbGC);
		bg1.add(cb11gbGC);
		bg1.add(cbpenPR);
		bg1.add(cbi3PR);
		bg1.add(cbi5PR);
		bg1.add(cbi7PR);
		bg1.add(cb2gbRAM);
		bg1.add(cb4gbRAM);
		bg1.add(cb8gbRAM);
		bg1.add(cb16gbRAM);
		bg1.add(cb160HD);
		bg1.add(cb320HD);
		bg1.add(cb500HD);
		bg1.add(cb1TBHD);
		bg1.add(cb14MN);
		bg1.add(cb30MN);
		bg1.add(cb40MN);
		bg1.add(cb50MN);
		bg1.add(cb120SSD);
		bg1.add(cb240SSD);
		bg1.add(cb500SSD);
		bg1.add(cb1TBSSD);
		bg1.add(cb32PEN);
		bg1.add(cb64PEN);
		bg1.add(cb128PEN);
		bg1.add(cb256PEN);
		
		JLabel lblNewLabel = new JLabel("Price:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(615, 170, 185, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantity.setBounds(615, 232, 185, 20);
		contentPane.add(lblQuantity);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String id = textpid.getText();
				int a=0;
				double price = Double.parseDouble(textprice.getText());
				try {
				double quantity = Double.parseDouble(textquantity.getText());
				double amt=price*quantity;
				nquantity = String.format("%.0f",quantity);
				
				if(quantity==0)
				{
					JOptionPane.showMessageDialog(btnAdd,"You Can't enter 0 for Quantity!!");
					a++;
				}
				if(quantity>99)
				{
					JOptionPane.showMessageDialog(btnAdd,"You Can't enter more than 99 for Quantity!!");
					a++;
				}
				if(check!=0)
				{
					JOptionPane.showMessageDialog(btnAdd,"Please Create New Receipt...");
				}
				if(quantity<10 && a==0 && check==0) {
					totalamt+=amt;
				switch(id)
				{
				case "100":
					textArea.setText(textArea.getText()+"\n2 GB Graphic Card       "+price+"         0"+nquantity+"      "+amt);
					break;
				case "101":
					textArea.setText(textArea.getText()+"\n4 GB Graphic Card       "+price+"        0"+nquantity+"      "+amt);
					break;
				case "102":
					textArea.setText(textArea.getText()+"\n8 GB Graphic Card       "+price+"        0"+nquantity+"      "+amt);
					break;
				case "103":
					textArea.setText(textArea.getText()+"\n11 GB Graphic Card      "+price+"        0"+nquantity+"      "+amt);
					break;
				case "104":
					textArea.setText(textArea.getText()+"\nPentium Processor       "+price+"         0"+nquantity+"      "+amt);
					break;
				case "105":
					textArea.setText(textArea.getText()+"\ni3 Processor            "+price+"         0"+nquantity+"      "+amt);
					break;
				case "106":
					textArea.setText(textArea.getText()+"\ni5 Processor            "+price+"        0"+nquantity+"      "+amt);
					break;
				case "107":
					textArea.setText(textArea.getText()+"\ni7 Processor            "+price+"        0"+nquantity+"      "+amt);
					break;
				case "108":
					textArea.setText(textArea.getText()+"\n2 GB DDR 3 RAM          "+price+"         0"+nquantity+"      "+amt);
					break;
				case "109":
					textArea.setText(textArea.getText()+"\n4 GB DDR 3 RAM          "+price+"         0"+nquantity+"      "+amt);
					break;
				case "110":
					textArea.setText(textArea.getText()+"\n8 GB DDR 3 RAM          "+price+"         0"+nquantity+"      "+amt);
					break;
				case "111":
					textArea.setText(textArea.getText()+"\n16 GB DDR 3 RAM         "+price+"         0"+nquantity+"      "+amt);
					break;
				case "112":
					textArea.setText(textArea.getText()+"\n160 GB Hard Disk        "+price+"         0"+nquantity+"      "+amt);
					break;
				case "113":
					textArea.setText(textArea.getText()+"\n320 GB Hard Disk        "+price+"         0"+nquantity+"      "+amt);
					break;
				case "114":
					textArea.setText(textArea.getText()+"\n500 GB Hard Disk        "+price+"         0"+nquantity+"      "+amt);
					break;
				case "115":
					textArea.setText(textArea.getText()+"\n1 TB Hard Disk          "+price+"         0"+nquantity+"      "+amt);
					break;
				case "116":
					textArea.setText(textArea.getText()+"\n14 Inch Monitor         "+price+"         0"+nquantity+"      "+amt);
					break;
				case "117":
					textArea.setText(textArea.getText()+"\n30 Inch Monitor         "+price+"        0"+nquantity+"      "+amt);
					break;
				case "118":
					textArea.setText(textArea.getText()+"\n40 Inch Monitor         "+price+"        0"+nquantity+"      "+amt);
					break;
				case "119":
					textArea.setText(textArea.getText()+"\n50 Inch Monitor         "+price+"        0"+nquantity+"      "+amt);
					break;
				case "120":
					textArea.setText(textArea.getText()+"\n120 GB SSD              "+price+"         0"+nquantity+"      "+amt);
					break;
				case "121":
					textArea.setText(textArea.getText()+"\n240 GB SSD              "+price+"        0"+nquantity+"      "+amt);
					break;
				case "122":
					textArea.setText(textArea.getText()+"\n500 GB SSD              "+price+"        0"+nquantity+"      "+amt);
					break;
				case "123":
					textArea.setText(textArea.getText()+"\n1 TB SSD                "+price+"        0"+nquantity+"      "+amt);
					break;
				case "124":
					textArea.setText(textArea.getText()+"\n32 GB Pendrive          "+price+"         0"+nquantity+"      "+amt);
					break;
				case "125":
					textArea.setText(textArea.getText()+"\n64 GB Pendrive          "+price+"         0"+nquantity+"      "+amt);
					break;
				case "126":
					textArea.setText(textArea.getText()+"\n128 GB Pendrive         "+price+"         0"+nquantity+"      "+amt);
					break;
				case "127":
					textArea.setText(textArea.getText()+"\n256 GB Pendrive         "+price+"         0"+nquantity+"      "+amt);
					break;
				
				
					
				}
				}
				if(quantity>=10 && a==0 && check==0) {
					totalamt+=amt;
					switch(id)
					{
					case "100":
						textArea.setText(textArea.getText()+"\n2 GB Graphic Card       "+price+"         "+nquantity+"      "+amt);
						break;
					case "101":
						textArea.setText(textArea.getText()+"\n4 GB Graphic Card       "+price+"        "+nquantity+"      "+amt);
						break;
					case "102":
						textArea.setText(textArea.getText()+"\n8 GB Graphic Card       "+price+"        "+nquantity+"      "+amt);
						break;
					case "103":
						textArea.setText(textArea.getText()+"\n11 GB Graphic Card      "+price+"        "+nquantity+"      "+amt);
						break;
					case "104":
						textArea.setText(textArea.getText()+"\nPentium Processor       "+price+"         "+nquantity+"      "+amt);
						break;
					case "105":
						textArea.setText(textArea.getText()+"\ni3 Processor            "+price+"         "+nquantity+"      "+amt);
						break;
					case "106":
						textArea.setText(textArea.getText()+"\ni5 Processor            "+price+"        "+nquantity+"      "+amt);
						break;
					case "107":
						textArea.setText(textArea.getText()+"\ni7 Processor            "+price+"        "+nquantity+"      "+amt);
						break;
					case "108":
						textArea.setText(textArea.getText()+"\n2 GB DDR 3 RAM          "+price+"         "+nquantity+"      "+amt);
						break;
					case "109":
						textArea.setText(textArea.getText()+"\n4 GB DDR 3 RAM          "+price+"         "+nquantity+"      "+amt);
						break;
					case "110":
						textArea.setText(textArea.getText()+"\n8 GB DDR 3 RAM          "+price+"         "+nquantity+"      "+amt);
						break;
					case "111":
						textArea.setText(textArea.getText()+"\n16 GB DDR 3 RAM         "+price+"         "+nquantity+"      "+amt);
						break;
					case "112":
						textArea.setText(textArea.getText()+"\n160 GB Hard Disk        "+price+"         "+nquantity+"      "+amt);
						break;
					case "113":
						textArea.setText(textArea.getText()+"\n320 GB Hard Disk        "+price+"         "+nquantity+"      "+amt);
						break;
					case "114":
						textArea.setText(textArea.getText()+"\n500 GB Hard Disk        "+price+"         "+nquantity+"      "+amt);
						break;
					case "115":
						textArea.setText(textArea.getText()+"\n1 TB Hard Disk          "+price+"         "+nquantity+"      "+amt);
						break;
					case "116":
						textArea.setText(textArea.getText()+"\n14 Inch Monitor         "+price+"         "+nquantity+"      "+amt);
						break;
					case "117":
						textArea.setText(textArea.getText()+"\n30 Inch Monitor         "+price+"        "+nquantity+"      "+amt);
						break;
					case "118":
						textArea.setText(textArea.getText()+"\n40 Inch Monitor         "+price+"        "+nquantity+"      "+amt);
						break;
					case "119":
						textArea.setText(textArea.getText()+"\n50 Inch Monitor         "+price+"        "+nquantity+"      "+amt);
						break;
					case "120":
						textArea.setText(textArea.getText()+"\n120 GB SSD              "+price+"         "+nquantity+"      "+amt);
						break;
					case "121":
						textArea.setText(textArea.getText()+"\n240 GB SSD              "+price+"        "+nquantity+"      "+amt);
						break;
					case "122":
						textArea.setText(textArea.getText()+"\n500 GB SSD              "+price+"        "+nquantity+"      "+amt);
						break;
					case "123":
						textArea.setText(textArea.getText()+"\n1 TB SSD                "+price+"        "+nquantity+"      "+amt);
						break;
					case "124":
						textArea.setText(textArea.getText()+"\n32 GB Pendrive          "+price+"         "+nquantity+"      "+amt);
						break;
					case "125":
						textArea.setText(textArea.getText()+"\n64 GB Pendrive          "+price+"         "+nquantity+"      "+amt);
						break;
					case "126":
						textArea.setText(textArea.getText()+"\n128 GB Pendrive         "+price+"         "+nquantity+"      "+amt);
						break;
					case "127":
						textArea.setText(textArea.getText()+"\n256 GB Pendrive         "+price+"         "+nquantity+"      "+amt);
						break;
					
						
					}
				}
				
				textprice.setText(null);
				textquantity.setText(null);
				textpid.setText(null);
				textquantity.setEditable(false);
				bg1.clearSelection();
				}
				catch(Exception d)
				{
					JOptionPane.showMessageDialog(btnAdd,"Please Enter Valid Quantity!!!");
				}
			}
				catch(Exception f)
				{
					JOptionPane.showMessageDialog(btnAdd, "Please Select a Product...");
				}

			}
		});
		btnAdd.setBounds(615, 356, 185, 30);
		contentPane.add(btnAdd);
		
		JPanel search_p = new JPanel();
		search_p.setBounds(230, 327, 322, 250);
		contentPane.add(search_p);
		search_p.setLayout(null);
		
		JLabel lblsearch = new JLabel("Search");
		lblsearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsearch.setBounds(126, 5, 61, 14);
		search_p.add(lblsearch);
		search_p.setVisible(false);
		
		JLabel lblProductId = new JLabel("Product ID:");
		lblProductId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductId.setBounds(10, 34, 84, 21);
		search_p.add(lblProductId);
		
		textproductID = new JTextField();
		textproductID.setToolTipText("Enter Product ID");
		textproductID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textproductID.setBounds(126, 34, 159, 20);
		search_p.add(textproductID);
		textproductID.setColumns(10);
		
		textPname = new JTextField();
		textPname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPname.setEditable(false);
		textPname.setColumns(10);
		textPname.setBounds(126, 65, 159, 20);
		search_p.add(textPname);
		
		textsprice = new JTextField();
		textsprice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textsprice.setEditable(false);
		textsprice.setColumns(10);
		textsprice.setBounds(126, 98, 159, 20);
		search_p.add(textsprice);
		
		JLabel lblproductname = new JLabel("Product Name:");
		lblproductname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblproductname.setBounds(10, 66, 84, 21);
		search_p.add(lblproductname);
		
		JLabel lblsprice = new JLabel("Price:");
		lblsprice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsprice.setBounds(10, 98, 84, 21);
		search_p.add(lblsprice);
		
		JButton btnsAdd = new JButton("ADD");
		btnsAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnsAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(s==0)
				{
					JOptionPane.showMessageDialog(btnsAdd,"Please Search The Product ID!!");
				}
				String id = textproductID.getText();
				double price = Double.parseDouble(textsprice.getText());
				try
				{
				double quantity = Double.parseDouble(textsquantity.getText());
				double amt=price*quantity;
				int a=0;
				nquantity = String.format("%.0f",quantity);
				if(quantity==0)
				{
					JOptionPane.showMessageDialog(btnAdd,"You Can't enter 0 for Quantity!!");
					a++;
				}
				if(quantity>99)
				{
					JOptionPane.showMessageDialog(btnAdd,"You Can't enter more than 99 for Quantity!!");
					a++;
				}
				if(check!=0)
				{
					JOptionPane.showMessageDialog(btnAdd,"Please Create New Receipt...");
				}
				if(quantity<10 && s!=0 && a==0 && check==0) {
					totalamt+=amt;
				switch(id)
				{
				case "100":
					textArea.setText(textArea.getText()+"\n2 GB Graphic Card       "+price+"         0"+nquantity+"      "+amt);
					s=0;
					break;
				case "101":
					textArea.setText(textArea.getText()+"\n4 GB Graphic Card       "+price+"        0"+nquantity+"      "+amt);
					s=0;
					break;
				case "102":
					textArea.setText(textArea.getText()+"\n8 GB Graphic Card       "+price+"        0"+nquantity+"      "+amt);
					s=0;
					break;
				case "103":
					textArea.setText(textArea.getText()+"\n11 GB Graphic Card      "+price+"        0"+nquantity+"      "+amt);
					s=0;
					break;
				case "104":
					textArea.setText(textArea.getText()+"\nPentium Processor       "+price+"         0"+nquantity+"      "+amt);
					s=0;
					break;
				case "105":
					textArea.setText(textArea.getText()+"\ni3 Processor            "+price+"         0"+nquantity+"      "+amt);
					s=0;
					break;
				case "106":
					textArea.setText(textArea.getText()+"\ni5 Processor            "+price+"        0"+nquantity+"      "+amt);
					s=0;
					break;
				case "107":
					textArea.setText(textArea.getText()+"\ni7 Processor            "+price+"        0"+nquantity+"      "+amt);
					s=0;
					break;
				case "108":
					textArea.setText(textArea.getText()+"\n2 GB DDR 3 RAM          "+price+"         0"+nquantity+"      "+amt);
					s=0;
					break;
				case "109":
					textArea.setText(textArea.getText()+"\n4 GB DDR 3 RAM          "+price+"         0"+nquantity+"      "+amt);
					s=0;
					break;
				case "110":
					textArea.setText(textArea.getText()+"\n8 GB DDR 3 RAM          "+price+"         0"+nquantity+"      "+amt);
					s=0;
					break;
				case "111":
					textArea.setText(textArea.getText()+"\n16 GB DDR 3 RAM         "+price+"         0"+nquantity+"      "+amt);
					s=0;
					break;
				case "112":
					textArea.setText(textArea.getText()+"\n160 GB Hard Disk        "+price+"         0"+nquantity+"      "+amt);
					s=0;
					break;
				case "113":
					textArea.setText(textArea.getText()+"\n320 GB Hard Disk        "+price+"         0"+nquantity+"      "+amt);
					s=0;
					break;
				case "114":
					textArea.setText(textArea.getText()+"\n500 GB Hard Disk        "+price+"         0"+nquantity+"      "+amt);
					s=0;
					break;
				case "115":
					textArea.setText(textArea.getText()+"\n1 TB Hard Disk          "+price+"         0"+nquantity+"      "+amt);
					s=0;
					break;
				case "116":
					textArea.setText(textArea.getText()+"\n14 Inch Monitor         "+price+"         0"+nquantity+"      "+amt);
					s=0;
					break;
				case "117":
					textArea.setText(textArea.getText()+"\n30 Inch Monitor         "+price+"        0"+nquantity+"      "+amt);
					s=0;
					break;
				case "118":
					textArea.setText(textArea.getText()+"\n40 Inch Monitor         "+price+"        0"+nquantity+"      "+amt);
					s=0;
					break;
				case "119":
					textArea.setText(textArea.getText()+"\n50 Inch Monitor         "+price+"        0"+nquantity+"      "+amt);
					s=0;
					break;
				case "120":
					textArea.setText(textArea.getText()+"\n120 GB SSD              "+price+"         0"+nquantity+"      "+amt);
					s=0;
					break;
				case "121":
					textArea.setText(textArea.getText()+"\n240 GB SSD              "+price+"        0"+nquantity+"      "+amt);
					s=0;
					break;
				case "122":
					textArea.setText(textArea.getText()+"\n500 GB SSD              "+price+"        0"+nquantity+"      "+amt);
					s=0;
					break;
				case "123":
					textArea.setText(textArea.getText()+"\n1 TB SSD                "+price+"        0"+nquantity+"      "+amt);
					s=0;
					break;
				case "124":
					textArea.setText(textArea.getText()+"\n32 GB Pendrive          "+price+"         0"+nquantity+"      "+amt);
					s=0;
					break;
				case "125":
					textArea.setText(textArea.getText()+"\n64 GB Pendrive          "+price+"         0"+nquantity+"      "+amt);
					s=0;
					break;
				case "126":
					textArea.setText(textArea.getText()+"\n128 GB Pendrive         "+price+"         0"+nquantity+"      "+amt);
					s=0;
					break;
				case "127":
					textArea.setText(textArea.getText()+"\n256 GB Pendrive         "+price+"         0"+nquantity+"      "+amt);
					s=0;
					break;
					
				}
				}
				if(quantity>=10 && s!=0 && a==0 && check==0) {
					totalamt+=amt;
					switch(id)
					{
					case "100":
						textArea.setText(textArea.getText()+"\n2 GB Graphic Card       "+price+"         "+nquantity+"      "+amt);
						s=0;
						break;
					case "101":
						textArea.setText(textArea.getText()+"\n4 GB Graphic Card       "+price+"        "+nquantity+"      "+amt);
						s=0;
						break;
					case "102":
						textArea.setText(textArea.getText()+"\n8 GB Graphic Card       "+price+"        "+nquantity+"      "+amt);
						s=0;
						break;
					case "103":
						textArea.setText(textArea.getText()+"\n11 GB Graphic Card      "+price+"        "+nquantity+"      "+amt);
						s=0;
						break;
					case "104":
						textArea.setText(textArea.getText()+"\nPentium Processor       "+price+"         "+nquantity+"      "+amt);
						s=0;
						break;
					case "105":
						textArea.setText(textArea.getText()+"\ni3 Processor            "+price+"         "+nquantity+"      "+amt);
						s=0;
						break;
					case "106":
						textArea.setText(textArea.getText()+"\ni5 Processor            "+price+"        "+nquantity+"      "+amt);
						s=0;
						break;
					case "107":
						textArea.setText(textArea.getText()+"\ni7 Processor            "+price+"        "+nquantity+"      "+amt);
						s=0;
						break;
					case "108":
						textArea.setText(textArea.getText()+"\n2 GB DDR 3 RAM          "+price+"         "+nquantity+"      "+amt);
						s=0;
						break;
					case "109":
						textArea.setText(textArea.getText()+"\n4 GB DDR 3 RAM          "+price+"         "+nquantity+"      "+amt);
						s=0;
						break;
					case "110":
						textArea.setText(textArea.getText()+"\n8 GB DDR 3 RAM          "+price+"         "+nquantity+"      "+amt);
						s=0;
						break;
					case "111":
						textArea.setText(textArea.getText()+"\n16 GB DDR 3 RAM         "+price+"         "+nquantity+"      "+amt);
						s=0;
						break;
					case "112":
						textArea.setText(textArea.getText()+"\n160 GB Hard Disk        "+price+"         "+nquantity+"      "+amt);
						s=0;
						break;
					case "113":
						textArea.setText(textArea.getText()+"\n320 GB Hard Disk        "+price+"         "+nquantity+"      "+amt);
						s=0;
						break;
					case "114":
						textArea.setText(textArea.getText()+"\n500 GB Hard Disk        "+price+"         "+nquantity+"      "+amt);
						s=0;
						break;
					case "115":
						textArea.setText(textArea.getText()+"\n1 TB Hard Disk          "+price+"         "+nquantity+"      "+amt);
						s=0;
						break;
					case "116":
						textArea.setText(textArea.getText()+"\n14 Inch Monitor         "+price+"         "+nquantity+"      "+amt);
						s=0;
						break;
					case "117":
						textArea.setText(textArea.getText()+"\n30 Inch Monitor         "+price+"        "+nquantity+"      "+amt);
						s=0;
						break;
					case "118":
						textArea.setText(textArea.getText()+"\n40 Inch Monitor         "+price+"        "+nquantity+"      "+amt);
						s=0;
						break;
					case "119":
						textArea.setText(textArea.getText()+"\n50 Inch Monitor         "+price+"        "+nquantity+"      "+amt);
						s=0;
						break;
					case "120":
						textArea.setText(textArea.getText()+"\n120 GB SSD              "+price+"         "+nquantity+"      "+amt);
						s=0;
						break;
					case "121":
						textArea.setText(textArea.getText()+"\n240 GB SSD              "+price+"        "+nquantity+"      "+amt);
						s=0;
						break;
					case "122":
						textArea.setText(textArea.getText()+"\n500 GB SSD              "+price+"        "+nquantity+"      "+amt);
						s=0;
						break;
					case "123":
						textArea.setText(textArea.getText()+"\n1 TB SSD                "+price+"        "+nquantity+"      "+amt);
						s=0;
						break;
					case "124":
						textArea.setText(textArea.getText()+"\n32 GB Pendrive          "+price+"         "+nquantity+"      "+amt);
						s=0;
						break;
					case "125":
						textArea.setText(textArea.getText()+"\n64 GB Pendrive          "+price+"         "+nquantity+"      "+amt);
						s=0;
						break;
					case "126":
						textArea.setText(textArea.getText()+"\n128 GB Pendrive         "+price+"         "+nquantity+"      "+amt);
						s=0;
						break;
					case "127":
						textArea.setText(textArea.getText()+"\n256 GB Pendrive         "+price+"         "+nquantity+"      "+amt);
						s=0;
						break;
					
						
					}
				}
				

				
				textPname.setText(null);
				textproductID.setText(null);
				textsquantity.setText(null);
				textsprice.setText(null);
				textsquantity.setEditable(false);
				}
				catch(Exception d)
				{
					JOptionPane.showMessageDialog(btnsAdd,"Please Enter Valid Quantity!!!");
				}
				
			}
		});
		btnsAdd.setBounds(185, 155, 100, 35);
		search_p.add(btnsAdd);
		
		JLabel lblsquantity = new JLabel("Quantity:");
		lblsquantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsquantity.setBounds(10, 130, 84, 21);
		search_p.add(lblsquantity);
		
		textsquantity = new JTextField();
		textsquantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textsquantity.setBounds(126, 124, 159, 20);
		search_p.add(textsquantity);
		textsquantity.setColumns(10);
		textsquantity.setEditable(false);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pid=textproductID.getText();
				textsquantity.setEditable(true);
				switch(pid)
				{
				case "100":
					textPname.setText("2 GB Graphic Card");
					textsprice.setText("5000");
					textsquantity.setText("1");
					s++;
					break;
				case "101":
					textPname.setText("4 GB Graphic Card");
					textsprice.setText("10000");
					textsquantity.setText("1");
					s++;
					break;
				case "102":
					textPname.setText("8 GB Graphic Card");
					textsprice.setText("20000");
					textsquantity.setText("1");
					s++;
					break;
				case "103":
					textPname.setText("11 GB Graphic Card");
					textsprice.setText("30000");
					textsquantity.setText("1");
					s++;
					break;
				case "104":
					textPname.setText("Pentium Processor");
					textsprice.setText("3000");
					textsquantity.setText("1");
					s++;
					break;
				case "105":
					textPname.setText("i3 Processor");
					textsprice.setText("7000");
					textsquantity.setText("1");
					s++;
					break;
				case "106":
					textPname.setText("i5 Processor");
					textsprice.setText("15000");
					textsquantity.setText("1");
					s++;
					break;
				case "107":
					textPname.setText("i7 Processor");
					textsprice.setText("30000");
					textsquantity.setText("1");
					s++;
					break;
				case "108":
					textPname.setText("2 GB RAM");
					textsprice.setText("1000");
					textsquantity.setText("1");
					s++;
					break;
				case "109":
					textPname.setText("4 GB RAM");
					textsprice.setText("2500");
					textsquantity.setText("1");
					s++;
					break;
				case "110":
					textPname.setText("8 GB RAM");
					textsprice.setText("4000");
					textsquantity.setText("1");
					s++;
					break;
				case "111":
					textPname.setText("16 GB RAM");
					textsprice.setText("8000");
					textsquantity.setText("1");
					s++;
					break;
				case "112":
					textPname.setText("160 GB Hard Disk");
					textsprice.setText("1000");
					textsquantity.setText("1");
					s++;
					break;
				case "113":
					textPname.setText("320 GB Hard Disk");
					textsprice.setText("1500");
					textsquantity.setText("1");
					s++;
					break;
				case "114":
					textPname.setText("500 GB Hard Disk");
					textsprice.setText("2000");
					textsquantity.setText("1");
					s++;
					break;
				case "115":
					textPname.setText("1 TB Hard Disk");
					textsprice.setText("2500");
					textsquantity.setText("1");
					s++;
					break;
				case "116":
					textPname.setText("14 Inch Monitor");
					textsprice.setText("7000");
					textsquantity.setText("1");
					s++;
					break;
				case "117":
					textPname.setText("30 Inch Monitor");
					textsprice.setText("10000");
					textsquantity.setText("1");
					s++;
					break;
				case "118":
					textPname.setText("40 Inch Monitor");
					textsprice.setText("15000");
					textsquantity.setText("1");
					s++;
					break;
				case "119":
					textPname.setText("50 Inch Monitor");
					textsprice.setText("20000");
					textsquantity.setText("1");
					s++;
					break;
				case "120":
					textPname.setText("120 GB SSD");
					textsprice.setText("5000");
					textsquantity.setText("1");
					s++;
					break;
				case "121":
					textPname.setText("240 GB SSD");
					textsprice.setText("10000");
					textsquantity.setText("1");
					s++;
					break;
				case "122":
					textPname.setText("500 GB SSD");
					textsprice.setText("15000");
					textsquantity.setText("1");
					s++;
					break;
				case "123":
					textPname.setText("1 TB SSD");
					textsprice.setText("20000");
					textsquantity.setText("1");
					s++;
					break;
				case "124":
					textPname.setText("32 GB Pendrive");
					textsprice.setText("1000");
					textsquantity.setText("1");
					s++;
					break;
				case "125":
					textPname.setText("64 GB Pendrive");
					textsprice.setText("2000");
					textsquantity.setText("1");
					s++;
					break;
				case "126":
					textPname.setText("128 GB Pendrive");
					textsprice.setText("5000");
					textsquantity.setText("1");
					s++;
					break;
				case "127":
					textPname.setText("256 GB Pendrive");
					textsprice.setText("7000");
					textsquantity.setText("1");
					s++;
					break;
				default:
					JOptionPane.showMessageDialog(btnSearch,"You Entered Invalid Product ID!!!");
					textproductID.setText(null);
					textsquantity.setEditable(false);
					
					
				}
			}
		});
		btnSearch.setBounds(34, 155, 100, 35);
		search_p.add(btnSearch);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(110, 201, 100, 23);
		search_p.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textproductID.setText(null);
				textsprice.setText(null);
				textsquantity.setText(null);
				textPname.setText(null);
				textsquantity.setEditable(false);
				search_p.setVisible(false);
				
			}
		});
		
		
		
		JLabel lblproduct_ID = new JLabel("Product ID:");
		lblproduct_ID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblproduct_ID.setBounds(615, 294, 185, 20);
		contentPane.add(lblproduct_ID);
		
		textpid = new JTextField();
		textpid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textpid.setEditable(false);
		textpid.setColumns(10);
		textpid.setBounds(615, 325, 185, 20);
		contentPane.add(textpid);
		
		JButton btnSearchProduct = new JButton("Search Product");
		btnSearchProduct.setBounds(615, 404, 185, 30);
		contentPane.add(btnSearchProduct);
		btnSearchProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textprice.setText(null);
				textquantity.setText(null);
				textpid.setText(null);
				search_p.setVisible(true);
				bg1.clearSelection();
				textquantity.setEditable(false);
			}
		});
		
		 btnPrint = new JButton("Print Receipt");
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPrint.setBounds(617, 499, 183, 41);
		contentPane.add(btnPrint);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(totalamt!=0)
				{
					check++;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date date = new Date();
				String total=String.format("%.2f", totalamt);
				double gst=totalamt*0.09;
				double gtotal=totalamt+gst+gst;
				textArea.setText("                         RECEIPT\n               DATE:"+sdf.format(date)+"\n"+textArea.getText());
				textArea.setText(textArea.getText()+"\n-------------------------------------------------------\n                              NET TOTAL : "+total);
				textArea.setText(textArea.getText()+"\n                                CGST 9% : "+gst);
				textArea.setText(textArea.getText()+"\n                                SGST 9% : "+gst);
				textArea.setText(textArea.getText()+"\n-------------------------------------------------------");
				textArea.setText(textArea.getText()+"\n                            GROSS TOTAL : "+gtotal);
				textArea.setText(textArea.getText()+"\n-------------------------------------------------------");
				//textArea.setText(textArea.getText()+"\n                         THANKS FOR VISITING...");
				btnPrint.setVisible(false);
				btnNew.setVisible(true);
				try {
				textArea.print();
				}
				catch(PrinterException d)
				{
					JOptionPane.showMessageDialog(null, d);
				}
				
				}
				if(totalamt==0) {
					JOptionPane.showMessageDialog(btnPrint, "Please Add Atleast One Product..");
				}
			}
		});
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBounds(615, 579, 183, 41);
		contentPane.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(btnClear,"Do You Want To Clear The Added Products?");
				if(choice==0)
				{
				btnPrint.setVisible(true);
				btnNew.setVisible(false);
				textArea.setText(" Product Name            Price       Quantity    AMT\n-------------------------------------------------------");
				totalamt=0;
				check=0;
				}
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit.setBounds(615, 656, 183, 41);
		contentPane.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Do You Want To Exit?");
				if(choice==0)
				{
				System.exit(0);
				}
			}
		});
		
		 btnNew = new JButton("New Receipt");
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNew.setBounds(617, 499, 183, 41);
		contentPane.add(btnNew);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            int choice = JOptionPane.showConfirmDialog(btnNew, "Do You Want TO Create New Receipt?");
            if(choice==0)
            {
				check=0;
				textArea.setText(" Product Name            Price       Quantity    AMT\n-------------------------------------------------------");
				totalamt=0;
				btnNew.setVisible(false);
				btnPrint.setVisible(true);
            }
				
			}
		});
		
		
		
		frame.setVisible(true);
		
		
		//Checkbox item listeners
		
		//graphic card
		cb2gbGC.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("5000");
					textquantity.setText("1");
					textpid.setText("100");
					textquantity.setEditable(true);
					
				}
				
			}
		});
		
		cb4gbGC.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("10000");
					textquantity.setText("1");
					textpid.setText("101");
					textquantity.setEditable(true);
					
				}
				
			}
		});
		
		cb8gbGC.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("20000");
					textquantity.setText("1");
					textpid.setText("102");
					textquantity.setEditable(true);
					
				}
				
			}
		});
		
		cb11gbGC.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("30000");
					textquantity.setText("1");
					textpid.setText("103");
					textquantity.setEditable(true);
					
				}
				
			}
		});
		
		//processor
		
		cbpenPR.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("3000");
					textquantity.setText("1");
					textpid.setText("104");
					textquantity.setEditable(true);
					
				}
				
			}
		});
		
		cbi3PR.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("7000");
					textquantity.setText("1");
					textpid.setText("105");
					textquantity.setEditable(true);
					
				}
				
			}
		});
		
		cbi5PR.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("15000");
					textquantity.setText("1");
					textpid.setText("106");
					textquantity.setEditable(true);
					
				}
				
			}
		});
		
		cbi7PR.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("30000");
					textquantity.setText("1");
					textpid.setText("107");
					textquantity.setEditable(true);
					
				}
				
			}
		});
		
		//RAM
		
		cb2gbRAM.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("1000");
					textquantity.setText("1");
					textpid.setText("108");
					textquantity.setEditable(true);
					
				}
				
			}
		});
		
		cb4gbRAM.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("2500");
					textquantity.setText("1");
					textpid.setText("109");
					textquantity.setEditable(true);
					
				}
				
			}
		});
		
		cb8gbRAM.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("4000");
					textquantity.setText("1");
					textpid.setText("110");
					textquantity.setEditable(true);
					
				}
				
			}
		});
		
		cb16gbRAM.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("8000");
					textquantity.setText("1");
					textpid.setText("111");
					textquantity.setEditable(true);
					
				}
				
			}
		});
		
		//Hard disk
		
		cb160HD.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("1000");
					textquantity.setText("1");
					textpid.setText("112");
					textquantity.setEditable(true);
				}
				
			}
		});
		
		cb320HD.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("1500");
					textquantity.setText("1");
					textpid.setText("113");
					textquantity.setEditable(true);
				}
				
			}
		});
		
		cb500HD.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("2000");
					textquantity.setText("1");
					textpid.setText("114");
					textquantity.setEditable(true);
				}
				
			}
		});
		
		cb1TBHD.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("2500");
					textquantity.setText("1");
					textpid.setText("115");
					textquantity.setEditable(true);
				}
				
			}
		});
		
		//Monitor
		
		cb14MN.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("7000");
					textquantity.setText("1");
					textpid.setText("116");
					textquantity.setEditable(true);
				}
				
			}
		});
		
		cb30MN.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("10000");
					textquantity.setText("1");
					textpid.setText("117");
					textquantity.setEditable(true);
				}
				
			}
		});
		
		cb40MN.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("15000");
					textquantity.setText("1");
					textpid.setText("118");
					textquantity.setEditable(true);
				}
				
			}
		});
		
		cb50MN.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("20000");
					textquantity.setText("1");
					textpid.setText("119");
					textquantity.setEditable(true);
				}
				
			}
		});
		
		//SSD
		cb120SSD.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("5000");
					textquantity.setText("1");
					textpid.setText("120");
					textquantity.setEditable(true);
				}
			}
		});
		
		cb240SSD.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("10000");
					textquantity.setText("1");
					textpid.setText("121");
					textquantity.setEditable(true);
				}
			}
		});
		
		cb500SSD.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("15000");
					textquantity.setText("1");
					textpid.setText("122");
					textquantity.setEditable(true);
				}
			}
		});
		
		cb1TBSSD.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("20000");
					textquantity.setText("1");
					textpid.setText("123");
					textquantity.setEditable(true);
				}
			}
		});
		
		//PENDRIVE
		cb32PEN.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("1000");
					textquantity.setText("1");
					textpid.setText("124");
					textquantity.setEditable(true);
				}
			}
		});
		
		cb64PEN.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("2000");
					textquantity.setText("1");
					textpid.setText("125");
					textquantity.setEditable(true);
				}
			}
		});
		
		cb128PEN.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("5000");
					textquantity.setText("1");
					textpid.setText("126");
					textquantity.setEditable(true);
				}
			}
		});
		
		cb256PEN.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					textprice.setText("7000");
					textquantity.setText("1");
					textpid.setText("127");
					textquantity.setEditable(true);
				}
			}
		});
		
	}
}
