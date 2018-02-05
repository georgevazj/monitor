package com.bbva.services.impl;

import com.bbva.constant.CmdConstant;
import com.bbva.services.SysInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jorge on 1/02/18.
 */

@Service
public class SysInfoServiceImpl implements SysInfoService {

    private static final Logger LOG = LoggerFactory.getLogger(SysInfoService.class);

    @Value("${dns.server}")
    private String dnsServer;
    @Value("${dns.server.target}")
    private String dnsTarget;

    @Override
    public String getHostname() {
        return executeCommand(CmdConstant.CMD_GET_HOSTNAME);
    }

    @Override
    public String getFreeMem() {
        String output = executeCommand(CmdConstant.CMD_GET_FREE_MEM);
        return output.replaceAll("\\D+","") + " Kb ";
    }

    @Override
    public String getCPUUsage() {
        String output = executeCommand(CmdConstant.CMD_GET_CPU_USAGE);
        String[] cpus = output.split(" ");
        float usage = (Integer.parseInt(cpus[2]) + Integer.parseInt(cpus[4])) * 100/(Integer.parseInt(cpus[2]) + Integer.parseInt(cpus[4]) + Integer.parseInt(cpus[5]));
        return String.valueOf(usage) + "%";
    }

    @Override
    public boolean getDNSStatus() {
        String output = executeCommand(String.format(CmdConstant.CMD_GET_DNS_STATUS, dnsServer, dnsTarget));

        Pattern pattern = Pattern.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        Matcher matcher = pattern.matcher(output);

        return matcher.find();
    }

    private String executeCommand(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader stdout =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stderr =
                    new BufferedReader(new InputStreamReader(p.getErrorStream()));

            String out = "";
            while ((out = stdout.readLine())!= null) {
                output.append(out);
            }

            String err = "";
            while ((err = stderr.readLine())!= null) {
                LOG.error("Error output: " + err);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }
}
