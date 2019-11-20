package com.jpa.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.demo.model.Menu;
import com.jpa.demo.repositories.MenuPageRepository;
import com.jpa.demo.repositories.MenuRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

/**
 * @Description:一句话的功能说明
 * @Author: chendom
 * @Date: 2019/11/19 15:26
 * @Version 1.0
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuRepositry menuRepositry;
    @Autowired
    private MenuPageRepository menuPageRepository;
    @Autowired
    private ObjectMapper objectMapper;
@GetMapping("/getMenus")
public Object getMenu() throws JsonProcessingException {
    Iterable<Menu> all = menuRepositry.findAll();
    System.out.println(objectMapper.writeValueAsString(all));

    Page<Menu> ids = menuPageRepository.findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "id")));

    System.out.println(ids);

    Optional<Menu> byId = menuPageRepository.findById(20);
    System.out.println(objectMapper.writeValueAsString(byId.get()));

    Page<Menu> byTitle = menuPageRepository.findMenuByTitle("首页", PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id")));

    return byTitle;
}

}
