package com.reflect.framework.service;

import com.reflect.framework.annotation.FrAnnotation;

public interface EvtService {
    void introduce(@FrAnnotation(name = {"Lee", "Zhang"}) String... names);
}
