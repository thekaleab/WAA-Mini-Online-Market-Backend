package com.example.waaonlineminimarketbackend.service.Implementation.AuthenticationServiceImpl;


import com.example.waaonlineminimarketbackend.repository.AdminRepository;
import com.example.waaonlineminimarketbackend.repository.BuyerRepository;
import com.example.waaonlineminimarketbackend.repository.SellerRepository;
import com.example.waaonlineminimarketbackend.service.Implementation.AuthenticationServiceImpl.Admin.AdminAuthUserDetails;
import com.example.waaonlineminimarketbackend.service.Implementation.AuthenticationServiceImpl.Buyer.BuyerAuthUserDetails;
import com.example.waaonlineminimarketbackend.service.Implementation.AuthenticationServiceImpl.Seller.SellerAuthUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.example.waaonlineminimarketbackend.controller.AuthenticationController.*;

@Service("userDetailsService")
@Transactional
public class AuthUserDetailsService implements UserDetailsService {

        UserDetails userDetails;
        @Autowired
        private SellerRepository sellerRepository;
        @Autowired
        private BuyerRepository buyerRepository;
        @Autowired
        private AdminRepository adminRepository;


        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            if(getLoginRequest().getRole().equals("SELLER")){
                var user = sellerRepository.loadSellerByEmail(email);
                userDetails = new SellerAuthUserDetails(user);
            }
            else if(getLoginRequest().getRole().equals("ADMIN")){
                var user = adminRepository.loadAdminByEmail(email);
                userDetails = new AdminAuthUserDetails(user);
            }
            else if(getLoginRequest().getRole().equals("BUYER")){
                var user = buyerRepository.loadUserByEmail(email);
                userDetails = new BuyerAuthUserDetails(user);
            }

            return userDetails;

        }



}

