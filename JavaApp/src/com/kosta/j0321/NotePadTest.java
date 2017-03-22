package com.kosta.j0321;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NotePadTest extends JFrame implements ActionListener{
	
	JTextArea ta;
	JScrollPane scroll;
	JMenuBar menuBar;
	JMenu file, help;
	JMenuItem open, save, save_as, exit, guide;
	JFileChooser jfc;
	boolean modified;
	boolean newFile = true;
	JOptionPane pane;
	File thisFile;
	
	public NotePadTest() {
		
		setTitle("제목없음");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//객체생성
		pane = new JOptionPane();
		ta = new JTextArea();
		scroll = new JScrollPane(ta);
		menuBar = new JMenuBar();
		file = new JMenu("파일");
		help = new JMenu("도움말");
		open = new JMenuItem("열기");
		save = new JMenuItem("저장");
		save_as = new JMenuItem("다른이름으로 저장");
		exit = new JMenuItem("종료");
		guide = new JMenuItem("도움말");
		jfc = new JFileChooser();
		
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		save_as.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		save_as.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.SHIFT_MASK+Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

		//속성설정
		file.add(open);
		file.add(save);
		file.add(save_as);
		file.addSeparator();//구분선 표시
		file.add(exit);
		help.add(guide);
		menuBar.add(file);
		menuBar.add(help);
		
		jfc.addChoosableFileFilter(new FileNameExtensionFilter(".txt", "txt"));
		jfc.addChoosableFileFilter(new FileNameExtensionFilter(".java", "java"));
		jfc.setAcceptAllFileFilterUsed(true);
		
		add(scroll);
		
		//마무리
		setJMenuBar(menuBar);
		setBounds(450,120,600,600);
		setVisible(true);
		
		open.addActionListener(this);
		save.addActionListener(this);
		save_as.addActionListener(this);
		exit.addActionListener(this);
		guide.addActionListener(this);
		ta.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				modified = true;
			}
			
		});
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				
				if(modified){
					int save = JOptionPane.showConfirmDialog(ta, "저장되지 않았습니다. 변경된 내용을 저장하시겠습니까?");
					if(save == 0){
						try{
							saveFile();
						} catch(IOException ioe){
							ioe.printStackTrace();	
						}
					} else if(save == 1){
						System.exit(0);
					} else {
						
					}
				} else {
					System.exit(0);
				}
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
			
			try{
			
				if(newFile){
					saveAsFile();
				} else {
					saveFile();
				}
			
			} catch(IOException ie){
				ie.printStackTrace();
			}
			
		} else if (ob == save_as){
			
			try {
				saveAsFile();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
		} else if (ob == exit){
			
			if(!modified){
				System.exit(0);
			} else {
				
				try{
				
					int save = JOptionPane.showConfirmDialog(this, "저장하지 않고 종료하시겠습니까?");
					if(save == 0){
						System.exit(0);
					} else if(save == 1){
						if(newFile){
							saveAsFile();
							
						} else {
							saveFile();
						}
					} else {
						
					}
					
				} catch(IOException ie2){
					ie2.printStackTrace();
				}
			}
		} else if(ob == guide){
			
			//new JLabel(new ImageIcon("image/iMac-icon.png"))
			//pane.add(new JLabel(new ImageIcon("image/iMac-icon.png")));
			pane.setIcon(new ImageIcon("image/note_icon.png"));
			pane.setMessage("<NotePad>\n버전: 1.0.0\n제작자: M.K.Chung\n제작날짜: 2017년 3월 21일\n연락처: wjdaudrb7@naver.com");
			
			JDialog d = pane.createDialog(this, "도움말");
		    d.setVisible(true);
		}
	}
	
	//my solution
	public void openFile() throws IOException{
		
		if(jfc.showOpenDialog(this) == jfc.APPROVE_OPTION){
			
			thisFile = jfc.getSelectedFile();
			FileReader fr = new FileReader(thisFile);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			ta.setText("");
			while((line = br.readLine()) != null){
				ta.append(line+"\n");
			}
			
			//fis.close();
			fr.close();
			br.close();
			
			int desc = thisFile.toString().lastIndexOf('/');
			setTitle(thisFile.toString().substring(desc+1));
			
			modified = false;
			newFile = false;
		} else {
			modified = true;
		}
	}
	
	public void saveFile() throws IOException{
		
			String str = ta.getText();
			
			FileFilter a = jfc.getFileFilter();
			FileWriter fw = new FileWriter(thisFile.getName() + a.getDescription());		
			//BufferedWriter bw = new BufferedWriter(fw);
			
			str = str.replace("\n", "\r\n");
			fw.write(str);
			
			//ta.write(bw);
			fw.close();
			//bw.close();
			
			int desc = thisFile.toString().lastIndexOf('/');
			int desc2 = thisFile.toString().lastIndexOf('.');
			
			if(!newFile){
				jfc.setSelectedFile(thisFile);
			}
	
			//setTitle(thisFile.toString().substring(desc + 1, desc2) + a.getDescription());
			setTitle(thisFile.getName());
			JOptionPane.showMessageDialog(this, "저장이 완료되었습니다.");
			modified = false;
			
	}
	
	public void saveAsFile() throws IOException{
		
		if(newFile){
			jfc.setSelectedFile(new File("제목없음"));
		} else {
			
			int oldFile = thisFile.toString().lastIndexOf('/');
			int oldFile2 = thisFile.toString().lastIndexOf('.');
			
			jfc.setSelectedFile(new File(thisFile.toString().substring(oldFile + 1,oldFile2)));
			
		}
		
		if(jfc.showSaveDialog(this) == jfc.APPROVE_OPTION){
			
			String str = ta.getText().trim();
			File fileName = jfc.getSelectedFile();
			
			FileFilter a = jfc.getFileFilter();
			
			if(!newFile){
				if(new File(fileName + thisFile.toString().substring(thisFile.toString().lastIndexOf('.'))).exists()){
					
					int existName = JOptionPane.showConfirmDialog(this, "이미 파일이 존재합니다. 덮어 쓰시겠습니까?");
					if(existName == 0){
						FileWriter fw = new FileWriter(fileName + a.getDescription());
						BufferedWriter bw = new BufferedWriter(fw);
						ta.write(bw);
						fw.close();
						bw.close();
						
						int desc = fileName.toString().lastIndexOf('/');
						int desc2 = fileName.toString().lastIndexOf('.');
						
						setTitle(fileName.getName() + a.getDescription());
						JOptionPane.showMessageDialog(this, "저장이 완료되었습니다.");
						modified = false;
					} else {
						saveAsFile();
					}
				} else {
					FileWriter fw = new FileWriter(fileName + a.getDescription());
					BufferedWriter bw = new BufferedWriter(fw);
					ta.write(bw);
					fw.close();
					bw.close();
					
					int desc = fileName.toString().lastIndexOf('/');
					
					setTitle(fileName.toString().substring(desc + 1) + a.getDescription());
					JOptionPane.showMessageDialog(this, "저장이 완료되었습니다.");
					modified = false;
				}
				
			}else {
			
			FileWriter fw = new FileWriter(fileName + a.getDescription());
			BufferedWriter bw = new BufferedWriter(fw);
			ta.write(bw);
			fw.close();
			bw.close();
			
			int desc = fileName.toString().lastIndexOf('/');
			
			setTitle(fileName.toString().substring(desc + 1) + a.getDescription());
			JOptionPane.showMessageDialog(this, "저장이 완료되었습니다.");
			modified = false;
			
			}
			
		} else {
			modified = true;
		}
	}
	
	//수업내용기반
	public void fromFile() throws IOException{
		if(jfc.showOpenDialog(this) == jfc.APPROVE_OPTION){
			File f = jfc.getSelectedFile();
			//FileInputStream fis = new FileInputStream(f);
			FileReader fr = new FileReader(f);
			ta.setText("");
			//byte b[] = new byte[512];
			char ch[] = new char[512];
			int i;
			while((i = fr.read(ch)) != -1){
				ta.append(new String(ch,0,i));
			}
			//fis.close();
			fr.close();
		}
	}

}
