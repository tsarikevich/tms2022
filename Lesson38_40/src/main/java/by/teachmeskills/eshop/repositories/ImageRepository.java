package by.teachmeskills.eshop.repositories;

import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.Product;

import java.util.List;

public interface ImageRepository extends BaseRepository<Image> {
    List<Image> getAllCategoriesImages();

    List<Image> getImagesByProductId(int productId);

    List<Image> getAllOrderPrimaryImagesByUserId(int userId);

    List<Image> getPrimaryImagesByCategoryId(int categoryId);

    List<Image> getPrimaryImagesByListProducts(List<Product> products);
}
