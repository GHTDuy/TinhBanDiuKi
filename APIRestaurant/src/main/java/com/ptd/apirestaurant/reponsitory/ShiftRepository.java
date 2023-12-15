package com.ptd.apirestaurant.reponsitory;


import com.ptd.apirestaurant.entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftRepository extends JpaRepository<Shift , Integer> {
    Shift getShiftByShiftId(int shiftID);
}
