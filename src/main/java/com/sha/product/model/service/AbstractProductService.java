package com.sha.product.model.service;

import com.sha.product.model.entity.Product;
import com.sha.product.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractProductService implements EntityService<Product,Integer>
{
    @Autowired
    protected ProductRepository productRepository;

  protected abstract List<Product> findByPriceGreaterThan(Double upperLimit);

  protected abstract List<Product>  findByPriceGreaterThanEqual(Double upperLimit);



}
