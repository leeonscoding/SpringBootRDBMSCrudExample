package com.leeonscoding.CRUDExample.services;

import com.leeonscoding.CRUDExample.domain.Paste;
import com.leeonscoding.CRUDExample.pojo.PasteCreateInput;
import com.leeonscoding.CRUDExample.pojo.PasteUpdateInput;

import java.util.List;

public interface PasteService {
    int DELETION_HOUR = 1;
    int MAX_TITLE_LENGTH = 100;
    int MAX_AUTHOR_LENGTH = 100;
    int MAX_CONTENT_LENGTH = 2000;

    void addPaste(PasteCreateInput paste);
    Paste getOne(long id);
    List<Paste> getAllByPage(int start, int size);
    void updatePaste(long id, PasteUpdateInput paste);
    void deletePaste(long id);
    List<Paste> getOneByDeletionDateTime();
}
