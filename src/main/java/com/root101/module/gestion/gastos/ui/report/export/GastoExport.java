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
package com.root101.module.gestion.gastos.ui.report.export;

import com.root101.export.excel.ExcelListWriter;
import com.root101.module.gestion.gastos.core.domain.GastoDomain;
import com.root101.module.gestion.gastos.ui.gasto.GastoDetailView;
import com.root101.swing.material.components.table.editors_renders.money.MoneyTableComponent;
import com.root101.swing.models.utils.DefaultExportableConfig;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class GastoExport extends DefaultExportableConfig<GastoDomain> {

    public static GastoExport from(GastoDetailView detail) {
        return new GastoExport(detail);
    }

    public GastoExport(GastoDetailView detail) {
        super(detail);
    }

    @Override
    public Object[] getRowObjectExport(GastoDomain obj) {
        return new Object[]{
            obj.getCuadreFk().info().getNombre(),
            obj.getCuadreFk().info().getDocumento(),
            obj.getTipoGastoFk().getNombreGasto(),
            obj.getCuadreFk().info().getFecha(),
            MoneyTableComponent.from(obj.getValor(), obj.getMonedaFk()).toString(),
            obj.getCuadreFk().info().getFormaPagoFk().getNombreFormaPago(),
            obj.getCuadreFk().getOperacionContableFk().getCuentaFk().getNombreCuenta(),
            obj.getCuadreFk().getOperacionContableCuadreFk().getCuentaFk().getNombreCuenta(),
            obj.getCuadreFk().info().getTipoOperacionFk().getNombreOperacion()
        };
    }

    @Override
    public String[] getColumnNamesExport() {
        return new String[]{
            "Nombre",
            "Documento",
            "Tipo de gasto",
            "Fecha",
            "Valor",
            "Forma de pago",
            "Cuenta Inicial",
            "Cuenta Cuadre",
            "Tipo de operación"
        };
    }

    @Override
    public void personalizeBuilder(ExcelListWriter.builder builder) {
        builder.updateValuesColumnCellStyle(3, (Workbook t, CellStyle u) -> {
            u.setDataFormat(t.createDataFormat().getFormat("dd-MMM-yyyy"));
            return u;
        });
    }
}
