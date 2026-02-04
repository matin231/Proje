import javax.swing.*;
import java.awt.*;

// این فریم برای ثبت‌نام مشتری جدید در سیستم استفاده می‌شود
public class RegisterFrame extends JFrame {

    public RegisterFrame() {
        setTitle("Customer Register");
        setSize(360, 260);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // فرم ثبت‌نام شامل نام کاربری، رمز عبور و موجودی اولیه
        JPanel panel = new JPanel(new GridLayout(4, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JTextField balanceField = new JTextField("1000");

        panel.add(new JLabel("Username:"));
        panel.add(userField);
        panel.add(new JLabel("Password:"));
        panel.add(passField);
        panel.add(new JLabel("Initial Balance:"));
        panel.add(balanceField);

        JButton registerBtn = new JButton("Register");
        JLabel status = new JLabel("", JLabel.CENTER);

        add(panel, BorderLayout.CENTER);
        add(registerBtn, BorderLayout.SOUTH);
        add(status, BorderLayout.NORTH);

        // منطق ثبت‌نام کاربر جدید
        registerBtn.addActionListener(e -> {
            String u = userField.getText().trim();
            String p = new String(passField.getPassword()).trim();

            double balance;
            try {
                balance = Double.parseDouble(balanceField.getText());
            } catch (Exception ex) {
                status.setText("❌ Invalid balance");
                return;
            }

            // بررسی پر بودن فیلدها
            if (u.isEmpty() || p.isEmpty()) {
                status.setText("❌ Fill all fields");
                return;
            }

            // ذخیره کاربر جدید در فایل CSV
            boolean ok = CSVManager.registerCustomer(u, p, balance);

            if (ok) {
                JOptionPane.showMessageDialog(
                        this,
                        "✅ Registered successfully!\nNow you can login."
                );
                dispose();
            } else {
                status.setText("❌ Username already exists");
            }
        });
    }
}
