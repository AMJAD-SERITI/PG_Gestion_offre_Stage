package org.amjad.pg_gestion_offre_stage.Controller;

import org.amjad.pg_gestion_offre_stage.Service.CondidatService;
import org.amjad.pg_gestion_offre_stage.Service.RhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rh")
public class RhController {

    @Autowired
    private RhService rhService;

    @Autowired
    private CondidatService condidatService;
}
