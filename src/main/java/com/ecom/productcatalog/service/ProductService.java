package com.ecom.productcatalog.service;

import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.ProductRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public List<Product> getAllProductsByCategory(long CategoryId)
    {
        return productRepo.findByCategoryId(CategoryId);
    }

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> searchProducts(String search) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class);

        if (search != null && !search.isEmpty()) {
            Predicate nameLike = cb.like(cb.lower(product.get("name")), "%" + search.toLowerCase() + "%");
            cq.where(nameLike);
        }

        return entityManager.createQuery(cq).getResultList();
    }}