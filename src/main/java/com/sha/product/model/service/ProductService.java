package com.sha.product.model.service;

import com.sha.product.model.entity.Product;
import com.sha.product.model.repository.ProductRepository;
import com.sha.product.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService extends AbstractProductService
{

    @Autowired
   private ProductRepository productRepository;


    @Override
    protected List<Product> findByPriceGreaterThan(Double upperLimit) {

        List<Product> list=productRepository.findByPriceGreaterThan(upperLimit);
        return list;

    }

    @Override
    protected List<Product> findByPriceGreaterThanEqual(Double upperLimit) {
        List<Product> listEqual=productRepository.findByPriceGreaterThanEqual(upperLimit);
        return listEqual;
    }

    @Override
    public List<Product> findAll() {
       List<Product> productList=productRepository.findAll();
       return  productList;
    }

    @Override
    public Product save(Product entity) {
        try {
            entity.setCreated(new Date());
            return productRepository.save(entity);
        }
        catch (IllegalArgumentException e)
        {
            Util.showExceptionInfo(e);
            return new Product();
        }
    }

    @Override
    public void deleteByID(Integer id) {
        try {
            productRepository.deleteById(id);
        }catch (IllegalArgumentException e){
            Util.showExceptionInfo(e);
        }
    }


}
