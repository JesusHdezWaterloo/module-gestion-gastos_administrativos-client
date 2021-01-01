/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.gastos.consume.usecase_impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.gestion.gastos.consume.module.GastosConsumeCoreModule;
import com.jhw.module.gestion.gastos.consume.repo_impl.*;
import com.jhw.module.gestion.gastos.consume.usecase_def.*;
import com.root101.module.gestion.gastos.core.domain.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class TipoGastoUseCaseImpl extends DefaultCRUDUseCase<TipoGastoDomain> implements TipoGastoUseCaseConsume {

    private final TipoGastoRepoImpl repoUC = GastosConsumeCoreModule.getInstance().getImplementation(TipoGastoRepoImpl.class);

    public TipoGastoUseCaseImpl() {
        setRepo(repoUC);
    }

}
