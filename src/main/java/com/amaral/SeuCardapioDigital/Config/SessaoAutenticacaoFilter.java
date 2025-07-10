package com.amaral.SeuCardapioDigital.Config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.amaral.SeuCardapioDigital.Model.EstabelecimentoModel;
import com.amaral.SeuCardapioDigital.Model.SessaoModel;
import com.amaral.SeuCardapioDigital.Repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class SessaoAutenticacaoFilter extends OncePerRequestFilter {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Session ")) {
            String token = header.substring(8);

            Optional<SessaoModel> sessaoOpt = sessaoRepository.findByTokenAndAtivaTrue(token);
            if (sessaoOpt.isPresent() && sessaoOpt.get().getExpiraEm().isAfter(LocalDateTime.now())) {

                EstabelecimentoModel estabelecimento = sessaoOpt.get().getEstabelecimento();

                Authentication auth = new UsernamePasswordAuthenticationToken(
                        estabelecimento, null, List.of()); // Você pode adicionar roles aqui se necessário

                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        filterChain.doFilter(request, response);
    }
}

