package com.emazon.stock.infrastructure.configuration;


import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.spi.ICategoryPersistancePort;
import com.emazon.stock.domain.usecases.CategoryUseCase;
import com.emazon.stock.infrastructure.out.jpa.adapter.CategoryJpaAdapter;
import com.emazon.stock.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.emazon.stock.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class beanConfiguration {

    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public ICategoryPersistancePort categoryPersistancePort() {
        return new CategoryJpaAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistancePort());
    }
}
