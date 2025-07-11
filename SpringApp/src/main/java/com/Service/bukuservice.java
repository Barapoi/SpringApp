package com.Service;

import com.example.SpringApp.model.Buku;
import com.example.SpringApp.repository.BukuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Buku getBukuById(Long id) {
        return bukuRepository.findById(id).orElse(null);
    }

    public Buku addBuku(Buku buku) {
        return bukuRepository.save(buku);
    }

    public Buku updateBuku(Long id, Buku bukuDetails) {
        Optional<Buku> optionalBuku = bukuRepository.findById(id);
        if (optionalBuku.isPresent()) {
            Buku existingBuku = optionalBuku.get();
            existingBuku.setJudul(bukuDetails.getJudul());
            existingBuku.setPenulis(bukuDetails.getPenulis());
            existingBuku.setTahunTerbit(bukuDetails.getTahunTerbit());
            existingBuku.setKategori(bukuDetails.getKategori());
            return bukuRepository.save(existingBuku);
        }
        return null; // Atau throw exception jika buku tidak ditemukan
    }

    public boolean deleteBuku(Long id) {
        if (bukuRepository.existsById(id)) {
            bukuRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
