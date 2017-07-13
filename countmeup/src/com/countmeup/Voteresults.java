package com.countmeup;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
public class Voteresults extends JFrame{
	ArrayList<Candidate> list_candidates;
	private JTextArea text_area;
	private Font font=new Font("Consolas",Font.BOLD,20);
	private DefaultTableModel tableMod;
	private JTable table;
	private static Toolkit toolkit =  Toolkit.getDefaultToolkit (); 
    private static int x=toolkit.getScreenSize().width;
	private static int y=toolkit.getScreenSize().height;
	private String[] str_column={"","",""};
	private DefaultTableCellRenderer rightRenderer;
	public Voteresults(ArrayList<Candidate> candidates_results){
		super("Count Me Up Excercise Assignment   Abebe Abera");
		Container c=getContentPane();
		c.setBackground(Color.blue);
		c.setLayout(new GridLayout(1,2));
		this.list_candidates=candidates_results;
		
		text_area=new JTextArea();
	    rightRenderer = new DefaultTableCellRenderer();
	    rightRenderer.setHorizontalAlignment( JLabel.CENTER);
	    tableMod=new DefaultTableModel();
        tableMod.addColumn("Candidates");
        tableMod.addColumn("#-votes");
        tableMod.addColumn("%");
        table=new JTable(tableMod); 
        JTableHeader header =table.getTableHeader();
        TableColumn column_1 = table.getColumnModel().getColumn(0); 
        TableColumn column_2 = table.getColumnModel().getColumn(1);  
        TableColumn column_3 = table.getColumnModel().getColumn(2);
        table.getColumnModel().getColumn(1).setCellRenderer( rightRenderer );
        table.getColumnModel().getColumn(2).setCellRenderer( rightRenderer );
        column_1.setMaxWidth(x/4);    
        column_2.setMaxWidth(x/4);    
        column_3.setMaxWidth(x/4);    
        table.setRowHeight(y/40);
        
        text_area.setFont(font);
	    header.setFont(font);
	    table.setFont(font);
	    
        int total_votes=totalVotes(candidates_results);
        text_area.append("\n Total # of votes: "+total_votes);
        for (int k=0;k<candidates_results.size();k++){
          tableMod.addRow(str_column);
          tableMod.setValueAt(candidates_results.get(k).candidat_name,k,0);
          tableMod.setValueAt(candidates_results.get(k).number_of_votes,k,1);
          tableMod.setValueAt(getPersentage(candidates_results.get(k).number_of_votes,total_votes),k,2);}
        
	    c.add(new JScrollPane(text_area));
		c.add(new JScrollPane(table));}
	
	public int totalVotes(ArrayList<Candidate> list_candidates) {
		int total_num=0;
		for (int k4=0;k4<list_candidates.size();k4++)
			total_num=total_num+list_candidates.get(k4).number_of_votes;
		return total_num;}
	
	public int getPersentage(int candidate_num_votes, int total_votes) {
		return (int)((candidate_num_votes*100)/total_votes);}}
