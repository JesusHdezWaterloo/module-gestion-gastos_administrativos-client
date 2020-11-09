/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.gastos.consume.usecase_impl;

import com.clean.core.app.usecase.*;
import com.jhw.module.gestion.gastos.consume.module.ContabilidadConsumeCoreModule;
import com.jhw.module.gestion.contabilidad.core.domain.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class TipoOperacionContableUseCaseImpl extends DefaultCRUDUseCase<TipoOperacionContableDomain> implements TipoOperacionContableUseCaseConsume {

    private final TipoOperacionContableRepoImpl repoUC = ContabilidadConsumeCoreModule.getInstance().getImplementation(TipoOperacionContableRepoImpl.class);

    public TipoOperacionContableUseCaseImpl() {
        setRepo(repoUC);
    }

    @Override
    public TipoOperacionContableDomain findByKey(String key) {
        return repoUC.findByKey(key);
    }

}
