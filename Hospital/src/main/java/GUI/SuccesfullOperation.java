package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SuccesfullOperation extends JFrame {

	private JPanel contentPane;
	private static String message;

	/**
	 * Create the frame.
	 */
	public SuccesfullOperation(String message) {
		this.message = message;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 290, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{410, 0};
		gbl_contentPane.rowHeights = new int[]{33, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		this.setLocationRelativeTo(null);
		
		JLabel lblInvalidInput = new JLabel("Succesfull");
		lblInvalidInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblInvalidInput.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblInvalidInput = new GridBagConstraints();
		gbc_lblInvalidInput.insets = new Insets(0, 0, 5, 0);
		gbc_lblInvalidInput.gridx = 0;
		gbc_lblInvalidInput.gridy = 0;
		contentPane.add(lblInvalidInput, gbc_lblInvalidInput);
		
		JLabel lblInvalidPhoneNumber = new JLabel(message);
		lblInvalidPhoneNumber.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_lblInvalidPhoneNumber = new GridBagConstraints();
		gbc_lblInvalidPhoneNumber.insets = new Insets(0, 0, 5, 0);
		gbc_lblInvalidPhoneNumber.gridx = 0;
		gbc_lblInvalidPhoneNumber.gridy = 1;
		contentPane.add(lblInvalidPhoneNumber, gbc_lblInvalidPhoneNumber);
		
		JButton btnOkay = new JButton("Okay");
		btnOkay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnOkay = new GridBagConstraints();
		gbc_btnOkay.gridx = 0;
		gbc_btnOkay.gridy = 2;
		contentPane.add(btnOkay, gbc_btnOkay);
	}

}