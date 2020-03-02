import java.util.*;
import java.lang.Exception;
import java.util.Collection;

public class ProductManager {
    private ArrayList<Product> list = new ArrayList<>();
    public void add(int id, String name, float price){
        Product product = new Product(id,name,price);
        list.add(product);
    }
    public boolean remove(int id){
        Product product = null;
        for(Product each : list){
            if(each.getId() == id){
                product = each;
            }
        }
        if(product != null) {
            list.remove(product);
            return true;
        }
        return false;
    }

    public void showAll(){
        list.forEach(product -> System.out.println(product.toString()));
    }

    public Product getProductById(int id){
        Iterator<Product> iterator = list.listIterator();
        while(iterator.hasNext()){
            if(iterator.next().getId() == id){
                return iterator.next();
            }
        }
        throw new IndexOutOfBoundsException("Out of bound roi do dm");
    }

    public boolean searchProductById(int id){

        Iterator<Product> iterator = list.listIterator();
        while(iterator.hasNext()){
            if(iterator.next().getId() == id){
                return true;
            }
        }
        return false;
    }

    public void sortListByName(){
        Collections.sort(list,(Comparator.<Product>comparingInt(product1 -> product1.getId()).thenComparingInt(product2 -> product2.getId())));
    }


}
