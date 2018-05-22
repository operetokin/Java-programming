package account;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InfoPanel extends JPanel  implements ActionListener{
	
	JLabel fNameLabel;
	JLabel lNameLabel;
	JLabel accNumLabel;
	JLabel balLabel;
	JTextField firstName;
	JTextField lastName;
	JTextField accountNumber;
	JTextField balance;
	JButton click;
	Account newAccount = null;
	JTextArea deserialized;
	
	
	
	public InfoPanel()
	{
	fNameLabel = new JLabel("First Name");
	lNameLabel = new JLabel("Last Name");
	accNumLabel = new JLabel("Account Number");
	balLabel = new JLabel("Balance");
	firstName = new JTextField(65);
	lastName = new JTextField(65);
	click = new JButton("Serialize");
	accountNumber = new JTextField(63);
	balance = new JTextField(66);
	deserialized = new JTextArea(5, 75);
	deserialized.setBounds(50, 300, 200, 200);
	click.addActionListener(this);
	
	fNameLabel.setLabelFor(firstName);
	lNameLabel.setLabelFor(lastName);
	this.add(fNameLabel);
	this.add(firstName);
	this.add(lNameLabel);
	this.add(lastName);
	this.add(accNumLabel);
	this.add(accountNumber);
	this.add(balLabel);
	this.add(balance);
	this.add(deserialized);
	this.add(click);
	deserialized.setVisible(true);
	this.add(deserialized);

	}
	
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == click)
		{
			Serialize.serialize(new Account(), "account.bin", Integer.parseInt(accountNumber.getText()), firstName.getText(), lastName.getText(), Double.parseDouble(balance.getText()));
			
		}
		newAccount = Deserialize.deserialize("account.bin");
		deserialized.append("First Name: " + newAccount.getFirstName() + "\n");
		deserialized.append("Last Name: " + newAccount.getLastName() + "\n");
		deserialized.append("Account Number: " + newAccount.getAccountNumber() + "\n");
		deserialized.append("Balance: " + newAccount.getBalance());
		
		
		
		
	}
}
