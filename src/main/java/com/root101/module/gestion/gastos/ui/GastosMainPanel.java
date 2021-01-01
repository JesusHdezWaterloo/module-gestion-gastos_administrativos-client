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
package com.root101.module.gestion.gastos.ui;

import com.root101.module.gestion.gastos.ui.gasto.GastoDetailView;
import com.root101.module.gestion.gastos.ui.tipo_gasto.TipoGastoDetailView;
import com.root101.utils.interfaces.Update;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import java.awt.BorderLayout;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class GastosMainPanel extends _PanelTransparent implements Update {

    public GastosMainPanel() {
        initComponents();
    }

    private void initComponents() {
        gastoDetailView = new GastoDetailView();
        tipoGastoDetailView = new TipoGastoDetailView();
        this.setLayout(new BorderLayout());
        this.add(gastoDetailView, BorderLayout.CENTER);
        this.add(tipoGastoDetailView, BorderLayout.EAST);
    }

    // Variables declaration - do not modify
    private TipoGastoDetailView tipoGastoDetailView;
    private GastoDetailView gastoDetailView;
    // End of variables declaration                   

    @Override
    public void update() {
        tipoGastoDetailView.update();
        gastoDetailView.update();
    }
}