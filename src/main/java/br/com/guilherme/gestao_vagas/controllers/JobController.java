package br.com.guilherme.gestao_vagas.controllers;

import br.com.guilherme.gestao_vagas.dto.CreateJobDTO;
import br.com.guilherme.gestao_vagas.models.JobEntity;
import br.com.guilherme.gestao_vagas.services.JobService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity<Object> createJob(@RequestBody CreateJobDTO jobDTO, HttpServletRequest request){
        var companyId = request.getAttribute("company_id");

        var jobRequest = JobEntity.builder()
                .benefits(jobDTO.benefits())
                .level(jobDTO.level())
                .description(jobDTO.description())
                .companyId(UUID.fromString(companyId.toString()))
                .build();
        var response = this.jobService.createJob(jobRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//        try{
//            var response = this.jobService.createJob(jobRequest);
//            return ResponseEntity.status(HttpStatus.CREATED).body(response);
//        }catch (Exception e){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
    }
}
