/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.gestion.gastos.consume.repo_impl;

import static com.root101.module.gestion.gastos.rest.ModuleGestionGastosRESTConstants.*;
import com.root101.module.gestion.gastos.core.domain.GastoDomain;
import com.root101.module.gestion.gastos.core.domain.TipoGastoDomain;
import com.root101.module.gestion.gastos.core.usecase_def.GastoUseCase;
import com.root101.module.util.rest_config.services.RESTHandler;
import com.root101.spring.client.ConsumerRepoTemplate;
import com.root101.spring.client.RestTemplateUtils;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import org.springframework.web.client.RestOperations;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class GastoRepoImpl extends ConsumerRepoTemplate<GastoDomain> implements GastoUseCase {

    public GastoRepoImpl() {
        super(GastoDomain.class, RESTHandler.urlActualREST() + GASTOS_GASTOS_GENERAL_PATH);
    }

    @Override
    protected RestOperations template() {
        return RESTHandler.OAuth2RestTemplate();
    }

    @Override
    public HashMap<TipoGastoDomain, BigDecimal> reporteGastadoPorGasto() throws Exception {
        return (HashMap<TipoGastoDomain, BigDecimal>) RestTemplateUtils.getForMap(template(), urlGeneral + GASTO_REPORTE_POR_TIPO_PATH, TipoGastoDomain.class, BigDecimal.class);
        //return null;
    }

    public List<Integer> findAllPending() throws Exception {
        return RestTemplateUtils.getForList(template(), urlGeneral, Integer.class);
    }

}
