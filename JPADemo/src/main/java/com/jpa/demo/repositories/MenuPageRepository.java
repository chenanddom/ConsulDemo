package com.jpa.demo.repositories;


import com.jpa.demo.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:一句话的功能说明
 * @Author: chendom
 * @Date: 2019/11/19 16:36
 * @Version 1.0
 */
@Repository
public interface MenuPageRepository extends PagingAndSortingRepository<Menu,Integer> {

    Page<Menu> findMenuByTitle(String title, Pageable pageable);
}
