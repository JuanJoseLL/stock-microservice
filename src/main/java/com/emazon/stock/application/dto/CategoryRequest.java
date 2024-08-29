package com.emazon.stock.application.dto;

import java.io.Serializable;

public record CategoryRequest (
        String name,
        String description
) implements Serializable {
}
