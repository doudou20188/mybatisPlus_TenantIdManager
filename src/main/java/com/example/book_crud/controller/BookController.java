package com.example.book_crud.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.book_crud.config.talent.TenantIdManager;
import com.example.book_crud.controller.utils.Result;
import com.example.book_crud.dao.BookDao;
import com.example.book_crud.entity.domain.Book;
import com.example.book_crud.entity.vo.BookVO;
import com.example.book_crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private TenantIdManager tenantIdManager;


//    @RequestMapping("/")
//    public String index(Model model,HttpServletResponse response) {
//        model.addAttribute("name", "simonsfan");
//        return "/pages/books";
//    }



    @GetMapping
    public Result queryAll(){
        tenantIdManager.setCurrentTenantId(233L);
        return new Result(true,bookService.list());
    }


    @GetMapping("/login/{id}")
    public Result login(@PathVariable Long id){
        //模拟用户登陆
        //userAccount check
        //set tenantId
        tenantIdManager.setCurrentTenantId(id);
        return new Result("您已经登陆,当前租户id:"+id);
    }
    @GetMapping("/findBookName")
    public Result findByName(@RequestParam("name") String name){
        List<BookVO> booksByName = bookDao.findBooksByName(name);

        return new Result(true,booksByName);
    }

    @PostMapping("/save")
    public Result save(@RequestBody Book book){
        return new Result(bookService.save(book));
    }

    @PutMapping("/update")
    public Result update(@RequestBody Book book){
        return new Result(bookService.modify(book));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return new Result(bookService.delete(id));
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        return new Result(true,bookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于总页码数，那么重新执行查询操作，使用最大页码值作为当前页码值。
        if (currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(),pageSize);
        }
        return new Result(true,bookService.getPage(currentPage,pageSize,book));
    }

}
