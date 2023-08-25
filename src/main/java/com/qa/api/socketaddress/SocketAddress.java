package com.qa.api.socketaddress;

import lombok.Getter;

@Getter
public class SocketAddress {

    public static final String PROTOCOL = System.getProperty("protocol");
    public static final String HOST = System.getProperty("host");
    public static final String PORT = System.getProperty("port");
}