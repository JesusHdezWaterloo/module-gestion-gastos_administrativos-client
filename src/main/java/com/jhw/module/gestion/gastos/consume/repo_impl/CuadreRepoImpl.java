/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.gastos.consume.repo_impl;

import static com.jhw.module.gestion.gastos.core.ModuleGestionGastosConstants.*;
import com.jhw.module.util.rest_config.services.RESTHandler;
import com.jhw.utils.spring.client.ConsumerRepoTemplate;
import com.jhw.utils.spring.client.RestTemplateUtils;
import java.util.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CuadreRepoImpl extends ConsumerRepoTemplate<CuadreDomain> implements CuadreUseCase {

    public CuadreRepoImpl() {
        super(RESTHandler.restTemplate(), CuadreDomain.class, RESTHandler.urlActualREST() + CUADRE_GENERAL_PATH);
    }

    @Override
    public List<CuadreDomain> findAllPending() throws Exception {
        return RestTemplateUtils.getForList(template, urlGeneral + CUADRE_FIND_ALL_PENDING_PATH, CuadreDomain.class);
    }

    @Override
    public List<CuadreDomain> findAllLiquidadas() throws Exception {
        return RestTemplateUtils.getForList(template, urlGeneral + CUADRE_FIND_ALL_LIQUIDADAS_PATH, CuadreDomain.class);
    }

    @Override
    public List<CuadreDomain> findByLiquidada(boolean liquidada) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put(LIQUIDADA, liquidada);
        return RestTemplateUtils.getForList(template, urlGeneral + CUADRE_FIND_BY_LIQUIDADA_PATH, map, CuadreDomain.class);
    }

}
