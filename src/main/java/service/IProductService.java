package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> selectAll();
    void insert(Product product);
    Product findById(int id);
    void remove(int id);
    List<Product> findByName(String name);
}
