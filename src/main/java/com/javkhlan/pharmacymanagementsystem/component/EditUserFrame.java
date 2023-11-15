package com.javkhlan.pharmacymanagementsystem.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.javkhlan.pharmacymanagementsystem.dao.UserDao;
import com.javkhlan.pharmacymanagementsystem.dao.UserDaoImpl;
import com.javkhlan.pharmacymanagementsystem.model.User;
import com.javkhlan.pharmacymanagementsystem.util.Constants;
import com.javkhlan.pharmacymanagementsystem.util.Observer;

public class EditUserFrame extends JFrame implements Observer, ActionListener {

	private static final long serialVersionUID = 2505078692427831783L;
	private JPanel panel;
	private JTextField fNameField, lNameField, staffIdField, addrField, phoneField, emailField, usernameField,
			passwordField;
	private JLabel fNameLabel, lNameLabel, staffIdLabel, addrLabel, phoneLabel, emailLabel, usernameLabel,
			passwordLabel;
	private JButton submitButton;
	private UserDao userDao;
	private User user;
	private Observer userView;

	public EditUserFrame(User user, Observer userView) {
		super("Edit user");
		this.user = user;
		this.userView = userView;
		initialize();
		setVisible(true);
	}

	private void initialize() {
		setBounds(Constants.winX + 100, Constants.winY + 100, Constants.minWidth / 2, Constants.minHeight);
		setMinimumSize(new Dimension(Constants.minWidth / 2, Constants.minHeight));
		getContentPane().setLayout(new BorderLayout());
		createPanel();

	}

