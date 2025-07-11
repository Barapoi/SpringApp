package com.example.SpringApp.service;

import com.example.SpringApp.model.Buku;
import com.example.SpringApp.repository.BukuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BukuService {

    private final BukuRepository bukuRepository;

    // @Autowired tidak diperlukan jika hanya ada satu constructor
    public BukuService(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    public List<Buku> getAllBuku() {
        return bukuRepository.findAll();
    }

    public Buku addBuku(Buku buku) {
        return bukuRepository.save(buku);
    }
}