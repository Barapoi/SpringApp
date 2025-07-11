package com.example.SpringApp.repository;

import com.example.SpringApp.model.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Long> {
    // Tidak perlu diisi untuk CRUD dasar
}