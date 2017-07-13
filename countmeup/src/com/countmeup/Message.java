package com.countmeup;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Message extends JDialog{
	public Font font=new Font("Consolas",Font.BOLD,20);
	public JTextArea text;
	public Message(String msg){
		JPanel panel=(JPanel)getContentPane();
		panel.setBackground(Color.white);
		text=new JTextArea();
		text.setEditable(false);
		text.setFont(font);
		text.append(msg);
		getContentPane().add(text);
		panel.setBorder(new EmptyBorder(30, 30, 30, 30));
		pack();}}

