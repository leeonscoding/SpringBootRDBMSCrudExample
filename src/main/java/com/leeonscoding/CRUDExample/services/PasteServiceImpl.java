package com.leeonscoding.CRUDExample.services;

import com.leeonscoding.CRUDExample.domain.Paste;
import com.leeonscoding.CRUDExample.pojo.PasteCreateInput;
import com.leeonscoding.CRUDExample.pojo.PasteUpdateInput;
import com.leeonscoding.CRUDExample.repository.PasteRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@Service
public class PasteServiceImpl implements PasteService {

    @Autowired
    private PasteRepository pasteRepository;

    @Override
    public void addPaste(PasteCreateInput pasteInput) throws RuntimeException {
        LocalDateTime now = LocalDateTime.now();

        Paste temp = Paste.builder()
                .author(pasteInput.author())
                .title(pasteInput.title())
                .content(pasteInput.content())
                .createdAt(now)
                .updatedAt(now)
                .deletionDateTime(now.plusHours(PasteService.DELETION_HOUR))
                .build();
        Paste newPaste = pasteRepository.save(temp);
        log.info("A paste is created" + newPaste.getId());
    }

    @Override
    public Paste getOne(long id) {
        return pasteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paste not found"));
    }

    @Override
    public List<Paste> getAllByPage(int start, int size) throws RuntimeException {
        Sort.TypedSort<Paste> noteSort = Sort.sort(Paste.class);
        Sort sort = noteSort.by(Paste::getCreatedAt)
                .descending();
        Pageable pageable = PageRequest.of(start, size, sort);

        return pasteRepository.findAll(pageable).toList();
    }

    @Override
    public void updatePaste(long id, PasteUpdateInput pasteInput) throws RuntimeException {
        Paste oldPaste = pasteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paste not found"));
        if (!(pasteInput.author() == null || pasteInput.author().isBlank())) {
            oldPaste.setAuthor(pasteInput.author());
        }
        if (!(pasteInput.content() == null || pasteInput.content().isBlank())) {
            oldPaste.setContent(pasteInput.content());
        }
        oldPaste.setUpdatedAt(LocalDateTime.now());

        pasteRepository.save(oldPaste);

        log.info("A paste is updated: " + oldPaste.getId());
    }

    @Override
    public void deletePaste(long id) throws RuntimeException {
        pasteRepository.deleteById(id);
        log.warn("A paste is deleted: " + id);
    }

    @Override
    public List<Paste> getOneByDeletionDateTime() {
        return pasteRepository.findByDeletionDateTime();
    }
}
