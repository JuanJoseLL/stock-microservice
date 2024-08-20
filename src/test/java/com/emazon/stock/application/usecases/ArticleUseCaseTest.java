package com.emazon.stock.application.usecases;

import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.spi.ICategoryPersistancePort;
import com.emazon.stock.infrastructure.exception.CategoryAlreadyExistException;
import com.emazon.stock.infrastructure.exception.CategoryDescriptionMissingException;
import com.emazon.stock.infrastructure.exception.CategoryDescriptionTooLongException;
import com.emazon.stock.infrastructure.exception.CategoryNameTooLongException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArticleUseCaseTest {
    @Mock
    private ICategoryPersistancePort categoryPersistancePort;

    private CategoryUseCase categoryUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        categoryUseCase = new CategoryUseCase(categoryPersistancePort);
    }

    @Test
    void save_ValidCategory_ShouldSaveSuccessfully() {
        // Arrange
        Category category = new Category(1L, "Test Category", "Test Description");
        when(categoryPersistancePort.existsByName(category.getName())).thenReturn(false);

        // Act
        assertDoesNotThrow(() -> categoryUseCase.save(category));

        // Assert
        verify(categoryPersistancePort).save(category);
    }

    @Test
    void save_ExistingCategory_ShouldThrowCategoryAlreadyExistException() {
        // Arrange
        Category category = new Category(2L, "Existing Category", "Test Description");
        when(categoryPersistancePort.existsByName(category.getName())).thenReturn(true);

        // Act & Assert
        assertThrows(CategoryAlreadyExistException.class, () -> categoryUseCase.save(category));
        verify(categoryPersistancePort, never()).save(category);
    }

    @Test
    void save_LongDescription_ShouldThrowCategoryDescriptionTooLongException() {
        // Arrange
        String longDescription = "A".repeat(91);
        Category category = new Category(3L, "Test Category", longDescription);
        when(categoryPersistancePort.existsByName(category.getName())).thenReturn(false);

        // Act & Assert
        assertThrows(CategoryDescriptionTooLongException.class, () -> categoryUseCase.save(category));
        verify(categoryPersistancePort, never()).save(category);
    }

    @Test
    void save_LongName_ShouldThrowCategoryNameTooLongException() {
        // Arrange
        String longName = "A".repeat(51);
        Category category = new Category(4L, longName, "Test Description");
        when(categoryPersistancePort.existsByName(category.getName())).thenReturn(false);

        // Act & Assert
        assertThrows(CategoryNameTooLongException.class, () -> categoryUseCase.save(category));
        verify(categoryPersistancePort, never()).save(category);
    }

    @Test
    void save_EmptyDescription_ShouldThrowCategoryDescriptionMissingException() {
        // Arrange
        Category category = new Category(5L, "Test Category", "");
        when(categoryPersistancePort.existsByName(category.getName())).thenReturn(false);

        // Act & Assert
        assertThrows(CategoryDescriptionMissingException.class, () -> categoryUseCase.save(category));
        verify(categoryPersistancePort, never()).save(category);
    }

    @Test
    void findAllCategories_ShouldReturnPageOfCategories() {
        // Arrange
        Pageable pageable = PageRequest.of(0, 10);
        List<Category> categories = Arrays.asList(
                new Category(6L, "Electronics", "Electronic devices"),
                new Category(7L, "Books", "Various books")
        );
        Page<Category> expectedPage = new PageImpl<>(categories, pageable, categories.size());

        when(categoryPersistancePort.findAllCategories(pageable)).thenReturn(expectedPage);

        // Act
        Page<Category> result = categoryUseCase.findAllCategories(pageable);

        // Assert
        assertEquals(expectedPage, result);
        assertEquals(2, result.getContent().size());
        assertEquals("Electronics", result.getContent().get(0).getName());
        assertEquals("Books", result.getContent().get(1).getName());

        verify(categoryPersistancePort).findAllCategories(pageable);
    }
}