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
import javax.swing.border.EmptyBorder;

import tn.esprit.tt.services.training.SuperCaddyServicesRemote;

public class SuperCaddyGUI extends JFrame {

	private JPanel contentPane;
	private Context context;
	private SuperCaddyServicesRemote superCaddyServicesRemote;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuperCaddyGUI frame = new SuperCaddyGUI();
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
	public SuperCaddyGUI() {
		try {
			context = new InitialContext();
			superCaddyServicesRemote = (SuperCaddyServicesRemote) context.lookup(
					"trash-track-ear/trash-track-ejb/SuperCaddyServices!tn.esprit.tt.services.training.SuperCaddyServicesRemote");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
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
				superCaddyServicesRemote.addItem();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(144).addComponent(btnPress).addContainerGap(191, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(97).addComponent(btnPress).addContainerGap(131, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

}
