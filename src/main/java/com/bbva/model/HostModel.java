package com.bbva.model;

/**
 * Created by jorge on 1/02/18.
 */
public class HostModel {

    private String hostname;
    private String freeMem;
    private String cpuUsage;
    private boolean DNSAlive;

    public HostModel() {
    }

    public HostModel(String hostname, String freeMem, String cpuUsage, boolean DNSAlive) {
        this.hostname = hostname;
        this.freeMem = freeMem;
        this.cpuUsage = cpuUsage;
        this.DNSAlive = DNSAlive;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getFreeMem() {
        return freeMem;
    }

    public void setFreeMem(String freeMem) {
        this.freeMem = freeMem;
    }

    public String getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(String cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public boolean isDNSAlive() {
        return DNSAlive;
    }

    public void setDNSAlive(boolean DNSAlive) {
        this.DNSAlive = DNSAlive;
    }

    @Override
    public String toString() {
        return "HostModel{" +
                "hostname='" + hostname + '\'' +
                ", freeMem='" + freeMem + '\'' +
                ", cpuUsage='" + cpuUsage + '\'' +
                ", DNSAlive=" + DNSAlive +
                '}';
    }
}
