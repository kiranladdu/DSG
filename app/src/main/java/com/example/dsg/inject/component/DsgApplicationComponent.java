package com.example.dsg.inject.component;

import com.example.dsg.inject.modules.DsgModule;
import com.example.dsg.inject.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {DsgModule.class, NetworkModule.class})
public interface DsgApplicationComponent extends DsgComponent {
}
