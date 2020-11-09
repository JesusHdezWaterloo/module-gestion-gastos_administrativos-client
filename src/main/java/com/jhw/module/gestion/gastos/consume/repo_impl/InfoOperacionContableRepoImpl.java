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
public class InfoOperacionContableRepoImpl extends ConsumerRepoTemplate<InfoOperacionContableDomain> implements InfoOperacionContableUseCase {

    public InfoOperacionContableRepoImpl() {
        super(RESTHandler.restTemplate(), InfoOperacionContableDomain.class, RESTHandler.urlActualREST() + INFO_OP_CONTABLE_GENERAL_PATH);
    }

}
