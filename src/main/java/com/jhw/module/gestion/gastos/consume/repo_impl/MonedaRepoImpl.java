/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.gastos.consume.repo_impl;

import static com.jhw.module.gestion.gastos.core.ModuleGestionGastosConstants.*;
import com.jhw.module.util.rest_config.services.RESTHandler;
import com.jhw.utils.spring.client.ConsumerRepoTemplate;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MonedaRepoImpl extends ConsumerRepoTemplate<MonedaDomain> implements MonedaUseCase {

    public MonedaRepoImpl() {
        super(RESTHandler.restTemplate(), MonedaDomain.class, RESTHandler.urlActualREST() + MONEDA_GENERAL_PATH);
    }

    @Override
    public MonedaDomain findMonedaBase() throws Exception {
        return template.getForObject(urlGeneral + MONEDA_FIND_BASE_PATH, MonedaDomain.class);
    }

}
