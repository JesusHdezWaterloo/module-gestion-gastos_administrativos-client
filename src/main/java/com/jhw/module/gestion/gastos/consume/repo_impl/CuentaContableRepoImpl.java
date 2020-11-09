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
public class CuentaContableRepoImpl extends ConsumerRepoTemplate<CuentaContableDomain> implements CuentaContableUseCase {

    public CuentaContableRepoImpl() {
        super(RESTHandler.restTemplate(), CuentaContableDomain.class, RESTHandler.urlActualREST() + CUENTA_CONTABLE_GENERAL_PATH);
    }

    @Override
    public List<Cuenta> findAllCuentas() throws Exception {
        return RestTemplateUtils.getForList(template, urlGeneral + CUENTA_CONTABLE_FIND_ALL_CUENTAS_PATH, Cuenta.class);
    }

    /**
     * Delegate to findAllCuenta(Integer idTipoCuenta) para lightweight
     *
     * @param tipo
     * @return
     * @throws Exception
     */
    @Override
    public List<CuentaContableDomain> findAllCuenta(TipoCuentaDomain tipo) throws Exception {
        return findAllCuenta(tipo.getIdTipoCuenta());
    }

    @Override
    public List<CuentaContableDomain> findAllCuenta(Integer idTipoCuenta) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put(TIPO_CUENTA, idTipoCuenta);
        return RestTemplateUtils.getForList(template, urlGeneral + CUENTA_CONTABLE_FIND_ALL_PATH, map, CuentaContableDomain.class);
    }

    @Override
    public List<CuentaContableDomain> findAll(String text) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put(SEARCH_TEXT, text);
        return RestTemplateUtils.getForList(template, urlGeneral + CUENTA_CONTABLE_FIND_ALL_SEARCH_PATH, map, CuentaContableDomain.class);
    }
}
