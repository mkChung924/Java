package com.kosta.j0321;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NotePadTest extends JFrame implements ActionListener{
	
	JTextArea ta;
	JScrollPane scroll;
	JMenuBar menuBar;
	JMenu file, help;
	JMenuItem open, save, exit, guide;
	JFileChooser jfc;
	boolean modified;
	
	public NotePadTest() {
		
		setTitle("제목없음");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//객체생성
		ta = new JTextArea();
		scroll = new JScrollPane(ta);
		menuBar = new JMenuBar();
		file = new JMenu("파일");
		help = new JMenu("도움말");
		open = new JMenuItem("열기");
		save = new JMenuItem("저장");
		exit = new JMenuItem("종료");
		guide = new JMenuItem("도움말");
		
		jfc = new JFileChooser();
		
		//속성설정
		file.add(open);
		file.add(save);
		file.addSeparator();//구분선 표시
		file.add(exit);
		help.add(guide);
		menuBar.add(file);
		menuBar.add(help);
		
		jfc.addChoosableFileFilter(new FileNameExtensionFilter(".txt", "txt"));
		jfc.setAcceptAllFileFilterUsed(true);
		
		add(scroll);
		
		//마무리
		setJMenuBar(menuBar);
		setBounds(450,150,600,600);
		setVisible(true);
		
		open.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		guide.addActionListener(this);
		ta.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				modified = true;
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		new NotePadTest();
	}

	@Override
	public void actionPerformed(ActionEvent e){
		Object ob = e.getSource();
		if(ob == open){
			
			try {
				openFile();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
		} else if (ob == save){
			
				try {
					saveFile();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			
			
		} else if (ob == exit){
			
			if(!modified){
				System.exit(0);
			} else {
				
				int save = JOptionPane.showConfirmDialog(this, "저장하지 않고 종료하시겠습니까?");
				if(save == 0){
					System.exit(0);
				}
			}
		} else if(ob == guide){
			
			JOptionPane.showMessageDialog(this, "도움말");
			
		}
	}
	
	public void openFile() throws IOException{
		
		if(jfc.showOpenDialog(this) == jfc.APPROVE_OPTION){
			
			
			File fileName = jfc.getSelectedFile();
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
					
			String line;
			while((line = br.readLine()) != null){
				ta.setText(line);
			}
			
			//fis.close();
			fr.close();
			br.close();
			
			modified = false;
		} else {
			modified = true;
		}
	}
	
	public void saveFile() throws IOException{
		jfc.setSelectedFile(new File("제목없음"));
		
		if(jfc.showSaveDialog(this) == jfc.APPROVE_OPTION){
			
			String str = ta.getText().trim();
			File fileName = jfc.getSelectedFile();
			
			FileFilter a = jfc.getFileFilter();
			FileWriter fw = new FileWriter(fileName + a.getDescription());
			
			BufferedWriter bw = new BufferedWriter(fw);
			ta.write(bw);
			fw.close();
			bw.close();
	
			int desc = fileName.toString().lastIndexOf('/');
			setTitle(fileName.toString().substring(desc + 1) + a.getDescription());
			JOptionPane.showMessageDialog(this, "저장이 완료되었습니다.");
			modified = false;
			
			
		} else {
			modified = true;
		}
	}
	
	public void fromFile() throws IOException{
		if(jfc.showOpenDialog(this) == jfc.APPROVE_OPTION){
			File f = jfc.getSelectedFile();
			FileInputStream fis = new FileInputStream(f);
			ta.setText("");
			byte b[] = new byte[512];
			int i;
			while((i = fis.read(b)) != -1){
				ta.append(new String(b,0,i));
			}
			fis.close();
		}
	}

}
