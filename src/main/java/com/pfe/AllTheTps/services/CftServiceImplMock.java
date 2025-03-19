package com.pfe.AllTheTps.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnMissingBean(CftServiceImolReal.class)
@Slf4j
public class CftServiceImplMock implements ICftService{
    public CftServiceImplMock() {
        log.debug("CONSTRUCTOR CFTSERVICEIMPLMOCK");
    }

    @Override

    public void SENDFILEPGP(String pathfile) {

        log.debug("SIMULATION SEND FILE BY CFT");
    }
}
