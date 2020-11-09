package com.jhw.module.gestion.gastos.consume.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.jhw.module.gestion.gastos.consume.usecase_def.*;
import com.jhw.module.gestion.gastos.consume.usecase_impl.*;
import com.jhw.module.gestion.gastos.core.usecase_def.*;

/**
 * Configuracion del injection del modulo de PlanTrabajo-consume-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GastosConsumeCoreInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(GastoUseCase.class).to(GastoUseCaseImpl.class).in(Singleton.class);
        bind(GastoUseCaseConsume.class).to(GastoUseCaseImpl.class).in(Singleton.class);

        bind(TipoGastoUseCase.class).to(TipoGastoUseCaseImpl.class).in(Singleton.class);
        bind(TipoGastoUseCaseConsume.class).to(TipoGastoUseCaseImpl.class).in(Singleton.class);
    }

}
