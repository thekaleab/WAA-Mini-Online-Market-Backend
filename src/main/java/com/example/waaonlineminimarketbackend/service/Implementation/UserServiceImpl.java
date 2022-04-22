package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.EmailSenderService;
import com.example.waaonlineminimarketbackend.entity.User;
import com.example.waaonlineminimarketbackend.entity.dto.input.UserInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.UserUpdateDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.UserUpdateInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.ProductOutputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.UserOutputDto;
import com.example.waaonlineminimarketbackend.exceptions.BadRequestException;
import com.example.waaonlineminimarketbackend.repository.ProductRepository;
import com.example.waaonlineminimarketbackend.repository.UserRepository;
import com.example.waaonlineminimarketbackend.service.UserService;
import com.example.waaonlineminimarketbackend.util.AuthenticatedUser;
import com.example.waaonlineminimarketbackend.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public ListMapper<User, UserOutputDto> listMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EmailSenderService emailSenderService;

    @Autowired
    AuthenticatedUser authenticatedUser;

    @Autowired
    ProductRepository productRepository;

    @Override
    public void saveUser(UserInputDto userD) throws BadRequestException {
        // do not allow admin registration from api.
        if(userD.getRole().getId() == 1) {
            throw new BadRequestException("You can't register as an Administrator");
        }

        User newUser = new User();
        modelMapper.map(userD, newUser);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(newUser);
        try {
            emailSenderService.sendSimpleEmail(newUser.getEmail(),
                    " You have created your account successfully",
                    "create account");
        } catch (Exception e) {
            // do nothing.
        }

    }

    @Override
    public List<UserOutputDto> getAllUser() {
        return (List<UserOutputDto>)listMapper.mapList(userRepository.findAll(), new UserOutputDto());
    }

    @Override
    public UserOutputDto getUserById(long id) {
        var user =  userRepository.getById(id);
        UserOutputDto userDto = new UserOutputDto();
        modelMapper.map(user, userDto);
        return userDto;
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);

    }

    @Override
    public void UpdateUserStatus(long id, UserUpdateDto userD) {
        var seller = userRepository.getById(id);
        seller.setIsSellerApproved(userD.getStatus());
        userRepository.save(seller);
    }

    @Override
    public void UpdateUserPoint(long id) {
        var user = userRepository.getById(id);
        var userOrders = user.getOrders();

       var deliveredOrder= ( userOrders.stream().filter(userOrder -> (userOrder.getStatus().getId()>3))).collect(Collectors.toList());

       var point = deliveredOrder.size();

       user.setCoupon(point);
    }

    @Override
    public void followSeller(long productId) {
        var product = productRepository.getById(productId);
        var buyer = authenticatedUser.getCurrentUser();
        var seller = product.getSeller();
        buyer.getBuyerFollowerList().add(seller);
        userRepository.save(buyer);
    }

    @Override
    public void UpdateUserById(long id, UserUpdateInputDto userUpdateInputDto) {
        var user = userRepository.getById(id);
        user.setFirstName(userUpdateInputDto.getFirstName());
        user.setLastName(userUpdateInputDto.getLastName());
        userRepository.save(user);

    }





    }

