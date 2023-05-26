package com.leeonscoding.CRUDExample.controller;

import com.leeonscoding.CRUDExample.domain.Paste;
import com.leeonscoding.CRUDExample.pojo.PasteCreateInput;
import com.leeonscoding.CRUDExample.pojo.PasteUpdateInput;
import com.leeonscoding.CRUDExample.services.PasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pastes")
public class PasteController {

    @Autowired
    private PasteService pasteService;

    @PostMapping
    public ResponseEntity<HttpStatus> addPaste(@RequestBody PasteCreateInput paste) {
        pasteService.addPaste(paste);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paste> getSpecificPaste(@PathVariable long id) {
        Paste paste = pasteService.getOne(id);
        return new ResponseEntity<>(paste, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Paste>> getPages(@RequestParam int start,
                                                @RequestParam int size) {
        if (start < 0 || start > Integer.MAX_VALUE - 1) start = 0;
        if (size < 10 || size > Integer.MAX_VALUE - 1) start = 10;

        List<Paste> pastes = pasteService.getAllByPage(start, size);

        return new ResponseEntity<>(pastes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updatePaste(@PathVariable long id,
                                                  @RequestBody PasteUpdateInput paste) {
        pasteService.updatePaste(id, paste);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePaste(@PathVariable long id) {
        pasteService.deletePaste(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
