package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.Product;
import com.example.waaonlineminimarketbackend.entity.dto.input.ProductInputDto;
import com.example.waaonlineminimarketbackend.repository.ProductRepository;
import com.example.waaonlineminimarketbackend.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveItem(ProductInputDto productD) {
        Product newProduct = new Product();
        modelMapper.map(productD, newProduct);
        productRepository.save(newProduct);
    }

    @Override
    public List<Product> getAllItem() {
        return productRepository.findAll();
    }

    @Override
    public Product getItemById(long id) {
        return productRepository.getById(id);
    }

    @Override
    public void deleteItemById(long id) {
//        var product = productRepository.getById(id);
////        if (product.isAvailable()) {
//            productRepository.deleteById(id);
////        } // TODO
    }


    @Override
    public void UpdateItemById(long id, Product incomingProduct) {
        var storedProduct = productRepository.getById(id);
        modelMapper.map(incomingProduct, storedProduct);
        productRepository.save(storedProduct);
    }

}
