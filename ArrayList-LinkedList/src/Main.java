public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        manager.add(3,"Dung",21);
        manager.add(1,"KieuAnh",25);
        manager.add(5,"DoanDu",26);
        manager.add(6,"Alo",15);
        manager.showAll();
        manager.sortListByName();
        manager.showAll();
    }
}
