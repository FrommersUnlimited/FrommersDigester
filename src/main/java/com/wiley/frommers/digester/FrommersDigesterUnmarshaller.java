package com.wiley.frommers.digester;

import com.wiley.frommers.digester.impl.XStreamFrommersDigester;

public enum FrommersDigesterUnmarshaller {

    XSTREAM(XStreamFrommersDigester.class);
    
    private Class<? extends FrommersDigester> unmarshallingDigesterClass;
    
    private FrommersDigesterUnmarshaller(Class<? extends FrommersDigester> unmarshallingDigester) {
        this.unmarshallingDigesterClass = unmarshallingDigester;
    }
    
    public Class<? extends FrommersDigester> getUnmarshallingDigesterClass() {
        return unmarshallingDigesterClass;
    }
}
