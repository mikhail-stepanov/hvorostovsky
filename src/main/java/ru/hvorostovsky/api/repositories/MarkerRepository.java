package ru.hvorostovsky.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hvorostovsky.api.domain.entities.Marker;

import java.util.List;

@Repository
public interface MarkerRepository extends JpaRepository<Marker, Long> {

    @Query(
            value = "select * from markers where id in (select marker_id from spectacles where id in (select spectacle_id from audios))",
            nativeQuery = true)
    List<Marker> findAllByAudios();
}
