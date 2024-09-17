import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupForm extends JFrame implements ActionListener {

    // Components of the form
    private Container container;
    private JLabel title;
    private JLabel usernameLabel;
    private JTextField usernameTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JButton submitButton;
    private JLabel resultLabel;

    // Constructor to setup GUI components and event handling
    public SignupForm() {
        setTitle("Signup Form");
        setBounds(300, 90, 500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        title = new JLabel("Signup Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(150, 30);
        container.add(title);

        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        usernameLabel.setSize(100, 20);
        usernameLabel.setLocation(100, 100);
        container.add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        usernameTextField.setSize(190, 20);
        usernameTextField.setLocation(200, 100);
        container.add(usernameTextField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordLabel.setSize(100, 20);
        passwordLabel.setLocation(100, 150);
        container.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setSize(190, 20);
        passwordField.setLocation(200, 150);
        container.add(passwordField);

        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        emailLabel.setSize(100, 20);
        emailLabel.setLocation(100, 200);
        container.add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        emailTextField.setSize(190, 20);
        emailTextField.setLocation(200, 200);
        container.add(emailTextField);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 15));
        submitButton.setSize(100, 20);
        submitButton.setLocation(150, 250);
        submitButton.addActionListener(this);
        container.add(submitButton);

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        resultLabel.setSize(300, 25);
        resultLabel.setLocation(100, 300);
        container.add(resultLabel);

        setVisible(true);
    }

    // Method to handle events
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String username = usernameTextField.getText();
            String password = new String(passwordField.getPassword());
            String email = emailTextField.getText();

            // Basic validation (You can add more validation as required)
            if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                resultLabel.setText("Please fill all fields.");
            } else {
                resultLabel.setText("Signup Successful!");
            }
        }
    }

    public static void main(String[] args) {
        new SignupForm();
    }
}
