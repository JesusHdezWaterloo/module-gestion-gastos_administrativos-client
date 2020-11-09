/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.gastos.consume.repo_impl;

import static com.jhw.module.gestion.gastos.core.ModuleGestionGastosConstants.*;
import com.jhw.module.gestion.gastos.core.domain.TipoGastoDomain;
import com.jhw.module.gestion.gastos.core.usecase_def.TipoGastoUseCase;
import com.jhw.module.util.rest_config.services.RESTHandler;
import com.jhw.utils.spring.client.ConsumerRepoTemplate;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class TipoGastoRepoImpl extends ConsumerRepoTemplate<TipoGastoDomain> implements TipoGastoUseCase {

    public TipoGastoRepoImpl() {
        super(RESTHandler.restTemplate(), TipoGastoDomain.class, RESTHandler.urlActualREST() + TIPO_GASTO_GENERAL_PATH);
    }
}
