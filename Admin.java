// این کلاس نماینده کاربر مدیر (ادمین) در سیستم است
// ادمین قابلیت مدیریت محصولات را دارد
public class Admin extends User {

    // سازنده ادمین که نام کاربری و رمز عبور را به کلاس والد ارسال می‌کند
    public Admin(String username, String password) {
        super(username, password);
    }
}
