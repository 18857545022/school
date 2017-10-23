package com.project.service.impls;

import com.project.service.interfaces.StreamService;
import com.project.utils.CXFWebServiceInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service("streamService")
public class StreamServiceImpl implements StreamService {
    @Autowired
    private CXFWebServiceInvocation cXFWebServiceInvocation;

    @Override
    public String getStreamServiceByCameraIndexCodes(String code) {
        String wsdlUrl="http://10.0.13.178:8086/vms/services/CuService?wsdl";
        String method = "getStreamServiceByCameraIndexCodes";
        Object[] arg = new Object[]{null,0,code,100001L};
        Object[] result = cXFWebServiceInvocation.invokeWS(wsdlUrl, method, arg);
        return Arrays.toString(result);
    }
}
