package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.Product;
import com.example.waaonlineminimarketbackend.entity.Review;
import com.example.waaonlineminimarketbackend.entity.dto.input.ProductInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.OrderItemOutputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.ProductOutputDto;
import com.example.waaonlineminimarketbackend.exceptions.BadRequestException;
import com.example.waaonlineminimarketbackend.repository.OrderItemRepository;
import com.example.waaonlineminimarketbackend.repository.OrderRepository;
import com.example.waaonlineminimarketbackend.repository.ProductRepository;
import com.example.waaonlineminimarketbackend.repository.ReviewRepository;
import com.example.waaonlineminimarketbackend.service.ProductService;
import com.example.waaonlineminimarketbackend.util.AuthenticatedUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AuthenticatedUser authenticatedUser;

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public ProductOutputDto saveItem(ProductInputDto productD) throws BadRequestException {
        Product newProduct = new Product();
        modelMapper.map(productD, newProduct);
        var seller =  authenticatedUser.getCurrentUser();
        if(seller == null) {
            throw new BadRequestException("Cannot create a product without seller");
        }
        if(!seller.getIsSellerApproved()) {
            throw new BadRequestException("User not approved to sell");
        }
        newProduct.setSeller(seller);
        productRepository.save(newProduct);

        ProductOutputDto prod = new ProductOutputDto();
        modelMapper.map(newProduct, prod);
        return prod;
    }

    @Override
    public List<Product> getAllItem() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllBySeller(long id) {
        return productRepository.findSellerProducts(id);
    }

    @Override
    public Product getItemById(long id) {
        return productRepository.getById(id);
    }

    @Override
    public void deleteItemById(long id) throws Exception {
        var product = productRepository.getById(id);
        var orderForProductExists = orderItemRepository.findByProductId(id).stream().findAny().isPresent();
        if (!orderForProductExists) {
            productRepository.deleteById(id);
        } else {
            throw new Exception("Product can not be deleted");
        }
    }


    @Override
    public ProductOutputDto UpdateItemById(long id, ProductInputDto incomingProduct) {
        var storedProduct = productRepository.getById(id);
        modelMapper.map(incomingProduct, storedProduct);
        productRepository.save(storedProduct);
        ProductOutputDto updated = new ProductOutputDto();
        modelMapper.map(storedProduct, updated);
        return updated;
    }

    @Override
    public List<Review> findAllByProductId(long id) {
        return reviewRepository.findAllByProductId(id);
    }

}
