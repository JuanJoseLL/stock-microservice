package com.emazon.stock.application.usecases;

import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.spi.IBrandPersistancePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BrandUseCaseTest {
    @Mock
    private IBrandPersistancePort brandPersistancePort;

    private BrandUseCase brandUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        brandUseCase = new BrandUseCase(brandPersistancePort);
    }

    @Test
    void save_ValidBrand_ShouldSaveSuccessfully() {
        // Arrange
        Brand brand = new Brand(1L, "Test Brand", "Test Description");
        when(brandPersistancePort.existsByName(brand.getName())).thenReturn(false);
        when(brandPersistancePort.save(brand)).thenReturn(brand);

        // Act
        Brand savedBrand = brandUseCase.save(brand);

        // Assert
        assertNotNull(savedBrand);
        assertEquals(brand, savedBrand);
        verify(brandPersistancePort).save(brand);
    }

    @Test
    void save_ExistingBrand_ShouldThrowRuntimeException() {
        // Arrange
        Brand brand = new Brand(2L, "Existing Brand", "Test Description");
        when(brandPersistancePort.existsByName(brand.getName())).thenReturn(true);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> brandUseCase.save(brand));
        verify(brandPersistancePort, never()).save(brand);
    }

    @Test
    void save_EmptyDescription_ShouldThrowRuntimeException() {
        // Arrange
        Brand brand = new Brand(3L, "Test Brand", "");

        // Act & Assert
        assertThrows(RuntimeException.class, () -> brandUseCase.save(brand));
        verify(brandPersistancePort, never()).save(brand);
    }

    @Test
    void save_LongName_ShouldThrowRuntimeException() {
        // Arrange
        String longName = "A".repeat(51);
        Brand brand = new Brand(4L, longName, "Test Description");

        // Act & Assert
        assertThrows(RuntimeException.class, () -> brandUseCase.save(brand));
        verify(brandPersistancePort, never()).save(brand);
    }

    @Test
    void save_LongDescription_ShouldThrowRuntimeException() {
        // Arrange
        String longDescription = "A".repeat(121);
        Brand brand = new Brand(5L, "Test Brand", longDescription);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> brandUseCase.save(brand));
        verify(brandPersistancePort, never()).save(brand);
    }

}