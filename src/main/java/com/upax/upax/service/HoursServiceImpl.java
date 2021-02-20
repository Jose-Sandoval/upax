package com.upax.upax.service;

import com.upax.upax.models.Employee;
import com.upax.upax.models.Hours;
import com.upax.upax.repository.HoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HoursServiceImpl implements HoursService{

    @PersistenceContext
    private EntityManager entityManager;

    private final HoursRepository hoursRepository;

    @Override
    public List<Hours> findByemployeeId(Employee employee) {
        return hoursRepository.findByEmployeeId(employee);
    }

    @Override
    public List<Hours> findByDate(Date date) {
        return hoursRepository.findByDate(date);
    }

    @Override
    public Hours createHours(Hours hours) {
        return hoursRepository.save(hours);
    }

    @Override
    public Integer countHours(Long id, Date start_date, Date end_date) {
        return hoursRepository.countHours(id, start_date, end_date);
    }

}
