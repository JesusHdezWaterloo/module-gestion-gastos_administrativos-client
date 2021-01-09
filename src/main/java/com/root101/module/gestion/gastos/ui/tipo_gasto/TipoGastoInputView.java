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

import com.root101.module.gestion.contabilidad.ui.forma_pago.FormaPagoICBS;
import com.root101.module.gestion.contabilidad.ui.tipo_operacion.TipoOperacionContableICBS;
import com.root101.module.gestion.gastos.core.domain.TipoGastoDomain;
import com.root101.module.gestion.gastos.ui.module.GastoSwingModule;
import com.root101.swing.material.components.container.layout.VerticalLayoutContainer;
import com.root101.swing.material.components.textarea.MaterialTextArea;
import com.root101.swing.prepared.textarea.MaterialPreparedTextAreaFactory;
import com.root101.swing.material.components.textfield.MaterialTextFactory;
import com.root101.swing.material.components.textfield.MaterialTextFieldIcon;
import com.root101.swing.material.standards.MaterialIcons;
import com.root101.swing.models.clean.CleanCRUDInputView;
import java.util.Map;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class TipoGastoInputView extends CleanCRUDInputView<TipoGastoDomain> {

    public static TipoGastoInputView from() {
        return new TipoGastoInputView(null);
    }

    public static TipoGastoInputView fromModel(TipoGastoDomain model) {
        return new TipoGastoInputView(model);
    }

    private TipoGastoInputView(TipoGastoDomain model) {
        super(model, GastoSwingModule.tipoGastoUC, TipoGastoDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Tipo de gasto", "Editar Tipo de gasto");

        textFieldNombre = MaterialTextFactory.buildIcon();
        textFieldNombre.setLabel("Nombre");
        textFieldNombre.setHint("Nombre del gasto");
        textFieldNombre.setIcon(MaterialIcons.PRIORITY_HIGH);

        monedaICBS = new com.root101.module.gestion.contabilidad.ui.moneda.MonedaICBS();
        monedaICBS.setLabel("Moneda por defecto");
        monedaICBS.setIcon(MaterialIcons.ATTACH_MONEY);

        tipoOpICBS = new TipoOperacionContableICBS();
        tipoOpICBS.setLabel("Operación contable por defecto");

        formaPagoICBS = new FormaPagoICBS();

        textAreaDescripcion = MaterialPreparedTextAreaFactory.buildDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldNombre);
        vlc.add(monedaICBS);
        vlc.add(tipoOpICBS);
        vlc.add(formaPagoICBS);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private MaterialTextFieldIcon textFieldNombre;
    private com.root101.module.gestion.contabilidad.ui.moneda.MonedaICBS monedaICBS;
    private TipoOperacionContableICBS tipoOpICBS;
    private FormaPagoICBS formaPagoICBS;
    private MaterialTextArea textAreaDescripcion;
    // End of variables declaration                   

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> map = super.bindFields();
        map.put("nombreGasto", textFieldNombre);
        map.put("monedaDefectoFk", monedaICBS);
        map.put("tipoOperacionContableDefectoFk", tipoOpICBS);
        map.put("formaPagoFk", formaPagoICBS);
        map.put("descripcion", textAreaDescripcion);
        return map;
    }

}
