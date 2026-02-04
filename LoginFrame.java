import javax.swing.*;
import java.awt.*;

// این فریم مسئول ورود کاربران به سیستم است
// کاربر می‌تواند وارد شود یا به صفحه ثبت‌نام هدایت شود
public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Shopping Mall - Login");
        setSize(380, 260);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // عنوان صفحه ورود
        JLabel title = new JLabel("User Login", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        // فرم ورود شامل نام کاربری و رمز عبور
        JPanel form = new JPanel(new GridLayout(2, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));

        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();

        form.add(new JLabel("Username:"));
        form.add(userField);
        form.add(new JLabel("Password:"));
        form.add(passField);

        add(form, BorderLayout.CENTER);

        // دکمه‌های ورود و ثبت‌نام
        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");

        JPanel btnPanel = new JPanel();
        btnPanel.add(loginBtn);
        btnPanel.add(registerBtn);

        add(btnPanel, BorderLayout.SOUTH);

        // منطق بررسی اطلاعات و ورود کاربر
        loginBtn.addActionListener(e -> {
            String username = userField.getText().trim();
            String password = new String(passField.getPassword()).trim();

            // بررسی خالی نبودن فیلدها
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter username and password",
                        "Login Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            // دریافت کاربر از فایل CSV
            User user = CSVManager.loadUser(username, password);

            // بررسی صحت نام کاربری و رمز عبور
            if (user == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "Username or password is incorrect!",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                // ورود موفق و انتقال به صفحه اصلی
                dispose();
                new MainFrame(user).setVisible(true);
            }
        });

        // انتقال به صفحه ثبت‌نام کاربر جدید
        registerBtn.addActionListener(e -> {
            new RegisterFrame().setVisible(true);
        });
    }
}
