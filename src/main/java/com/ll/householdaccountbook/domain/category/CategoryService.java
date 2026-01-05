package com.ll.householdaccountbook.domain.category;

import com.ll.householdaccountbook.domain.category.dto.CategoryRequest;
import com.ll.householdaccountbook.domain.category.dto.CategoryResponse;
import com.ll.householdaccountbook.domain.user.User;
import com.ll.householdaccountbook.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public void create(Long userId, CategoryRequest request){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));

        Category category = Category.builder()
                .user(user)
                .name(request.name())
                .type(request.type())
                .build();



        categoryRepository.save(category);
    }

    public List<CategoryResponse> findAll(Long userId){
        return categoryRepository.findByUserId(userId)
                .stream()
                .map(c -> new CategoryResponse(c.getId(), c.getName(), c.getType()))
                .toList();
    }
}
