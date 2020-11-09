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
public class FormaPagoRepoImpl extends ConsumerRepoTemplate<FormaPagoDomain> implements FormaPagoUseCase {

    public FormaPagoRepoImpl() {
        super(RESTHandler.restTemplate(), FormaPagoDomain.class, RESTHandler.urlActualREST() + FORMA_PAGO_GENERAL_PATH);
    }

}
