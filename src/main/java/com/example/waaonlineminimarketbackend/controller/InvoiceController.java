package com.example.waaonlineminimarketbackend.controller;

import java.io.IOException;
import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.waaonlineminimarketbackend.entity.Order;
import com.example.waaonlineminimarketbackend.entity.dto.output.OrderOutputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.UserOutputDto;
import com.example.waaonlineminimarketbackend.service.OrderService;
import com.example.waaonlineminimarketbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.lowagie.text.DocumentException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/invoice")
public class InvoiceController {

    @Autowired
    OrderService orderService;



}
