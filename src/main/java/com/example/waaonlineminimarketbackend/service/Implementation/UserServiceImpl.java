package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.User;
import com.example.waaonlineminimarketbackend.entity.dto.input.UserInputDto;
import com.example.waaonlineminimarketbackend.repository.UserRepository;
import com.example.waaonlineminimarketbackend.service.UserService;
import com.example.waaonlineminimarketbackend.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void saveUser(UserInputDto user) {
        var x = modelMapper.map(user, User.class);
        userRepository.save(x);

    }

    @Override
    public List<UserInputDto> getAllUser() {
        return (List<UserInputDto>) listMapper.mapList(userRepository.findAll(), new UserInputDto());
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
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

