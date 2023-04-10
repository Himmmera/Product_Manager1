package ProductManager;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("Product wich id:" + id + " not found");
    }
}
