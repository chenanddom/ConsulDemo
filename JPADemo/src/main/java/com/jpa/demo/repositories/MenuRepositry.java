package com.jpa.demo.repositories;

import com.jpa.demo.model.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:一句话的功能说明
 * @Author: chendom
 * @Date: 2019/11/19 15:25
 * @Version 1.0
 */
@Repository
public interface MenuRepositry extends CrudRepository<Menu,Integer> {



}
