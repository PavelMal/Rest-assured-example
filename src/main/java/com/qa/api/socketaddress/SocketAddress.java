package com.qa.api.socketaddress;

import lombok.Getter;

@Getter
public class SocketAddress {

    public static final String protocol = System.getProperty("protocol");
    public static final String host = System.getProperty("host");
}