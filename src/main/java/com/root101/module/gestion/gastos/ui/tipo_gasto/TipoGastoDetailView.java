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
package com.root101.module.gestion.gastos.ui.tipo_gasto;

import com.root101.clean.core.app.services.ExceptionHandler;
import com.root101.module.gestion.gastos.core.domain.TipoGastoDomain;
import com.root101.module.gestion.gastos.ui.module.GastoSwingModule;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import java.awt.event.ActionEvent;
import com.root101.module.gestion.gastos.ui.gasto.GastoInputView;
import com.root101.module.gestion.gastos.ui.module.GastoModuleNavigator;
import javax.swing.AbstractAction;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class TipoGastoDetailView extends _MaterialPanelDetail<TipoGastoDomain> {

    private static final String COL_GASTO = "Gasto";

    public TipoGastoDetailView() {
        super(
                Column.builder().name(COL_GASTO).build()
        );

        this.personalize();
    }

    private void personalize() {
        addActionsExtra();

        this.setHeaderText("Tipos de gastos");
        this.setIcon(GastoModuleNavigator.ICON_TIPO_GASTO);

        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(GastoSwingModule.tipoGastoUC.findAll());
            firePropertyChange("update", null, null);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    @Override
    public Object[] getRowObject(TipoGastoDomain obj) {
        return new Object[]{
            obj.getNombreGasto()};
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, TipoGastoInputView.from());
    }

    @Override
    protected TipoGastoDomain deleteAction(TipoGastoDomain obj) {
        try {
            return GastoSwingModule.tipoGastoUC.destroy(obj);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(TipoGastoDomain obj) {
        new DialogModelInput(this, TipoGastoInputView.fromModel(obj));
    }

    @Override
    protected void viewAction(TipoGastoDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

    private void addActionsExtra() {
        this.addActionExtra(new AbstractAction("Gastar", GastoModuleNavigator.ICON_GASTO.deriveIcon(18f)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPayGastoActionPerformed();
            }
        });
    }

    private void onPayGastoActionPerformed() {
        new DialogModelInput(this, GastoInputView.fromBase(getSelectedElement()));
    }
}
