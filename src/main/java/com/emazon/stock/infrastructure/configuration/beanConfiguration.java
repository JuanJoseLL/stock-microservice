package com.emazon.stock.infrastructure.configuration;


import com.emazon.stock.application.usecases.ArticleUseCase;
import com.emazon.stock.application.usecases.BrandUseCase;
import com.emazon.stock.domain.api.IArticleServicePort;
import com.emazon.stock.domain.api.IBrandServicePort;
import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.spi.IArticlePersistancePort;
import com.emazon.stock.domain.spi.IBrandPersistancePort;
import com.emazon.stock.domain.spi.ICategoryPersistancePort;
import com.emazon.stock.application.usecases.CategoryUseCase;
import com.emazon.stock.infrastructure.out.jpa.adapter.ArticleJpaAdapter;
import com.emazon.stock.infrastructure.out.jpa.adapter.BrandJpaAdapter;
import com.emazon.stock.infrastructure.out.jpa.adapter.CategoryJpaAdapter;
import com.emazon.stock.infrastructure.out.jpa.mapper.ArticleEntityMapper;
import com.emazon.stock.infrastructure.out.jpa.mapper.BrandEntityMapper;
import com.emazon.stock.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.emazon.stock.infrastructure.out.jpa.repository.IArticleRepository;
import com.emazon.stock.infrastructure.out.jpa.repository.IBrandRepository;
import com.emazon.stock.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class beanConfiguration {

    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    private final IBrandRepository brandRepository;
    private final BrandEntityMapper brandEntityMapper;


    private final IArticleRepository articleRepository;
    private final ArticleEntityMapper articleEntityMapper;


    @Bean
    public ICategoryPersistancePort categoryPersistancePort() {
        return new CategoryJpaAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistancePort());
    }


    @Bean
    public IBrandPersistancePort brandPersistancePort() {
        return new BrandJpaAdapter(brandRepository, brandEntityMapper);
    }

    @Bean
    public IBrandServicePort brandServicePort() {
        return new BrandUseCase(brandPersistancePort());
    }

    @Bean
    public IArticlePersistancePort articlePersistancePort() {
        return new ArticleJpaAdapter(articleRepository, articleEntityMapper);
    }

    @Bean
    public IArticleServicePort articleServicePort() {
        return new ArticleUseCase(articlePersistancePort());
    }

}
