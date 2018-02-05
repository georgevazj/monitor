package com.bbva.controller;

import com.bbva.model.HostModel;
import com.bbva.services.SysInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jorge on 1/02/18.
 */

@RestController
public class StatusController {

    private static final Logger LOG = LoggerFactory.getLogger(StatusController.class);

    @Autowired
    private SysInfoService service;

    @RequestMapping("/status")
    public HostModel getStatus() throws Exception{
        return new HostModel(service.getHostname(), service.getFreeMem(), service.getCPUUsage(), service.getDNSStatus());
    }

}
