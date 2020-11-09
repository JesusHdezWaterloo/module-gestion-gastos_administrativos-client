package com.jhw.module.gestion.gastos.consume.usecase_def;

import com.jhw.module.gestion.contabilidad.core.domain.MonedaDomain;
import com.jhw.module.gestion.contabilidad.core.usecase_def.*;

public interface MonedaUseCaseConsume extends MonedaUseCase {

    public MonedaDomain getMonedaBase();
}
