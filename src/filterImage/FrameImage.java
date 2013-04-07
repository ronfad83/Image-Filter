package filterImage;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class FrameImage extends JFrame 
{
	private JPanel contentPane;
	private JButton btnBuka;
	private JFileChooser fc = new JFileChooser();
	private JLabel lblGambar;
	/**
	 * Create the frame.
	 */
	public FrameImage() 
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBuka = new JButton("Buka Image");
		btnBuka.setIcon(new ImageIcon("C:/Java/j2seProject/ImageFilter/src/Gambar/tampilData.png"));
		fc.setFileFilter(new PictureFilter());
		btnBuka.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent act)
			{
				int buka = fc.showOpenDialog(lblGambar);
				if(buka == JFileChooser.APPROVE_OPTION)
				{
					String src = fc.getSelectedFile().getPath();
					lblGambar.setIcon(new ImageIcon(src));
				}
			}
		});
		btnBuka.setBounds(314, 606, 194, 46);
		contentPane.add(btnBuka);
		
		lblGambar = new JLabel();
		lblGambar.setBounds(6, 0, 820, 603);
		contentPane.add(lblGambar);
		setLocationRelativeTo(null);
	}//Akhir Konstruktor
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					FrameImage frame = new FrameImage();
					frame.setVisible(true);
				} 
				catch (UnsupportedLookAndFeelException e) 
				{
				} 
				catch (ClassNotFoundException e)
				{
				} 
				catch (InstantiationException e) 
				{
				} 
				catch (IllegalAccessException e) 
				{
				}
			}
		});
	}
}
