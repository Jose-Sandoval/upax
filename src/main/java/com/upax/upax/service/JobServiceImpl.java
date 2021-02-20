package com.upax.upax.service;

import com.upax.upax.models.Job;
import com.upax.upax.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService{

    private final JobRepository jobRepository;

    @Override
    public Job getJob(Long id) {
        Optional <Job> job = jobRepository.findById(id);
        if (job.isPresent()){
            return job.get();
        }
        return null;
    }
}
