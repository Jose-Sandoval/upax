package com.upax.upax.repository;

import com.upax.upax.models.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository <Gender, Long> {

}
