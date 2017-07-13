package com.countmeup;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class Mainscreen extends JFrame implements ActionListener,ListSelectionListener,SimpleMethods {
	private ArrayList<User> users_array;
	private ArrayList<Candidate> candidates_array;
	private ArrayList<String> list_temp;
	private JPanel panel_left,panel_right,panel_south,p1,p2,p3,p4,p5,p6,p7;
	private JLabel candidate_label,candidate_label_2;
	private Font font=new Font("Consolas",Font.BOLD,20);
	private TextField candidate_field;
	private JButton register,results;
	private DefaultTableModel tableMod;
	private JTable table;
	private TextField user_field;
	private static Toolkit toolkit =  Toolkit.getDefaultToolkit (); 
    private static int x=toolkit.getScreenSize().width;
	private static int y=toolkit.getScreenSize().height;	
	private String[] str_column={""};
	private int index;
	private JDialog mesg;
	private static Mainscreen frame;
	public Mainscreen(){
		super("Count Me Up Excercise Assignment   Abebe Abera");
		Container c=getContentPane();
		c.setBackground(Color.LIGHT_GRAY);
		
		panel_left=new JPanel();
		panel_south=new JPanel();
		panel_right=new JPanel();
	    p1=new JPanel();
	    p2=new JPanel();
	    p3=new JPanel();
	    p4=new JPanel();
	    p5=new JPanel();
	    p6=new JPanel();
	    p7=new JPanel();
	    c.setLayout(new GridLayout(1,2,10,0));
	    panel_south.setLayout(new GridLayout(5,1,0,5));
	    panel_right.setLayout(new GridLayout(2,1));
	    panel_left.setLayout(new GridLayout(10,1,0,5));
	    p1.setLayout(new GridLayout(1,3));
	    p2.setLayout(new GridLayout(1,3));
	    p3.setLayout(new GridLayout(1,3));
	    p4.setLayout(new GridLayout(1,3));
	    p5.setLayout(new GridLayout(1,3));
	    p6.setLayout(new GridLayout(1,3));
	    p7.setLayout(new GridLayout(1,3));
	    
	    users_array=new ArrayList<User>();
		candidates_array=new ArrayList<Candidate>();
		//----------------------------------------Panel Left--------------------------------------------------
	    candidate_field=new TextField("");
	    register=new JButton("Register");
	    results=new JButton("Results");
	    candidate_label=new JLabel("Candidate:",JLabel.LEFT);
	    register.addActionListener(this);
	    results.addActionListener(this);
	    candidate_field.setFont(font);
	    register.setFont(font);
	    candidate_label.setFont(font);
	    results.setFont(font);
	    candidate_label.setFont(font);
	    
	    p1.add(new JPanel());
	    p1.add(candidate_label);
	    p1.add(new JPanel());
	    p2.add(new JPanel());
	    p2.add(candidate_field);
	    p2.add(new JPanel());
	    p3.add(new JPanel());
	    p3.add(register);
	    p3.add(new JPanel());
	    p4.add(new JPanel());
	    p4.add(results);
	    p4.add(new JPanel());
	    panel_left.add(new JPanel());
	    panel_left.add(p1);
	    panel_left.add(p2);
	    panel_left.add(new JPanel());
	    panel_left.add(p3);
	    panel_left.add(new JPanel());
	    panel_left.add(new JPanel());
	    panel_left.add(new JPanel());
	    panel_left.add(p4);
	    panel_left.add(new JPanel());
	    //------------------------------------------Panel Right-------------------------------------------
	    tableMod=new DefaultTableModel();
        tableMod.addColumn("Candidates name");
        table=new JTable(tableMod); 
        JTableHeader header =table.getTableHeader();
        TableColumn column = table.getColumnModel().getColumn(0);  
        ListSelectionModel listMod =  table.getSelectionModel();
        listMod.addListSelectionListener(this);
        table.setRowHeight(y/40);
        for (index=0;index<candidates_array.size();index++){
          tableMod.addRow(str_column);
          tableMod.setValueAt(candidates_array.get(index).candidat_name,index,0);}
	    user_field=new TextField();
	    register=new JButton("Confirm");
	    candidate_label_2=new JLabel("",JLabel.LEFT);
	    register.addActionListener(this);
	    
	    user_field.setFont(font);
	    register.setFont(font);
	    header.setFont(font);
	    table.setFont(font);
	    candidate_label_2.setFont(font);
	    
	    p5.add(new JPanel());
	    p5.add(candidate_label_2);
	    p5.add(new JPanel());
	    p6.add(new JPanel());
	    p6.add(user_field);
	    p6.add(new JPanel());
	    p7.add(new JPanel());
	    p7.add(register);
	    p7.add(new JPanel());
	    panel_south.add(new JPanel());
	    panel_south.add(p5);
	    panel_south.add(p6);
	    panel_south.add(p7);
	    panel_south.add(new JPanel());
	    panel_right.add(new JScrollPane(table));
	    panel_right.add(panel_south);
	    //------------------------------------------------------------------------------------------
	    c.add(panel_left);
		c.add(panel_right);}
	
	public void displayMsg(String str_message){
		mesg=new Message(str_message);
		mesg.setTitle("Message");
		mesg.setLocationRelativeTo(null);
        mesg.setVisible(true);}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		switch(event.getActionCommand()){
		   case "Register":
			    String candidate_name=candidate_field.getText().trim();
			    if (candidate_name.length()==0){
			    	displayMsg("Candidate name must be enetred");
					return;}
				if (candidate_name.length()>30){
					displayMsg("Field too long");
					return;}
				if (candidateRegistered(candidates_array,candidate_name)){
					displayMsg(candidate_name+" already registered");
					return;}
				candidates_array.add(new Candidate(candidate_name,0));
				tableMod.addRow(str_column);
		        tableMod.setValueAt(candidate_name,index,0);
		        index=index+1;
		        candidate_field.setText("");
		        displayMsg(candidate_name+" is now registered");
		        break;
		   case "Confirm":
			    String concat="";
			    String candidate_label=candidate_label_2.getText().trim();
			    String user_entry=user_field.getText().trim();
			    if (candidate_label.length()==0){displayMsg("Candidate name must be enetred");return;}
			    if (user_entry.length()==0){displayMsg("User name must be enetred");return;}
				if (user_entry.length()>30){displayMsg("User name too long");return;}
			    int user_index=findUser(user_entry,users_array);
			    int candidate_index=findCandidate(candidate_label,candidates_array);
			    int candidate_vote_nums=candidates_array.get(candidate_index).number_of_votes;
			    if (user_index==-1){
			    	list_temp=new ArrayList<String>();
			    	list_temp.add(candidate_label);
			    	users_array.add(new User(user_entry,list_temp));
			    	candidates_array.set(candidate_index, new Candidate(candidate_label,candidate_vote_nums+1));
			    	displayMsg("You voted to:\n"+candidate_label);
			    	candidate_label_2.setText("");
			    	user_field.setText("");}
			    else{
			    	ArrayList<String> liked_candidates=users_array.get(user_index).liked_candidates;
					if (liked_candidates.size()==3){
					  concat="";
					  concat=concat+"Number of votes allowed per person is 3\n\n";
					  concat=concat+"You have already voted for the following candidates:\n";
					  concat=concat+getUsersVotes(user_entry,liked_candidates);
					  displayMsg(concat);
					  user_field.setText("");}
					else{
					  liked_candidates.add(new String(candidate_label));
					  users_array.set(user_index, new User(user_entry,liked_candidates));	
					  candidates_array.set(candidate_index, new Candidate(candidate_label,candidate_vote_nums+1));
					  concat="You have eleccted to:\n";
					  concat=concat+getUsersVotes(user_entry,liked_candidates);
					  displayMsg(concat);
					  candidate_label_2.setText("");
				      user_field.setText("");}} 
			    break;
		   case "Results":
			    Voteresults frame_2=new Voteresults(candidates_array);
			    frame_2.setLocation(Math.max(0,(x-x*1/2)/2),Math.max(0,(y-y*1/2)/2));
			    frame_2.setSize(x*1/2,y*1/2);
			    frame_2.setVisible(true);
			    frame_2.setAlwaysOnTop(true);
			    frame_2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			    frame_2.setResizable(false);
			    break;
		   case "Exit":
			    System.exit(0);}}
	
	public static void main(String[] args) {
		frame=new Mainscreen();
	    frame.setLocation(Math.max(0,(x-x*1/2)/2),Math.max(0,(y-y*2/5)/2));
	    frame.setSize(x*1/2,y*2/5);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setResizable(false);}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		if (event.getValueIsAdjusting()) return;
		candidate_label_2.setText(table.getValueAt(table.getSelectedRow(),0).toString().trim());}

	@Override
	public int findUser(String user_name, ArrayList<User> user_list) {
		for (int k=0;k<user_list.size();k++){
			if (user_list.get(k).user_name.equalsIgnoreCase(user_name))
			  return k;}
		return -1;}

	@Override
	public boolean candidateRegistered(ArrayList<Candidate> list_candidates2, String string) {
		if (list_candidates2==null) return false;
		if (string==null) return false;
		if (string.length()==0) return false;
		for (int k1=0;k1<list_candidates2.size();k1++){
			if (string.equalsIgnoreCase(list_candidates2.get(k1).candidat_name)) return true;}
		return false;}

	@Override
	public String getUsersVotes(String user_name, ArrayList<String> liked_candidates2) {
		String concat="";
		for (int k2=0;k2<liked_candidates2.size();k2++)
		   concat=concat+liked_candidates2.get(k2)+"\n";
		return concat;}

	@Override
	public int findCandidate(String string, ArrayList<Candidate> list_candidates2) {
		if (list_candidates2==null) return -1;
		if (string==null) return -1;
		if (string.length()==0) return -1;
		for (int k2=0;k2<list_candidates2.size();k2++){
			if (string.equalsIgnoreCase(list_candidates2.get(k2).candidat_name))
				return k2;}
		return -1;}}
