package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SuccesfulOperation extends JFrame {

	private JPanel contentPane;
	private static String message;

	/**
	 * Create the frame.
	 */
	public SuccesfulOperation(String message) {
		this.message = message;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 509, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 329, 0, 0};
		gbl_contentPane.rowHeights = new int[]{33, 77, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		this.setLocationRelativeTo(null);
		
		JLabel lblInvalidInput = new JLabel("Succesful");
		lblInvalidInput.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblInvalidInput.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblInvalidInput = new GridBagConstraints();
		gbc_lblInvalidInput.insets = new Insets(0, 0, 5, 5);
		gbc_lblInvalidInput.gridx = 1;
		gbc_lblInvalidInput.gridy = 0;
		contentPane.add(lblInvalidInput, gbc_lblInvalidInput);
		
		JButton btnOkay = new JButton("Okay");
		btnOkay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JTextArea messageDisplay = new JTextArea();
		messageDisplay.setBackground(Color.WHITE);
		messageDisplay.setLineWrap(true);
		messageDisplay.setWrapStyleWord(true);
		messageDisplay.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		messageDisplay.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 1;
		contentPane.add(messageDisplay, gbc_textArea);
		GridBagConstraints gbc_btnOkay = new GridBagConstraints();
		gbc_btnOkay.insets = new Insets(0, 0, 0, 5);
		gbc_btnOkay.gridx = 1;
		gbc_btnOkay.gridy = 2;
		contentPane.add(btnOkay, gbc_btnOkay);
		messageDisplay.setText(message);
		this.pack();
	}

}