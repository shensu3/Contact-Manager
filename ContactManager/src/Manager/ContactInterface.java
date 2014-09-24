package Manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JPasswordField;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTable;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.DocumentFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//JFrame that handles the UI part and the interactions.
public class ContactInterface extends JFrame {
	public static File file;
	private JPanel contentPane;
	public static int position; //variable to store row position 
	//text fields.
	public static JTextField text_fname;
	public static JTextField text_midname;
	public static JTextField text_lname;
	public static JTextField text_addr1;
	public static JTextField text_addr2;
	public static JTextField text_city;
	public static JTextField text_state;
	public static JTextField text_zip;
	public static JTextField text_phnum;
	public static JTextField text_gender;
	public static JTable table_1;
	public static ArrayList<Data> contacts = new ArrayList<Data>(); //contacts arraylist stores all the file data
	private String[] columnNames = {"Name","Phone Number"}; //column names for the j table 
	public static DefaultTableModel tableModel; 
	public static JTextField textField;
	/**
	 * Launch the application.
	 * main function.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactInterface frame = new ContactInterface("Contact Manager");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame with constraints.
	 */
	public ContactInterface(String title) {
		FileIO.init();
		this.setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 520);
		contentPane=new JPanel();
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.add(contentPane);
		contentPane.setLayout(null);

		//JTable settings 
		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableModel = (DefaultTableModel)table_1.getModel();
		tableModel.addColumn(columnNames[0]);
		tableModel.addColumn(columnNames[1]);
		StateInfo.Array_Table();
		table_1.setModel(tableModel);
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(108, 355, 488, 111);
		table_1.setFillsViewportHeight(true);
		contentPane.add(scrollPane_1);
		//listener function listens to selection and updates row variable and calls fillData()
		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent event) {
		            if (event.getValueIsAdjusting()) {
		                return;
		            }
		            position=table_1.getSelectedRow();
		            StateInfo.fillData();
		         }
			});
		
		// Text fields with listeners to limit the maximum number of characters -----
		text_fname = new JTextField(20);
		text_fname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(text_fname.getText().length()>=20)
					text_fname.setText(text_fname.getText().substring(0,19));
			}
		});
		text_fname.setBounds(108, 32, 86, 20);
		contentPane.add(text_fname);
		text_fname.setColumns(10);
		
		text_midname = new JTextField(1);
		text_midname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(text_midname.getText().length()>=1)
					text_midname.setText(text_midname.getText().substring(0,0));
			}
		});
		text_midname.setBounds(311, 32, 47, 20);
		contentPane.add(text_midname);
		text_midname.setColumns(10);
		
		text_lname = new JTextField(20);
		text_lname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(text_lname.getText().length()>=20)
					text_lname.setText(text_lname.getText().substring(0,19));
			}
		});
		text_lname.setBounds(495, 32, 86, 20);
		contentPane.add(text_lname);
		text_lname.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name*");
		lblFirstName.setBounds(108, 7, 86, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("Middle Initial");
		lblMiddleName.setBounds(296, 7, 101, 14);
		contentPane.add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name*");
		lblLastName.setBounds(485, 7, 96, 14);
		contentPane.add(lblLastName);
		
		text_addr1 = new JTextField(35);
		text_addr1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(text_addr1.getText().length()>=35)
					text_addr1.setText(text_addr1.getText().substring(0,34));
			}
		});
		text_addr1.setBounds(189, 81, 408, 20);
		contentPane.add(text_addr1);
		text_addr1.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address 1*");
		lblAddress.setBounds(108, 84, 64, 14);
		contentPane.add(lblAddress);
		
		JLabel lblNewLabel = new JLabel("Address 2");
		lblNewLabel.setBounds(109, 121, 63, 14);
		contentPane.add(lblNewLabel);
		
		text_addr2 = new JTextField(35);
		text_addr2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(text_addr2.getText().length()>=35)
					text_addr2.setText(text_addr2.getText().substring(0,34));
			}
		});
		text_addr2.setBounds(189, 118, 409, 20);
		contentPane.add(text_addr2);
		text_addr2.setColumns(10);
		
		text_city = new JTextField(25);
		text_city.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(text_city.getText().length()>=25)
					text_city.setText(text_city.getText().substring(0,24));
			}
		});
		text_city.setBounds(108, 177, 168, 20);
		contentPane.add(text_city);
		text_city.setColumns(10);
		
		text_state = new JTextField(2);
		text_state.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(text_state.getText().length()>=2)
					text_state.setText(text_state.getText().substring(0,1));
			}
		});
		text_state.setBounds(355, 177, 30, 20);
		contentPane.add(text_state);
		text_state.setColumns(10);
		
		text_zip = new JTextField(9);
		text_zip.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(text_zip.getText().length()>=9)
					text_zip.setText(text_zip.getText().substring(0,8));
			}
		});
		text_zip.setBounds(511, 177, 86, 20);
		contentPane.add(text_zip);
		text_zip.setColumns(10);
		
		JLabel lblCity = new JLabel("City*");
		lblCity.setBounds(113, 159, 53, 14);
		contentPane.add(lblCity);
		
		JLabel lblState = new JLabel("State*");
		lblState.setBounds(355, 159, 53, 14);
		contentPane.add(lblState);
		
		JLabel lblZipCode = new JLabel("Zip Code*");
		lblZipCode.setBounds(505, 156, 78, 20);
		contentPane.add(lblZipCode);
		
		text_phnum = new JTextField(21);
		text_phnum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(text_phnum.getText().length()>=21)
					text_phnum.setText(text_phnum.getText().substring(0,20));
			}
		});
		text_phnum.setBounds(232, 214, 133, 20);
		contentPane.add(text_phnum);
		text_phnum.setColumns(10);
		
		text_gender = new JTextField(1);
		text_gender.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(text_gender.getText().length()>=1)
					text_gender.setText(text_gender.getText().substring(0,0));
			}
		});
		text_gender.setBounds(555, 214, 40, 20);
		contentPane.add(text_gender);
		text_gender.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Phone Number*");
		lblNewLabel_1.setBounds(108, 217, 112, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblGender = new JLabel("Gender*");
		lblGender.setBounds(469, 217, 61, 14);
		contentPane.add(lblGender);
	
		// JButtons with their respective listeners to trigger the functions upon a click action.
		JButton btnStore = new JButton("Store");
		btnStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileIO.store(); //calls store()
			}
		});
		btnStore.setBounds(105, 278, 89, 23);
		contentPane.add(btnStore);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileIO.modify(); // calls modify()
			}
		});
		btnModify.setBounds(242, 278, 89, 23);
		contentPane.add(btnModify);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileIO.delete(); // calls delete()
			}
		});
		btnDelete.setBounds(369, 278, 89, 23);
		contentPane.add(btnDelete);
		
		textField = new JTextField();
		textField.setBounds(411, 312, 181, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel lblStatus = new JLabel("Status ");
		lblStatus.setBounds(355, 327, 46, 14);
		contentPane.add(lblStatus);
		
		JLabel lblSelectContactTo = new JLabel("Select contact to edit");
		lblSelectContactTo.setBounds(114, 330, 133, 14);
		contentPane.add(lblSelectContactTo);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StateInfo.clear(); // calls clear()
			}
		});
		btnClear.setBounds(492, 278, 89, 23);
		contentPane.add(btnClear);
	
		getContentPane().add(scrollPane);
		this.setResizable(false);
		this.setMaximumSize(this.getSize());
	}
}
