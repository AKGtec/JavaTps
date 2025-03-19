package com.pfe.AllTheTps.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"QUA", "PROD"})
@Slf4j
public class CftServiceImolReal implements ICftService{
    public CftServiceImolReal() {
        log.debug("CONSTRUCTOR CFTSERVICEIMPLREAL");
    }

    @Override
    public void SENDFILEPGP(String pathfile) {
        log.debug("REAL SEND FILE BY CFT");
    }
}
