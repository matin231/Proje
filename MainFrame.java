import javax.swing.*;
import java.awt.*;

// این فریم صفحه اصلی برنامه پس از ورود کاربر است
// بر اساس نقش کاربر (ادمین یا مشتری) پنل مناسب نمایش داده می‌شود
public class MainFrame extends JFrame {

    // مدیر محصولات فروشگاه
    private ProductManager productManager = new ProductManager();

    public MainFrame(User user) {
        setTitle("Shopping Mall");
        setSize(750, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // بارگذاری محصولات از فایل CSV
        productManager.getAllProducts().addAll(
                CSVManager.loadProducts()
        );

        // افزودن محصولات پیش‌فرض در صورت خالی بودن فایل
        if (productManager.getAllProducts().isEmpty()) {

            productManager.addProduct(
                    new Product(
                            "1",
                            "Laptop",
                            "Tech",
                            1000,
                            5,
                            "Powerful laptop for work and study",
                            "images/laptop.png"
                    )
            );

            productManager.addProduct(
                    new Product(
                            "2",
                            "Phone",
                            "Tech",
                            500,
                            10,
                            "Smartphone with good camera",
                            "images/phone.png"
                    )
            );

            productManager.addProduct(
                    new Product(
                            "3",
                            "ball",
                            "Sport",
                            150,
                            5,
                            "the ball of 2022 WorldCup",
                            "images/phone.png"
                    )
            );
        }

        // نمایش رابط کاربری متناسب با نقش کاربر
        if (user instanceof Customer) {
            Customer customer = (Customer) user;

            // بارگذاری سبد خرید مشتری
            CSVManager.loadCart(
                    customer.getCart(),
                    productManager.getAllProducts(),
                    customer.getUsername()
            );

            add(new CustomerPanel(productManager, customer), BorderLayout.CENTER);

        } else {
            // پنل مدیریت برای ادمین
            add(new AdminPanel(productManager), BorderLayout.CENTER);
        }

        // ذخیره اطلاعات هنگام خروج از برنامه
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                CSVManager.saveProducts(productManager.getAllProducts());

                if (user instanceof Customer) {
                    CSVManager.saveCart(
                            ((Customer) user).getCart(),
                            ((Customer) user).getUsername()
                    );
                }
            }
        });
    }
}
