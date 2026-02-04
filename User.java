// کلاس انتزاعی User به عنوان پایه تمام کاربران سیستم
// (مانند Admin و Customer) استفاده می‌شود
public abstract class User {

    // نام کاربری کاربر
    protected String username;

    // رمز عبور کاربر
    protected String password;

    // سازنده کاربر که اطلاعات اولیه را مقداردهی می‌کند
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // دریافت نام کاربری
    public String getUsername() {
        return username;
    }

    // دریافت رمز عبور
    public String getPassword() {
        return password;
    }
}