	private void createPanel() {
		panel = new JPanel(new BorderLayout());
		this.userDao = new UserDaoImpl();
		panel.setPreferredSize(new Dimension(450, 600));

		GridLayout gridLayout = new GridLayout(8, 2);
		gridLayout.setVgap(20);
		gridLayout.setHgap(20);
		JPanel centerPanel = new JPanel(gridLayout);
		centerPanel.setBorder(BorderFactory.createEmptyBorder(20, -100, 10, 50));

		fNameLabel = new JLabel("First name:");
		fNameLabel.setFont(Constants.labelFont);
		fNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		lNameLabel = new JLabel("Last Name:");
		lNameLabel.setFont(Constants.labelFont);
		lNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		staffIdLabel = new JLabel("Staff id:");
		staffIdLabel.setFont(Constants.labelFont);
		staffIdLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		addrLabel = new JLabel("Address:");
		addrLabel.setFont(Constants.labelFont);
		addrLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		phoneLabel = new JLabel("Phone:");
		phoneLabel.setFont(Constants.labelFont);
		phoneLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		emailLabel = new JLabel("Email:");
		emailLabel.setFont(Constants.labelFont);
		emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(Constants.labelFont);
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(Constants.labelFont);
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		fNameField = new JTextField(user.getFirstName());
		fNameField.setAlignmentY(0.0f);
		fNameField.setAlignmentX(0.0f);
		fNameField.setToolTipText("Enter your first name");
		fNameField.setBorder(new EmptyBorder(5, 10, 5, 10));
		fNameField.setPreferredSize(new Dimension(300, 40));

		lNameField = new JTextField(user.getLastName());
		lNameField.setAlignmentY(0.0f);
		lNameField.setAlignmentX(0.0f);
		lNameField.setToolTipText("Enter your last name");
		lNameField.setBorder(new EmptyBorder(5, 10, 5, 10));
		lNameField.setBorder(new EmptyBorder(5, 10, 5, 10));
		lNameField.setPreferredSize(new Dimension(400, 40));

		staffIdField = new JTextField(user.getStaffId());
		staffIdField.setAlignmentY(0.0f);
		staffIdField.setAlignmentX(0.0f);
		staffIdField.setToolTipText("Enter your staff id");
		staffIdField.setBorder(new EmptyBorder(5, 10, 5, 10));
		staffIdField.setPreferredSize(new Dimension(300, 40));

		addrField = new JTextField(user.getAddress());
		addrField.setAlignmentY(0.0f);
		addrField.setAlignmentX(0.0f);
		addrField.setToolTipText("Enter your address");
		addrField.setBorder(new EmptyBorder(5, 10, 5, 10));
		addrField.setPreferredSize(new Dimension(300, 40));

		phoneField = new JTextField(user.getPhone());
		phoneField.setAlignmentY(0.0f);
		phoneField.setAlignmentX(0.0f);
		phoneField.setToolTipText("Enter your phone number");
		phoneField.setBorder(new EmptyBorder(5, 10, 5, 10));
		phoneField.setPreferredSize(new Dimension(300, 40));

		emailField = new JTextField(user.getEmail());
		emailField.setAlignmentY(0.0f);
		emailField.setAlignmentX(0.0f);
		emailField.setToolTipText("Enter your email");
		emailField.setBorder(new EmptyBorder(5, 10, 5, 10));
		emailField.setPreferredSize(new Dimension(300, 40));

		usernameField = new JTextField(user.getUsername());
		usernameField.setAlignmentY(0.0f);
		usernameField.setAlignmentX(0.0f);
		usernameField.setToolTipText("Enter your username");
		usernameField.setBorder(new EmptyBorder(5, 10, 5, 10));
		usernameField.setPreferredSize(new Dimension(300, 40));

		passwordField = new JTextField(user.getPassword());
		passwordField.setAlignmentY(0.0f);
		passwordField.setAlignmentX(0.0f);
		passwordField.setToolTipText("Enter your password");
		passwordField.setBorder(new EmptyBorder(5, 10, 5, 10));
		passwordField.setPreferredSize(new Dimension(300, 40));

		submitButton = new JButton("Edit");
		submitButton.setAlignmentY(0.0f);
		submitButton.setPreferredSize(new Dimension(200, 40));
		submitButton.setBackground(Color.lightGray);
		submitButton.setBorderPainted(false);
		submitButton.setFocusable(false);
		submitButton.setOpaque(true);
		submitButton.addActionListener(this);
		submitButton.addMouseListener(mouseAdapter);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		buttonPanel.add(submitButton);

		centerPanel.add(fNameLabel);
		centerPanel.add(fNameField);
		centerPanel.add(lNameLabel);
		centerPanel.add(lNameField);
		centerPanel.add(staffIdLabel);
		centerPanel.add(staffIdField);
		centerPanel.add(addrLabel);
		centerPanel.add(addrField);
		centerPanel.add(phoneLabel);
		centerPanel.add(phoneField);
		centerPanel.add(emailLabel);
		centerPanel.add(emailField);
		centerPanel.add(usernameLabel);
		centerPanel.add(usernameField);
		centerPanel.add(passwordLabel);
		centerPanel.add(passwordField);

		panel.add(centerPanel, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		getContentPane().add(panel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(submitButton)) {
			String sId = staffIdField.getText();
			String fname = fNameField.getText();
			String lname = lNameField.getText();
			String address = addrField.getText();
			String phone = phoneField.getText();
			String email = emailField.getText();
			String username = usernameField.getText();
			String password = passwordField.getText();

			if (sId.isEmpty() || fname.isEmpty() || lname.isEmpty() || address.isEmpty() || phone.isEmpty()
					|| email.isEmpty() || username.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please provide inputs for all field", "Missing fields",
						JOptionPane.WARNING_MESSAGE);
			} else {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this user?",
						"Warning", dialogButton);

				if (dialogResult == JOptionPane.YES_OPTION) {
					User newUser = new User(sId, user.getRole(), fname, lname, address, phone, email,
							username, password);
					userDao.updateUser(newUser, this.user.getId());

					staffIdField.setText("");
					fNameField.setText("");
					lNameField.setText("");
					addrField.setText("");
					phoneField.setText("");
					emailField.setText("");
					usernameField.setText("");
					passwordField.setText("");
					if (userView != null) {
						userView.update();
					}
					this.dispose();
				}

			}
		}
	}

	MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent event) {
			if (event.getSource().equals(submitButton)) {
				submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				submitButton.setBackground(Color.gray);
			}
		}

		@Override
		public void mouseExited(MouseEvent event) {
			if (event.getSource().equals(submitButton)) {
				submitButton.setCursor(Cursor.getDefaultCursor());
				submitButton.setBackground(Color.lightGray);
			}
		}
	};

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
}
