package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.DepartmentRegister;
import Hospital.StaffRegister;

public class AddStaffToDept extends JFrame {

	private JPanel contentPane;
	private DepartmentRegister dr;
	private StaffRegister sr;

	public AddStaffToDept(DepartmentRegister dr, StaffRegister sr) {
		this.dr = dr;
		this.sr = sr;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
