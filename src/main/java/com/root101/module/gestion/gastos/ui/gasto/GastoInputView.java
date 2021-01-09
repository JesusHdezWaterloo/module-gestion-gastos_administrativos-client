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

import com.root101.module.gestion.contabilidad.core.domain.facade.CuadreUI;
import com.root101.module.gestion.contabilidad.core.domain.facade.DocNombreUI;
import com.root101.module.gestion.contabilidad.core.domain.facade.FechaDescUI;
import com.root101.module.gestion.contabilidad.core.domain.facade.OperacionCuadreUI;
import com.root101.module.gestion.contabilidad.ui.cuadre.pedazos.DocNombreInputView;
import com.root101.module.gestion.contabilidad.ui.cuadre.pedazos.FechaDescInputView;
import com.root101.module.gestion.contabilidad.ui.cuadre.pedazos.OperacionCuadreInputView;
import com.root101.module.gestion.gastos.core.domain.GastoDomain;
import com.root101.module.gestion.gastos.core.domain.TipoGastoDomain;
import com.root101.module.gestion.gastos.ui.module.GastoSwingModule;
import com.root101.module.gestion.gastos.ui.tipo_gasto.TipoGastoICBS;
import com.root101.swing.material.components.container.layout.VerticalLayoutContainer;
import com.root101.swing.models.clean.CleanCRUDInputView;
import java.time.LocalDate;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class GastoInputView extends CleanCRUDInputView<GastoDomain> {

    public static GastoInputView from() {
        return new GastoInputView(null);
    }

    public static GastoInputView fromModel(GastoDomain model) {
        return new GastoInputView(model);
    }

    public static GastoInputView fromBase(TipoGastoDomain tipo) {
        GastoInputView thiss = new GastoInputView(null);
        thiss.setTipoGasto(tipo);
        return thiss;
    }

    private GastoInputView(GastoDomain model) {
        super(model, GastoSwingModule.gastoUC, GastoDomain.class);
        initComponents();
        addListener();
        update();
    }

    private void initComponents() {
        //doc, nombre ....
        docNombreInputView = DocNombreInputView.from();

        //valor, cuentas ....
        operacionInputView = OperacionCuadreInputView.from();

        //tipo gasto
        tipoGastoICBS = new TipoGastoICBS();

        //fecha, desc ....
        fechaDescInputView = FechaDescInputView.from();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder(400);
        vlc.add(docNombreInputView);
        vlc.add(operacionInputView);
        vlc.add(tipoGastoICBS);
        vlc.add(fechaDescInputView, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private DocNombreInputView docNombreInputView;
    private OperacionCuadreInputView operacionInputView;
    private TipoGastoICBS tipoGastoICBS;
    private FechaDescInputView fechaDescInputView;
    // End of variables declaration

    @Override
    public void update() {
        tipoGastoICBS.update();
        if (getOldModel() == null) {
            setHeader("Crear Gasto");
        } else {
            setHeader("Editar Gasto");
            tipoGastoICBS.setObject(getOldModel().getTipoGastoFk());

            fechaDescInputView.setObject(new FechaDescUI(getOldModel().getCuadreFk().info()));
            docNombreInputView.setObject(new DocNombreUI(getOldModel().getCuadreFk().info()));

            operacionInputView.setObject(new OperacionCuadreUI(getOldModel().getCuadreFk()));
            operacionInputView.getMoneda().setObject(getOldModel().getMonedaFk());
            operacionInputView.getTextFieldValor().setObject(getOldModel().getValor());
            operacionInputView.getTipoOperICBS().setEnabled(false);
        }
    }

    @Override
    public GastoDomain getNewModel() throws Exception {
        DocNombreUI docNombre = docNombreInputView.getNewModel();
        OperacionCuadreUI op = operacionInputView.getNewModel();
        FechaDescUI fechaDesc = fechaDescInputView.getNewModel();
        TipoGastoDomain tipoGasto = tipoGastoICBS.getObject();

        CuadreUI cuadre = new CuadreUI(docNombre, op, fechaDesc);

        GastoDomain neww = new GastoDomain(op.getValor(), op.getMoneda(), cuadre.buildCuadre(), tipoGasto);

        if (getOldModel() == null) {
            return neww;
        } else {
            neww.setIdGasto(getOldModel().getIdGasto());
            neww.getCuadreFk().setIdCuadre(getOldModel().getCuadreFk().getIdCuadre());
            return neww;
        }
    }

    private void addListener() {
        tipoGastoICBS.addActionListener((java.awt.event.ActionEvent evt) -> {
            onGastoComboBoxActionPerformed();
        });
    }

    private void onGastoComboBoxActionPerformed() {
        try {
            setTipoGasto(tipoGastoICBS.getObject());
        } catch (Exception e) {
        }
    }

    private void setTipoGasto(TipoGastoDomain tipo) {
        fechaDescInputView.setObject(new FechaDescUI(LocalDate.now(), tipo.getFormaPagoFk(), tipo.getDescripcion()));
        docNombreInputView.setObject(new DocNombreUI("Pago de " + tipo.getNombreGasto(), "-"));

        tipoGastoICBS.setObject(tipo);

        operacionInputView.getMoneda().setObject(tipo.getMonedaDefectoFk());
        operacionInputView.setTipoOp(tipo.getTipoOperacionContableDefectoFk());
        operacionInputView.getTipoOperICBS().setEnabled(false);
    }

}
