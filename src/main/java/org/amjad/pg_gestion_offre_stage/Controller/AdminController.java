/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.amjad.pg_gestion_offre_stage.Controller;

import org.amjad.pg_gestion_offre_stage.Entity.Encadrant;
import org.amjad.pg_gestion_offre_stage.Service.AdminService;
import org.amjad.pg_gestion_offre_stage.Service.EncadrantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;
    private final EncadrantService encadrantService;

    public AdminController(AdminService adminService , EncadrantService encadrantService) {
        this.adminService = adminService;
        this.encadrantService = encadrantService;
    }

    @PostMapping("/addEncadrent")
    public String addEncadrent(@RequestBody Encadrant encadrant) {
        encadrantService.saveEncadrant(encadrant);
        return "Encadrant added";
    }

    @PostMapping("/validateEncadrant/{id}")
    public String validateEncadrant(Long id) {
        encadrantService.validateEncadrant(id);
        return "Encadrant with id " + id + " has been validated";
    }
}
