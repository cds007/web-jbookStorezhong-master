package org.csu.webJpetStore.service;

import org.csu.webJpetStore.domain.Log;
import org.csu.webJpetStore.persistence.Impl.LogDAOImpl;
import org.csu.webJpetStore.persistence.LogDAO;

public class LogService {
    Log log;
    private LogDAO logDAO;

    public LogService(){
        log = new Log();
        logDAO = new LogDAOImpl();
    }

    public String logInfo(Object ...s){
        return log.logInfomation(s);
    }

    public void insertLogInfo(String username, String logInfo){
        logDAO.insertLog(username, logInfo);
    }
}
