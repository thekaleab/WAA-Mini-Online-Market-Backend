package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.User;
import com.example.waaonlineminimarketbackend.entity.dto.input.UserInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.UserOutputDto;
import com.example.waaonlineminimarketbackend.repository.UserRepository;
import com.example.waaonlineminimarketbackend.service.UserService;
import com.example.waaonlineminimarketbackend.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    public ListMapper<User, UserOutputDto> listMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserInputDto userD) {
        User newUser = new User();
        modelMapper.map(userD, newUser);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(newUser);
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

//    @Override
//    public void UpdateUserById(long id, User user) {
//
//
//        }




    }

