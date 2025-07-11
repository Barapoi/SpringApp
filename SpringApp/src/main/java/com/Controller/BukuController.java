package com.Controller;

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

    @GetMapping("/{id}")
    public ResponseEntity<Buku> getBukuById(@PathVariable Long id) {
        Buku buku = bukuService.getBukuById(id);
        if (buku != null) {
            return new ResponseEntity<>(buku, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Buku> updateBuku(@PathVariable Long id, @RequestBody Buku buku) {
        Buku updatedBuku = bukuService.updateBuku(id, buku);
        if (updatedBuku != null) {
            return new ResponseEntity<>(updatedBuku, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuku(@PathVariable Long id) {
        boolean deleted = bukuService.deleteBuku(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
