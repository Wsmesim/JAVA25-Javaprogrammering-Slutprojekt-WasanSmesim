import javax.swing.*;

public class RegisterFrame extends JFrame{
    private UserManager manager;
    // RegisterFrame ärver från JFrame (blir till ett egen fönster).

    public RegisterFrame (UserManager manager) {
        this.manager = manager;

       setTitle("Registrera användare");
        setSize(300, 200);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //konstruktor som tar emot UserManager-instans och sparar den i interna fält. Sätter vad som ska hända när fönstret stängs- fönstret stängs men programmet kommer fortsätta köra


        JTextField usernameField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);
        JCheckBox adminCheck = new JCheckBox("Admin?");
        JButton registerBtn = new JButton("Skapa konto");

        registerBtn.addActionListener(e -> {
            manager.register(
                    usernameField.getText(),
                    new String(passwordField.getPassword()),
                    adminCheck.isSelected()
            );

            JOptionPane.showMessageDialog(this,"Användare är skapad");
            dispose();
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Användarnamn:"));
        panel.add(usernameField);
        panel.add(new JLabel("Lösenord"));
        panel.add(passwordField);
        panel.add(adminCheck);
        panel.add(registerBtn);

        add(panel);
        setVisible(true);
    }
}
