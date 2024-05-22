package com.devitro.turisticka.agencija.repository;

import com.devitro.turisticka.agencija.entity.TuristickiPaket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TuristickiPaketRepository extends JpaRepository<TuristickiPaket, Long> {
   Optional<TuristickiPaket> findById(Long id);
   @Query("SELECT tp FROM TuristickiPaket tp WHERE (:destinacija IS NULL OR tp.destinacija LIKE %:destinacija%) " +
           "AND (:startDate IS NULL OR tp.datumPutovanja >= :startDate) " +
           "AND (:endDate IS NULL OR tp.datumPutovanja <= :endDate) " +
           "AND (:minPrice IS NULL OR tp.cena >= :minPrice) " +
           "AND (:maxPrice IS NULL OR tp.cena <= :maxPrice)")
   List<TuristickiPaket> findByFilter(
           @Param("destinacija") String destinacija,
           @Param("startDate") LocalDate startDate,
           @Param("endDate") LocalDate endDate,
           @Param("minPrice") BigDecimal minPrice,
           @Param("maxPrice") BigDecimal maxPrice
   );
}
