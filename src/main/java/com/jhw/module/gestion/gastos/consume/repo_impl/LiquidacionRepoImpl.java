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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class LiquidacionRepoImpl extends ConsumerRepoTemplate<LiquidacionDomain> implements LiquidacionUseCase {

    public LiquidacionRepoImpl() {
        super(RESTHandler.restTemplate(), LiquidacionDomain.class, RESTHandler.urlActualREST() + LIQUIDACION_GENERAL_PATH);
    }

    /**
     * Delegate to findAll(Integer IdCuentaBancaria) para lightweight
     *
     * @param cuenta
     * @return
     * @throws Exception
     */
    @Override
    public List<LiquidacionDomain> findAll(CuentaBancariaDomain cuenta) throws Exception {
        return findAll(cuenta.getIdCuentaBancaria());
    }

    @Override
    public List<LiquidacionDomain> findAll(Integer IdCuentaBancaria) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put(CUENTA, IdCuentaBancaria);
        return RestTemplateUtils.getForList(template, urlGeneral + LIQUIDACION_FIND_ALL_PATH, map, LiquidacionDomain.class);
    }

    @Override
    public LiquidacionDomain getLiquidacion(CuadreDomain cuadre) throws Exception {
        return getLiquidacion(cuadre.getIdCuadre());
    }

    @Override
    public LiquidacionDomain getLiquidacion(Integer idCuadre) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put(CUADRE, idCuadre);
        return template.getForObject(urlGeneral + LIQUIDACION_GET_PATH, LiquidacionDomain.class, map);
    }

}
