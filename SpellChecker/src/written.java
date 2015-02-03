import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Highlighter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class written extends JFrame {

    private JTextPane textPane;
	private JLabel timeCount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					written frame = new written();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public written() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
        JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 69, 584, 392);
		contentPane.add(scrollPane);
		
		textPane = new JTextPane();
        /*
		textPane.addKeyListener(new KeyAdapter() {
				
			String newWord = "";
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println(textPane.getCaretPosition());

				if(e.getKeyChar()==(' ')||e.getKeyChar()==('\n'))
				{
					Mainframe.check(newWord);
					System.out.println("checked");
				}
				if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE&&newWord.length()>0)
				{
					
					newWord = newWord.substring(0, newWord.length()-1);
					System.out.println("erased");
				}
				newWord=newWord+e.getKeyChar();
			}
		});*/
		scrollPane.setViewportView(textPane);
		textPane.getDocument().addDocumentListener(new DocumentListener(){
			Highlighter h = textPane.getHighlighter();
			
			  public void changedUpdate(DocumentEvent e) {
				  //h.addHighlight(i, temp.length(), DefaultHighlighter.DefaultPainter);
				  }
				  public void removeUpdate(DocumentEvent e) {
				   
					  if(textPane.getText().equals(""))
					    {
					    	System.out.println("empty");
					    	//textPane.setText("");
					    }
					  
				  }
				  public void insertUpdate(DocumentEvent e) {
				      long startTime = System.currentTimeMillis();
				      Mainframe.find(textPane.getText());
				      long endTime = System.currentTimeMillis();
				      long duration = (endTime - startTime); 
				      timeCount.setText("Time: " + duration/1000.000 + " seconds");
					  
				  }
				  
				});
		
		JLabel wordCount = new JLabel("Total Words: ");
		wordCount.setBounds(6, 36, 212, 16);
		contentPane.add(wordCount);

		timeCount = new JLabel("Time:");
		timeCount.setBounds(360, 36, 212, 16);
		contentPane.add(timeCount);
		
		try {
			wordCount.setText("Total Words: " + Mainframe.initialize());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}