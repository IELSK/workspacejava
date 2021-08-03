package com.dio.live.controller;

import com.dio.live.model.WorkingDay;
import com.dio.live.service.WorkingDayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/workingday")
@Api(value="Api REST")
@CrossOrigin(origins="*")

public class WorkingDayController {
    @Autowired
    WorkingDayService workingDayService;

    @PostMapping
    @ApiOperation(value="Cria tipo de jornada de trabalho")
    public WorkingDay createWorkingDay(@RequestBody WorkingDay workingDay){
        return workingDayService.saveWorkingDay(workingDay);
    }

    @GetMapping
    @ApiOperation(value="Retorna lista de tipos de jornada de trabalho")
    public List<WorkingDay> getWorkingDayList(){
        return workingDayService.findAll();
    }

    @GetMapping("/{idWorkingDay}")
    @ApiOperation(value="Retorna tipo de jornada de trabalho através do Id")
    public ResponseEntity<WorkingDay> getWorkingDayByID(@PathVariable("idWorkingDay") Long idWorkingDay) throws Exception {
       return ResponseEntity.ok(workingDayService.getById(idWorkingDay).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    @ApiOperation(value="Altera tipo de jornada de trabalho")
    public WorkingDay updateWorkingDay(@RequestBody WorkingDay workingDay){
        return workingDayService.updateWorkingDay(workingDay);
    }

    @DeleteMapping("/{idWorkingDay}")
    @ApiOperation(value="Deleta tipo de jornada de trabalho")
    public ResponseEntity<WorkingDay> deleteByID(@PathVariable("idWorkingDay") Long idWorkingDay) throws Exception {
        try {
            workingDayService.deleteWorkingDay(idWorkingDay);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<WorkingDay>) ResponseEntity.ok();
    }



}
