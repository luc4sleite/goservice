package com.soulcode.goserviceapp.controller;

import com.soulcode.goserviceapp.domain.Endereco;
import com.soulcode.goserviceapp.domain.Usuario;
import com.soulcode.goserviceapp.repository.EnderecoRepository;
import com.soulcode.goserviceapp.service.EnderecoService;
import com.soulcode.goserviceapp.service.UsuarioService;
import com.soulcode.goserviceapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/new")
    public ModelAndView alterarEndereco(Authentication authentication) {
        ModelAndView mv = new ModelAndView("alterarEndereco");
        try{
            Usuario usuario = usuarioService.findAuthenticated(authentication);
            Endereco endereco = enderecoRepository.findEnderecoById(usuario.getId());
            mv.addObject("endereco", endereco);
            return mv;
        } catch (Exception ex) {
            mv.addObject("errorMessage", "Erro ao carregar endereço.");
            return mv;
        }
    }

    @PostMapping(value = "/new")
    public String updateEndereco(
            Authentication authentication,
            RedirectAttributes attributes,
            @RequestParam(name = "uf") String uf,
            @RequestParam(name = "cidade") String cidade,
            @RequestParam(name = "logradouro") String logradouro,
            @RequestParam(name = "numero") String numero
    ) {
        if (authentication != null && authentication.isAuthenticated()) {
            Usuario usuario  = usuarioService.findAuthenticated(authentication);
            Long enderecoId = usuarioRepository.findEnderecoByUsuarioId(usuario.getId());
            try {
                Endereco enderecoUpdated = enderecoRepository.findEnderecoById(enderecoId);
                enderecoService.updateEndereco(uf, cidade, logradouro, numero, enderecoId, enderecoUpdated);
                attributes.addFlashAttribute("successMessage", "Endereço alterado.");
            } catch (Exception ex) {
                attributes.addFlashAttribute("errorMessage", ex.getMessage());
            }
            return "redirect:/endereco/new";
        }
        throw new RuntimeException("Usuário não autenticado.");
    }

}