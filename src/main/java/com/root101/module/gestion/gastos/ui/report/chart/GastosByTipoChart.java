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
package com.root101.module.gestion.gastos.ui.report.chart;

import com.root101.clean.core.app.services.ExceptionHandler;
import com.jaga.swing.chart._MaterialBarChart;
import com.root101.utils.interfaces.Update;
import com.jhw.swing.material.standards.MaterialColors;
import com.root101.module.gestion.gastos.core.domain.TipoGastoDomain;
import com.root101.module.gestion.gastos.ui.module.GastoSwingModule;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class GastosByTipoChart extends _MaterialBarChart implements Update {

    public GastosByTipoChart() {
        addCategory("Tipo de gasto", MaterialColors.AMBERA_700);
        update();
    }

    @Override
    public void update() {
        removeAllBars();
        try {
            HashMap<TipoGastoDomain, BigDecimal> h = GastoSwingModule.gastoUC.reporteGastadoPorGasto();
            for (Map.Entry<TipoGastoDomain, BigDecimal> entry : h.entrySet()) {
                addBar(entry.getValue(), 0, entry.getKey().getNombreGasto());
            }
            if (h.isEmpty()) {
                this.getChart().setTitle("No hay gastos para mostrar ");
            } else {
                String moneda = h.keySet().iterator().next().getMonedaDefectoFk().getNombreMoneda();
                this.getChart().setTitle("Gastos Realizados por tipo (Conversión a: " + moneda + ")");
            }
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }

    }

}
