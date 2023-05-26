package com.leeonscoding.CRUDExample.pojo;

import com.leeonscoding.CRUDExample.services.PasteService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public record PasteCreateInput(@NotNull @Max(PasteService.MAX_CONTENT_LENGTH) String content,
                               @NotNull @Max(PasteService.MAX_TITLE_LENGTH) String title,
                               @NotNull @Max(PasteService.MAX_AUTHOR_LENGTH) String author) {
}
