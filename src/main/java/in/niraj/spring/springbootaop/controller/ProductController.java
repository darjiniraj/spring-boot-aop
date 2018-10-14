package in.niraj.spring.springbootaop.controller;

import in.niraj.spring.springbootaop.aop.annotation.LogExecutor;
import in.niraj.spring.springbootaop.model.Product;
import in.niraj.spring.springbootaop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * created by niraj on Oct, 2018
 */

@RestController
@RequestMapping(value = "/api")
public class ProductController {

    @Autowired
    IProductService productService;

    @LogExecutor
    @PostMapping(value = "/product")
    public Product saveProduct(@RequestBody Product product) throws InterruptedException {
        return productService.saveProduct(product);
    }

    @LogExecutor
    @GetMapping(value = "/product")
    public Product getProduct() throws InterruptedException {
        return productService.getProduct();
    }
}
