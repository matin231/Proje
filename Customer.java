// این کلاس نمایانگر کاربر عادی (مشتری) در سیستم است
// هر مشتری دارای موجودی حساب و یک سبد خرید است
public class Customer extends User {

    // موجودی حساب مشتری
    private double balance;

    // سبد خرید اختصاصی مشتری
    private ShoppingCart cart = new ShoppingCart();

    // سازنده مشتری با مقداردهی اطلاعات اولیه
    public Customer(String username, String password, double balance) {
        super(username, password);
        this.balance = balance;
    }

    // دریافت موجودی حساب
    public double getBalance() {
        return balance;
    }

    // کسر مبلغ از موجودی حساب پس از خرید
    public void deductBalance(double amount) {
        balance -= amount;
    }

    // دریافت سبد خرید مشتری
    public ShoppingCart getCart() {
        return cart;
    }
}
