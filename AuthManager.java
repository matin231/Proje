// این کلاس مسئول مدیریت احراز هویت کاربران است
// شامل عملیات ورود و ثبت‌نام کاربران
public class AuthManager {

    // بررسی اطلاعات ورود کاربر
    // در صورت صحیح بودن، شیء User (Admin یا Customer) برمی‌گرداند
    public static User login(String username, String password) {
        return CSVManager.loadUser(username, password);
    }

    // ثبت‌نام یک کاربر جدید از نوع Customer
    // اطلاعات کاربر در فایل CSV ذخیره می‌شود
    public static boolean registerCustomer(
            String username,
            String password,
            double balance
    ) {
        return CSVManager.registerCustomer(username, password, balance);
    }
}
