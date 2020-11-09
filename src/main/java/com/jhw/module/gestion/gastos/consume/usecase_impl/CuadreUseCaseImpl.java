/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.gastos.consume.usecase_impl;

import com.clean.core.app.usecase.*;
import com.jhw.module.gestion.gastos.consume.module.ContabilidadConsumeCoreModule;
import com.jhw.module.gestion.contabilidad.core.domain.*;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CuadreUseCaseImpl extends DefaultCRUDUseCase<CuadreDomain> implements CuadreUseCaseConsume {

    private final CuadreRepoImpl repoUC = ContabilidadConsumeCoreModule.getInstance().getImplementation(CuadreRepoImpl.class);

    public CuadreUseCaseImpl() {
        setRepo(repoUC);
    }

    @Override
    public List<CuadreDomain> findAllPending() throws Exception {
        return repoUC.findAllPending();
    }

    @Override
    public List<CuadreDomain> findAllLiquidadas() throws Exception {
        return repoUC.findAllLiquidadas();
    }

    @Override
    public List<CuadreDomain> findByLiquidada(boolean liquidada) throws Exception {
        return repoUC.findByLiquidada(liquidada);
    }

}
