package com.project.utils;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
@Component
public class CXFWebServiceInvocation {

    public static final ConcurrentHashMap<String,Client> clientMap = new ConcurrentHashMap<String,Client>();

    public static Object[] invokeWS(String wsdlUrl, String method, Object[] args) {
        Object[] res = null;
        try {
            Client client = clientMap.get(wsdlUrl.toString());
            if(client==null){
                JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
                client = factory.createClient(wsdlUrl.toString());
                clientMap.putIfAbsent(wsdlUrl.toString(), client);
            }
            res = client.invoke(method, args);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

   /* public static void main(String[] args) throws InvalidProtocolBufferException {
        long time = System.currentTimeMillis();
        String wsdlUrl = "http://10.0.13.178:8086/vms/services/CuService?wsdl";
        String method = "getStreamServiceByCameraIndexCodes";
        Object[] arg = new Object[]{null,0,"33000000001310016872",100001L};
        Object[] result = invokeWS(wsdlUrl, method, arg);
		*//*for(String item:response.getReturn()){
			System.out.println("Current Local NO:" + item.getCurrentLocalNo());
			System.out.println("Current NO:" + item.getCurrentNo());
		}*//*
        System.out.println(Arrays.toString(result));
    }*/
}