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
package com.root101.module.gestion.gastos.ui.module;

import com.root101.clean.swing.app.AbstractSwingApplication;
import com.root101.clean.swing.app.DefaultAbstractSwingMainModule;
import com.root101.clean.swing.app.dashboard.DashBoardSimple;
import com.root101.clean.swing.app.dashboard.DashboardConstants;
import com.root101.module.gestion.gastos.service.ResourceServiceImplementation;
import com.root101.module.gestion.gastos.consume.module.GastosConsumeCoreModule;
import com.root101.module.gestion.gastos.service.ResourceServiceClientImplementation;
import com.root101.module.gestion.gastos.ui.GastosMainPanel;
import com.jhw.swing.material.components.taskpane.SingleCollapseMenu;
import com.root101.module.gestion.gastos.consume.usecase_def.*;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class GastoSwingModule extends DefaultAbstractSwingMainModule {

    private final GastoModuleNavigator navigator = new GastoModuleNavigator();

    public final static GastoUseCaseConsume gastoUC;
    public final static TipoGastoUseCaseConsume tipoGastoUC;

    static {
        gastoUC = GastosConsumeCoreModule.getInstance().getImplementation(GastoUseCaseConsume.class);
        tipoGastoUC = GastosConsumeCoreModule.getInstance().getImplementation(TipoGastoUseCaseConsume.class);
    }

    private GastoSwingModule() {
    }

    public static GastoSwingModule init() {
        System.out.println("Iniciando 'Gastos'");

        ResourceServiceClientImplementation.init();
        ResourceServiceImplementation.init();

        return new GastoSwingModule();
    }

    @Override
    public void register(AbstractSwingApplication app) {
        registerMainElements(app);
    }

    private void registerMainElements(AbstractSwingApplication app) {
        DashBoardSimple dash = app.rootView().dashboard();

        dash.addView(GastoModuleNavigator.NAV_GASTO, new GastosMainPanel());
        SingleCollapseMenu menu = new SingleCollapseMenu(new AbstractAction(GastoModuleNavigator.GASTO, GastoModuleNavigator.ICON_GASTO) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(GastoModuleNavigator.NAV_GASTO);
            }
        });
        dash.addKeyValue(DashboardConstants.MAIN_ELEMENT, menu);
        /*CollapseMenu menu = new CollapseMenu(MaterialIcons.SHOPPING_CART, GastoModuleNavigator.GASTO);
         dash.addKeyValue(DashboardConstants.MAIN_ELEMENT, menu);
 
         dash.addView(GastoModuleNavigator.GASTO, new GastosMainPanel());
         menu.addMenuItem(new AbstractAction(GastoModuleNavigator.GASTO, MaterialIcons.SHOPPING_CART) {
         @Override
         public void actionPerformed(ActionEvent e) {
         app.navigateTo(GastoModuleNavigator.GASTO);
         }
         });*/

    }

    @Override
    public void navigateTo(String string, Object... o) {
        navigator.navigateTo(string, o);
    }

}
