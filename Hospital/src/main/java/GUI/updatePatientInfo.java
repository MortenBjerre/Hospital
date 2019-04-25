package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class updatePatientInfo extends JFrame {

	private JPanel contentPane;
	private JTextField SerialNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatePatientInfo frame = new updatePatientInfo();
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
	public updatePatientInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the patients Serial Number :");
		lblPleaseEnterThe.setBounds(39, 56, 488, 33);
		contentPane.add(lblPleaseEnterThe);
		
		SerialNumber = new JTextField();
		SerialNumber.setBounds(163, 117, 236, 39);
		contentPane.add(SerialNumber);
		SerialNumber.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(26, 225, 115, 33);
		contentPane.add(lblNewLabel);
		
		
	}
}
