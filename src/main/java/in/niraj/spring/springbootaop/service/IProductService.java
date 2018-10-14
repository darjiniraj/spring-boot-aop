package in.niraj.spring.springbootaop.service;

import in.niraj.spring.springbootaop.model.Product;

/**
 * created by niraj on Oct, 2018
 */
public interface IProductService {

    Product saveProduct(Product  product) throws InterruptedException;

    Product getProduct();
}
