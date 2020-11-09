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
public class TipoCuentaRepoImpl extends ConsumerRepoTemplate<TipoCuentaDomain> implements TipoCuentaUseCase {

    public TipoCuentaRepoImpl() {
        super(RESTHandler.restTemplate(), TipoCuentaDomain.class, RESTHandler.urlActualREST() + TIPO_CUENTA_GENERAL_PATH);
    }

    /**
     * Delegate a findAllCuadre(Integer idTipoCuenta) para lightweight
     *
     * @param tipoCuenta
     * @return
     * @throws Exception
     */
    @Override
    public List<TipoCuentaDomain> findAllCuadre(TipoCuentaDomain tipoCuenta) throws Exception {
        return findAllCuadre(tipoCuenta.getIdTipoCuenta());
    }

    @Override
    public List<TipoCuentaDomain> findAllCuadre(Integer idTipoCuenta) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put(TIPO_CUENTA, idTipoCuenta);
        return RestTemplateUtils.getForList(template, urlGeneral + TIPO_CUENTA_FIND_ALL_CUADRE_PATH, map, TipoCuentaDomain.class);
    }

}
