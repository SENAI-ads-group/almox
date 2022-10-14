package org.almox.modules.operador.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailsServiceImpl implements UserDetailsService {

    private final OperadorService operadorService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return operadorService.buscarPorLoginOptional(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
