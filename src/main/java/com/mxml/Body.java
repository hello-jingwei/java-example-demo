package com.mxml;

import lombok.Data;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "Body")
@Data
@XmlSeeAlso({World.class,User.class})
public class Body<T> {
    @XmlAnyElement(lax = true)
    private T value;
    private World world;
}
