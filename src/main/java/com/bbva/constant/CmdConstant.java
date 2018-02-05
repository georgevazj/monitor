package com.bbva.constant;

/**
 * Created by jorge on 1/02/18.
 */
public class CmdConstant {

    public static final String CMD_GET_HOSTNAME = "hostname";
    public static final String CMD_GET_FREE_MEM = "grep -i MemFree /proc/meminfo";
    public static final String CMD_GET_CPU_USAGE = "grep -m 1 cpu /proc/stat";
    public static final String CMD_GET_DNS_STATUS = "dig @%s %s +short";

}
