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

import tn.esprit.tt.services.training.CharityCaddyServicesRemote;

public class CharityCaddyGUI extends JFrame {

	private JPanel contentPane;
	private Context context;
	private CharityCaddyServicesRemote charityCaddyServices;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CharityCaddyGUI frame = new CharityCaddyGUI();
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
	public CharityCaddyGUI() {
		try {
			context = new InitialContext();
			charityCaddyServices = (CharityCaddyServicesRemote) context.lookup(
					"trash-track-ear/trash-track-ejb/CharityCaddyServices!tn.esprit.tt.services.training.CharityCaddyServicesRemote");
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
				charityCaddyServices.addItem();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(135).addComponent(btnPress).addContainerGap(200, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(109).addComponent(btnPress).addContainerGap(119, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

}
