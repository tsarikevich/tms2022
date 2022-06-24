package by.teachmeskills.eshop.repositories;

import by.teachmeskills.eshop.entities.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepository extends BaseRepository<Product> {
    Product getProductById(int productId);

    Map<Product, Integer> getProductsByOrderId(int orderId);

    List<Product> getProductsByCategoryId(int categoryId);

    List<Product> findAllProductsByRequest(String request);

    Map<Product, Integer> getLastInsertOrderProductsByUserId(int userId);
}
