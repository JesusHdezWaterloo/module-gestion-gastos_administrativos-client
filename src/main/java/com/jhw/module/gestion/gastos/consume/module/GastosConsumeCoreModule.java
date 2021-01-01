package com.jhw.module.gestion.gastos.consume.module;

import com.root101.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Modulo de Contabilidad_Empresarial-consume-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GastosConsumeCoreModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new GastosConsumeCoreInjectionConfig());

    private static GastosConsumeCoreModule INSTANCE;

    public static GastosConsumeCoreModule getInstance() {
        if (INSTANCE == null) {
            init();
        }
        return INSTANCE;
    }

    private static void init() {
        INSTANCE = new GastosConsumeCoreModule();
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    @Override
    public String getModuleName() {
        return "Contabilidad Empresarial Consume Core Module";
    }

}
