package com.ll.householdaccountbook.domain.category;


import com.ll.householdaccountbook.domain.category.dto.CategoryRequest;
import com.ll.householdaccountbook.domain.category.dto.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public void create(@RequestBody CategoryRequest request){
        Long mockUserId = 1l;
        categoryService.create(mockUserId, request);
    }

    public List<CategoryResponse> list(){
        Long mockUserId =1L;
        return categoryService.findAll(mockUserId);
    }
}

