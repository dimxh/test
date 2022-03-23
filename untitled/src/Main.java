import java.util.ArrayList;

public class Main {
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Costumer> customer1 = new ArrayList<>();
    static ArrayList<Employee> employees = new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();
    public static void main(String[] args) {
        String info = String.format("allbooks sould: %d price: %f ", getCountSould(), getallprice());
    }

    public static double getallprice(){
        double price = 0.0;
        for (Order order : orders){
            price += getPriceOrder(order);
        }
        return price;
    }

    public static double getPriceOrder(Order order){
        double price = 0.0;
        for (long id : order.getBooks()){
            Book book = getbookid(id);
            price += book.getPrice();
        }
        return price;
    }

    public static int getCountSould(){
        int count = 0;
        for (Order order : orders){
            count += order.getBooks().length;
        }
        return count;
    }


    public static Book getbookid(long id){
        Book current = null;
        for (Book book : books){
            if (book.getId() == id){
                current = book;
                break;
            }
        }
        return current;
    }
}
