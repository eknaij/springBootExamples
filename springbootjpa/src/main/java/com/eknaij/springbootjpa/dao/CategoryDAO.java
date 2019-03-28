package com.eknaij.springbootjpa.dao;

import com.eknaij.springbootjpa.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer> {
}
