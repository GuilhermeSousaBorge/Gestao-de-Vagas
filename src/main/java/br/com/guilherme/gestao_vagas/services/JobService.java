package br.com.guilherme.gestao_vagas.services;

import br.com.guilherme.gestao_vagas.models.JobEntity;
import br.com.guilherme.gestao_vagas.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity createJob(JobEntity job){

        return this.jobRepository.save(job);

    }
}
