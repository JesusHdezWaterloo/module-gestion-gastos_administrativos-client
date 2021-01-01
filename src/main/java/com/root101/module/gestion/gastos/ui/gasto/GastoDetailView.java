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
package com.root101.module.gestion.gastos.ui.gasto;

import com.root101.clean.core.app.services.ExceptionHandler;
import com.root101.module.gestion.gastos.ui.module.GastoSwingModule;
import java.awt.event.ActionEvent;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyCellRender;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyTableComponent;
import com.root101.module.gestion.gastos.core.domain.GastoDomain;
import com.root101.module.gestion.gastos.ui.module.GastoModuleNavigator;
import com.root101.module.gestion.gastos.ui.report.chart.GastosReport;
import com.root101.module.gestion.gastos.ui.report.export.GastoExport;
import com.jhw.swing.material.components.button._MaterialButtonPopup;
import com.jhw.swing.models.clean.CleanDetailCRUDDragDrop;
import com.jhw.swing.models.input.panels.ModelPanel;
import com.root101.utils.others.DTF;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class GastoDetailView extends CleanDetailCRUDDragDrop<GastoDomain> {

    private static final String COL_GASTO = "Gasto";
    private static final String COL_VALOR = "Valor";
    private static final String COL_FECHA = "Fecha";
    //private static final String COL_CUADRE = "Cuadre";
    private static final String COL_CUENTA = "Cuenta";

    public GastoDetailView() {
        super(
                Column.builder().name(COL_GASTO).build(),
                Column.builder().name(COL_VALOR).build(),
                Column.builder().name(COL_FECHA).build(),
                //Column.builder().name(COL_CUADRE).build(),
                Column.builder().name(COL_CUENTA).build()
        );

    }

    @Override
    protected void personalize() {
        setUpEditorsRenders();

        this.setHeaderText("Gastos Realizados");
        this.setIcon(GastoModuleNavigator.ICON_GASTO);

        addOptionsElements();

        this.getTableByPage().setPageVisibility(true);
        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia

        this.setExportConfig(GastoExport.from(this));
    }

    @Override
    protected List<GastoDomain> getListUpdate() throws Exception {
        return GastoSwingModule.gastoUC.findAll();
    }

    @Override
    public Object[] getRowObject(GastoDomain obj) {
        return new Object[]{
            obj.getTipoGastoFk(),
            MoneyTableComponent.from(obj.getValor(), obj.getMonedaFk()),
            DTF.LOCAL_DATE_FORMATTER.format(obj.getCuadreFk().info().getFecha()),
            obj.getCuadreFk().getOperacionContableFk().getCuentaFk()};
    }

    @Override
    protected void addPropertyChange() {
        GastoSwingModule.gastoUC.addPropertyChangeListener(this);
    }

    @Override
    protected ModelPanel<GastoDomain> getModelPanelNew() {
        return GastoInputView.from();
    }

    @Override
    protected ModelPanel<GastoDomain> getModelPanelEdit(GastoDomain obj) {
        return GastoInputView.fromModel(obj);
    }

    @Override
    protected GastoDomain deleteAction(GastoDomain obj) {
        try {
            return GastoSwingModule.gastoUC.destroy(obj);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void viewAction(GastoDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

    private void addOptionsElements() {
        _MaterialButtonPopup reportButton = new _MaterialButtonPopup();
        reportButton.setText("Reportes");
        reportButton.setIconTextGap(10);
        reportButton.setIcon(GastoModuleNavigator.ICON_REPORTE_GASTO);
        reportButton.setToolTipText("Reportes relacionados a los gastos.");//. Click para desplegar TODAS las opciones de exportación.

        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GastosReport.reportGastosByTipo();
            }
        });
        addOptionElement(reportButton);

    }

    private void setUpEditorsRenders() {
        getTable().getColumn(COL_VALOR).setCellRenderer(new MoneyCellRender());
    }

}
