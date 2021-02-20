package com.upax.upax.repository;

import com.upax.upax.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository <Job, Long> {

}
