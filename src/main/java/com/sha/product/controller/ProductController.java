package com.sha.product.controller;

import com.sha.product.model.entity.Product;
import com.sha.product.model.service.AbstractProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/*
pre-path(Request mapping, belirtildiği scope'taki tüm unsurları etkiler)
@RequestMapping(path)
  Buna bağlı olan mappingler neler?
  @GetMapping, @PostMapping, @DeleteMapping, @PutMapping

  ResponseEntity<?> donduren metotta param kısmı hangi anotation ile işaretlenebilir.
  @RequestBody -> POST https://endpoint-data(requestBody)
  @RequestPath -> https://endpoint?requestPath=x
  @PathVariable -> https://endpoint/pathVariable

   api/product'ı 2 farkli @GetMapping için kullanamayız.
   Ne var ki, bu yolu hem @GetMapping hem de @PostMapping için kullanabildik.
 */

@RequestMapping("api/product")
@RestController
public class ProductController
{
    @Autowired
    private AbstractProductService productService;

   @PostMapping
  public ResponseEntity<Product> saveProduct(@RequestBody Product product)
    {
        Product savedProduct=productService.save(product);
       return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
    }

    @DeleteMapping("{productID}")// api/product/productID
    public ResponseEntity<Product>  deleteProduct(@PathVariable Integer productID)
    {
     productService.deleteByID(productID);
     return new ResponseEntity<>(HttpStatus.OK);
 }
  @GetMapping
  public ResponseEntity<List<Product>> getAllProduct()
  {
      List<Product> productList=productService.findAll();
      return ResponseEntity.ok(productList);//Cevabın döndürülmesi
  }

}
