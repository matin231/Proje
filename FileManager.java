import java.io.*;

// این کلاس برای ذخیره و بازیابی اشیاء به صورت فایل باینری استفاده می‌شود
// معمولاً برای ذخیره وضعیت برنامه یا اشیاء Serializable کاربرد دارد
public class FileManager {

    // ذخیره یک شیء در مسیر مشخص‌شده
    public static void save(Object obj, String path) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(path)
        );
        out.writeObject(obj);
        out.close();
    }

    // بارگذاری یک شیء از فایل ذخیره‌شده
    public static Object load(String path)
            throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(path)
        );
        Object obj = in.readObject();
        in.close();
        return obj;
    }
}
