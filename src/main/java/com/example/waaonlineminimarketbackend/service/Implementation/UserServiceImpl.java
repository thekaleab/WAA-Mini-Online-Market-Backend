package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.User;
import com.example.waaonlineminimarketbackend.entity.dto.input.UserInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.UserOutputDto;
import com.example.waaonlineminimarketbackend.repository.UserRepository;
import com.example.waaonlineminimarketbackend.service.UserService;
import com.example.waaonlineminimarketbackend.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ModelMapper modelMapper;



    @Autowired
    private UserRepository userRepository;

    @Autowired
    public ListMapper<User, UserInputDto> listMapper;


    @Override
    public void saveUser(User user) {
//        if(user.getRole().equals())
        userRepository.save(user);

    }

    @Override
    public List<UserOutputDto> getAllUser() {
        System.out.println("Inside");
        System.out.println(listMapper.mapList(userRepository.findAll(), new UserInputDto()));

//        System.out.println(userRepository.findAll());
//        return  (userRepository.findAll());
        return null;
    }

    @Override
    public UserOutputDto getUserById(long id) {
//        return userRepository.findById(id).orElse(null);
        return null;
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);

    }

//    @Override
//    public void UpdateUserById(long id, User user) {
//
//
//        }




    }

