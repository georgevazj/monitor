package com.bbva.services;

/**
 * Created by jorge on 1/02/18.
 */
public interface SysInfoService {

    public abstract String getHostname();
    public abstract String getFreeMem();
    public abstract String getCPUUsage();
    public abstract boolean getDNSStatus();

}
