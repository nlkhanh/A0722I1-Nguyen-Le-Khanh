package codegym.m4_case_study.repository;

import codegym.m4_case_study.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.List;

public interface FacilityRepository extends JpaRepository<Facility, Long> {
    void deleteAllByIdIn(List<Long> deleteIds);

    @Query(value = "select * " +
                    "from facility f inner join facility_type ft on f.facility_type_id = ft.id " +
                    "inner join rent_type rt ON f.rent_type_id  = rt.id " +
                    "where f.name like concat('%',:search,'%') or " +
                    "ft.name like concat('%',:search,'%') or " +
                    "f.area like concat('%',:search,'%') or " +
                    "f.cost like concat('%',:search,'%') or " +
                    "f.max_people like concat('%',:search,'%') or " +
                    "rt.name like concat('%',:search,'%') or " +
                    "f.standard_room like concat('%',:search,'%') or " +
                    "f.description_other_convenience like concat('%',:search,'%') or " +
                    "f.pool_area like concat('%',:search,'%') or " +
                    "f.number_of_floors like concat('%',:search,'%') or " +
                    "f.facility_free like concat('%',:search,'%')",
            countQuery = "select count(*) " +
                    "from facility f inner join facility_type ft on f.facility_type_id = ft.id " +
                    "inner join rent_type rt ON f.rent_type_id  = rt.id " +
                    "where f.name like concat('%',:search,'%') or " +
                    "ft.name like concat('%',:search,'%') or " +
                    "f.area like concat('%',:search,'%') or " +
                    "f.cost like concat('%',:search,'%') or " +
                    "f.max_people like concat('%',:search,'%') or " +
                    "rt.name like concat('%',:search,'%') or " +
                    "f.standard_room like concat('%',:search,'%') or " +
                    "f.description_other_convenience like concat('%',:search,'%') or " +
                    "f.pool_area like concat('%',:search,'%') or " +
                    "f.number_of_floors like concat('%',:search,'%') or " +
                    "f.facility_free like concat('%',:search,'%')",
            nativeQuery = true)
    Page<Facility> findAllSearch(@Param("search") String search, Pageable pageable);
}