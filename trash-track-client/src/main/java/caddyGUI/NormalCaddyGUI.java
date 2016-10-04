package caddyGUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import tn.esprit.tt.services.training.NormalCaddyServicesRemote;

public class NormalCaddyGUI extends JFrame {

	private JPanel contentPane;

	private Context context;
	private NormalCaddyServicesRemote normalCaddyServicesRemote;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NormalCaddyGUI frame = new NormalCaddyGUI();
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
	public NormalCaddyGUI() {
		try {
			context = new InitialContext();
			normalCaddyServicesRemote = (NormalCaddyServicesRemote) context.lookup(
					"trash-track-ear/trash-track-ejb/NormalCaddyServices!tn.esprit.tt.services.training.NormalCaddyServicesRemote");
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnPress = new JButton("press");
		btnPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				normalCaddyServicesRemote.setNum();
				System.out.println(normalCaddyServicesRemote.getNum());
			}
		});

		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(106)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPress))
						.addContainerGap(232, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(56)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnPress).addContainerGap(134, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
