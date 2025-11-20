import javax.swing.*;
import java.awt.*;


public class LoginFrame extends JFrame {
    private final JTextField usernameField = new JTextField(15);
    private final JPasswordField passwordField = new JPasswordField(15);
    private final UserManager manager;

    public LoginFrame(UserManager manager) {
        super("Login");
        this.manager = manager;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null); // Centrerar fönstret

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Användarnamn:"), gbc);

        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Lösenord:"), gbc);

        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        JButton loginBtn = new JButton("Logga in");
        JButton registerBtn = new JButton("Registrera");

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(loginBtn, gbc);

        gbc.gridx = 1;
        panel.add(registerBtn, gbc);

        add(panel);

        loginBtn.addActionListener(e -> loginAction());
        registerBtn.addActionListener(e -> openRegisterFrame());

        setVisible(true);
    }

    private void loginAction() {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());
        if (manager.login(user, pass)) {
            JOptionPane.showMessageDialog(this, "Inloggad!");
            dispose(); // Stänger inloggningsfönstret efter lyckad inloggning
            // Här kan exempelvis MainFrame starta, om sådan finns
        } else {
            JOptionPane.showMessageDialog(this, "Fel användarnamn eller lösenord");
            passwordField.setText("");
        }
    }

    private void openRegisterFrame() {
        RegisterFrame reg = new RegisterFrame(manager);
        reg.setVisible(true); // Visa registerfönstret
    }
}
