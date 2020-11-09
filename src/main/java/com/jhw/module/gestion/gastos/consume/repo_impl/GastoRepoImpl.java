/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.gastos.consume.repo_impl;

import static com.jhw.module.gestion.gastos.core.ModuleGestionGastosConstants.*;
import com.jhw.module.gestion.gastos.core.domain.GastoDomain;
import com.jhw.module.gestion.gastos.core.domain.TipoGastoDomain;
import com.jhw.module.gestion.gastos.core.usecase_def.GastoUseCase;
import com.jhw.module.util.rest_config.services.RESTHandler;
import com.jhw.utils.spring.client.ConsumerRepoTemplate;
import com.jhw.utils.spring.client.RestTemplateUtils;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GastoRepoImpl extends ConsumerRepoTemplate<GastoDomain> implements GastoUseCase {

    public GastoRepoImpl() {
        super(RESTHandler.restTemplate(), GastoDomain.class, RESTHandler.urlActualREST() + GASTOS_GASTOS_GENERAL_PATH);
    }

    @Override
    public HashMap<TipoGastoDomain, BigDecimal> reporteGastadoPorGasto() throws Exception {
        return (HashMap<TipoGastoDomain, BigDecimal>) RestTemplateUtils.getForMap(template, urlGeneral + GASTO_REPORTE_POR_TIPO_PATH, TipoGastoDomain.class, BigDecimal.class);
        //return null;
    }

    public List<Integer> findAllPending() throws Exception {
        return RestTemplateUtils.getForList(template, urlGeneral, Integer.class);
    }

}
