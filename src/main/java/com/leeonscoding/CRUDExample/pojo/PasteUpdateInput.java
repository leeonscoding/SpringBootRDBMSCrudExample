package com.leeonscoding.CRUDExample.pojo;

import com.leeonscoding.CRUDExample.services.PasteService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public record PasteUpdateInput(@Max(PasteService.MAX_CONTENT_LENGTH) String content,
                               @Max(PasteService.MAX_AUTHOR_LENGTH) String author) {
}
