package in.niraj.spring.springbootaop.service.impl;

import in.niraj.spring.springbootaop.model.Product;
import in.niraj.spring.springbootaop.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * created by niraj on Oct, 2018
 */
@Service
public class ProductServiceImpl implements IProductService {


    @Override
    public Product saveProduct(Product product) throws InterruptedException {
        Thread.sleep(1000);
        return product;

    }

    @Override
    public Product getProduct() {
        Product product= new Product();
        product.setProductId(UUID.randomUUID().toString());
        product.setProductDesc("product desc");
        product.setProductName("product name");
        return  product;
    }


}
