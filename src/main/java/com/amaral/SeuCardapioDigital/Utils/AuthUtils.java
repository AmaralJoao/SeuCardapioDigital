package com.amaral.SeuCardapioDigital.Utils;

import com.amaral.SeuCardapioDigital.Model.EstabelecimentoModel;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtils {

    public static EstabelecimentoModel getEstabelecimentoAutenticado() {
        return (EstabelecimentoModel) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

    public static Long getIdEstabelecimento() {
        return getEstabelecimentoAutenticado().getId();
    }
}
