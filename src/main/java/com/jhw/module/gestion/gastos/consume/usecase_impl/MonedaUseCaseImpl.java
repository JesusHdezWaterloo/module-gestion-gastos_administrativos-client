/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.gastos.consume.usecase_impl;

import com.clean.core.app.services.ExceptionHandler;
import com.clean.core.app.usecase.*;
import com.jhw.module.gestion.gastos.consume.module.ContabilidadConsumeCoreModule;
import com.jhw.module.gestion.contabilidad.core.domain.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MonedaUseCaseImpl extends DefaultCRUDUseCase<MonedaDomain> implements MonedaUseCaseConsume {

    private final MonedaRepoImpl repoUC = ContabilidadConsumeCoreModule.getInstance().getImplementation(MonedaRepoImpl.class);

    private MonedaDomain base = null;

    public MonedaUseCaseImpl() {
        setRepo(repoUC);
    }

    @Override
    public MonedaDomain findMonedaBase() throws Exception {
        return repoUC.findMonedaBase();
    }

    @Override
    public MonedaDomain getMonedaBase() {
        if (base == null) {
            try {
                base = findMonedaBase();
            } catch (Exception e) {
                ExceptionHandler.handleException(e);
            }
        }
        return base;
    }

}
