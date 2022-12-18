package ru.hvorostovsky.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hvorostovsky.api.domain.entities.Spectacle;

@Repository
public interface SpectaclesRepository extends JpaRepository<Spectacle, Long> {

}
