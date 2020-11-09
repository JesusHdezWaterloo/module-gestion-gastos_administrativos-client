/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.gastos.consume.usecase_impl;

import com.clean.core.app.usecase.*;
import com.jhw.module.gestion.gastos.consume.module.GastosConsumeCoreModule;
import com.jhw.module.gestion.gastos.consume.repo_impl.*;
import com.jhw.module.gestion.gastos.consume.usecase_def.*;
import com.jhw.module.gestion.gastos.core.domain.*;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GastoUseCaseImpl extends DefaultCRUDUseCase<GastoDomain> implements GastoUseCaseConsume {

    private final GastoRepoImpl repoUC = GastosConsumeCoreModule.getInstance().getImplementation(GastoRepoImpl.class);

    public GastoUseCaseImpl() {
        setRepo(repoUC);
    }

    @Override
    public HashMap<TipoGastoDomain, BigDecimal> reporteGastadoPorGasto() throws Exception {
        return repoUC.reporteGastadoPorGasto();
    }

}
