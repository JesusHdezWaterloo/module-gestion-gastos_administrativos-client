package com.jhw.module.gestion.gastos.ui.module;

import com.root101.clean.swing.app.AbstractSwingApplication;
import com.root101.clean.swing.app.DefaultAbstractSwingMainModule;
import com.root101.clean.swing.app.dashboard.DashBoardSimple;
import com.root101.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.module.gestion.gastos.consume.module.GastosConsumeCoreModule;
import com.jhw.module.gestion.gastos.consume.usecase_def.*;
import com.jhw.module.gestion.gastos.service.ResourceServiceClientImplementation;
import com.jhw.module.gestion.gastos.service.ResourceServiceImplementation;
import com.jhw.module.gestion.gastos.ui.GastosMainPanel;
import com.jhw.swing.material.components.taskpane.SingleCollapseMenu;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

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
