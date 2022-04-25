package com.mxml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CDATATypeAdapter extends XmlAdapter<String, String> {
    @Override
    public String unmarshal(String val) throws Exception {
        return val.replace("<![CDATA[","").replace("]]>","");
    }

    @Override
    public String marshal(String val) throws Exception {
        return "<![CDATA[" + val + "]]>";
    }
}
