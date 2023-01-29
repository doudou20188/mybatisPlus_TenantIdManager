package com.example.book_crud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.book_crud.entity.domain.Book;
import com.example.book_crud.entity.vo.BookVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookDao extends BaseMapper<Book> {


    List<BookVO> findBooksByName(@Param("name") String name);


}
