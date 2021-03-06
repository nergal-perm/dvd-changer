package ru.nergal.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface DiskRepository extends CrudRepository<Disk, Long>{
    @Query("select disk from TakenItem ti right join ti.disk as disk where ti.id is null and disk.owner != :user")
    Set<Disk> findAllFree(@Param("user") User user);
}
