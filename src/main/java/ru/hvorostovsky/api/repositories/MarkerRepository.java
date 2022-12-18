package ru.hvorostovsky.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hvorostovsky.api.domain.entities.Marker;

@Repository
public interface MarkerRepository extends JpaRepository<Marker, Long> {

}
