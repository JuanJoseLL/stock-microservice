package com.emazon.stock.domain.usecases;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryUseCaseTest {

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
        Category category = new Category(1L,"Test Category", "Test Description");
        when(categoryPersistancePort.existsByName(category.getName())).thenReturn(false);

        assertDoesNotThrow(() -> categoryUseCase.save(category));
        verify(categoryPersistancePort).save(category);
    }

    @Test
    void save_ExistingCategory_ShouldThrowCategoryAlreadyExistException() {
        Category category = new Category(2L,"Existing Category", "Test Description");
        when(categoryPersistancePort.existsByName(category.getName())).thenReturn(true);

        assertThrows(CategoryAlreadyExistException.class, () -> categoryUseCase.save(category));
        verify(categoryPersistancePort, never()).save(category);
    }

    @Test
    void save_LongDescription_ShouldThrowCategoryDescriptionTooLongException() {
        String longDescription = "A".repeat(91);
        Category category = new Category(3L, "Test Category", longDescription);
        when(categoryPersistancePort.existsByName(category.getName())).thenReturn(false);

        assertThrows(CategoryDescriptionTooLongException.class, () -> categoryUseCase.save(category));
        verify(categoryPersistancePort, never()).save(category);
    }

    @Test
    void save_LongName_ShouldThrowCategoryNameTooLongException() {
        String longName = "A".repeat(51);
        Category category = new Category(4L, longName, "Test Description");
        when(categoryPersistancePort.existsByName(category.getName())).thenReturn(false);

        assertThrows(CategoryNameTooLongException.class, () -> categoryUseCase.save(category));
        verify(categoryPersistancePort, never()).save(category);
    }

    @Test
    void save_EmptyDescription_ShouldThrowCategoryDescriptionMissingException() {
        Category category = new Category(5L, "Test Category", "");
        when(categoryPersistancePort.existsByName(category.getName())).thenReturn(false);

        assertThrows(CategoryDescriptionMissingException.class, () -> categoryUseCase.save(category));
        verify(categoryPersistancePort, never()).save(category);
    }
}