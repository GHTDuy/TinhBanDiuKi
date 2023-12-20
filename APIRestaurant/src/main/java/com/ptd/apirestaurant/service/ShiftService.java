package com.ptd.apirestaurant.service;


import com.ptd.apirestaurant.dto.ShiftDTO;
import com.ptd.apirestaurant.entity.Shift;
import com.ptd.apirestaurant.reponsitory.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftService {
    @Autowired
    ShiftRepository shiftRepository;

    private Shift toEntity(ShiftDTO shiftDTO){
        Shift shift = new Shift();
        shift.setShiftId(shiftDTO.getShiftId());
        shift.setShiftTimeStart(shiftDTO.getShiftTimeStart());
        shift.setShiftTimeEnd(shiftDTO.getShiftTimeEnd());
        shift.setDisabled(shiftDTO.getDisabled());
        return shift;
    }
    public List<Shift> getAllShif(){
        return shiftRepository.findAll();
    }

    public Shift createShift(ShiftDTO shiftDTO){
        return shiftRepository.save(toEntity(shiftDTO));
    }

    public  Boolean deleteShift(int idShift){
        try {
            Shift shift = shiftRepository.getShiftByShiftId(idShift);
            shift.setDisabled(false);
            shiftRepository.save(shift);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
