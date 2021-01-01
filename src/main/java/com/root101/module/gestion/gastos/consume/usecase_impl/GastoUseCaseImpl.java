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
package com.root101.module.gestion.gastos.consume.usecase_impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.root101.module.gestion.gastos.consume.module.GastosConsumeCoreModule;
import com.root101.module.gestion.gastos.consume.repo_impl.GastoRepoImpl;
import com.root101.module.gestion.gastos.consume.usecase_def.GastoUseCaseConsume;
import com.root101.module.gestion.gastos.core.domain.*;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class GastoUseCaseImpl extends DefaultCRUDUseCase<GastoDomain> implements GastoUseCaseConsume {

    private final GastoRepoImpl repoUC = GastosConsumeCoreModule.getInstance().getImplementation(GastoRepoImpl.class);

    public GastoUseCaseImpl() {
        setRepo(repoUC);
    }

    @Override
    public HashMap<TipoGastoDomain, BigDecimal> reporteGastadoPorGasto() throws Exception {
        return repoUC.reporteGastadoPorGasto();
    }

}
