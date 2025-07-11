package com.example.SpringApp.controller;

import com.example.SpringApp.model.Buku;
import com.example.SpringApp.service.BukuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buku")
public class BukuController {

    private final BukuService bukuService;

    // @Autowired tidak diperlukan jika hanya ada satu constructor
    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    @PostMapping
    public ResponseEntity<Buku> tambahBuku(@RequestBody Buku buku) {
        Buku bukuBaru = bukuService.addBuku(buku);
        return new ResponseEntity<>(bukuBaru, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Buku>> semuaBuku() {
        List<Buku> daftarBuku = bukuService.getAllBuku();
        return new ResponseEntity<>(daftarBuku, HttpStatus.OK);
    }
}