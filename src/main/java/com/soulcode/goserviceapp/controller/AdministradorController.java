package com.soulcode.goserviceapp.controller;

import com.soulcode.goserviceapp.domain.*;
import com.soulcode.goserviceapp.repository.AgendamentoRepository;
import com.soulcode.goserviceapp.service.*;
import com.soulcode.goserviceapp.service.exceptions.ServicoNaoEncontradoException;
import com.soulcode.goserviceapp.service.exceptions.UsuarioNaoAutenticadoException;
import com.soulcode.goserviceapp.service.exceptions.UsuarioNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/admin")
public class AdministradorController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private AgendamentoLogService agendamentoLogService;

    @Autowired
    private PrestadorService prestadorService;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private UsuarioLogService usuarioLogService;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private AdministradorService administradorService;


    @GetMapping(value = "/servicos")
    public ModelAndView servicos() {
        ModelAndView mv = new ModelAndView("servicosAdmin");
        try {
            List<Servico> servicos = servicoService.findAll();
            mv.addObject("servicos", servicos);
            List<Agendamento> agendamentos = agendamentoService.findAll();
            mv.addObject("agendamentos", agendamentos);
        }
        catch (Exception ex) {
            mv.addObject("errorMessage", "Erro ao buscar dados de serviços.");
        }
        return mv;
    }




    @PostMapping(value = "/servicos")
    public String createService(Servico servico, RedirectAttributes attributes) {
        try {
            servicoService.createServico(servico);
            attributes.addFlashAttribute("successMessage", "Novo serviço adicionado.");
        } catch (Exception ex) {
            attributes.addFlashAttribute("errorMessage", "Erro ao adicionar novo serviço.");
        }
        return "redirect:/admin/servicos";
    }

    @PostMapping(value = "/servicos/remover")
    public String removeService(@RequestParam(name = "servicoId") Long id, RedirectAttributes attributes) {
        try {
            servicoService.removeServicoById(id);
            attributes.addFlashAttribute("successMessage", "Serviço removido.");
        } catch (Exception ex) {
            attributes.addFlashAttribute("errorMessage", "Erro ao excluir serviço.");
        }
        return "redirect:/admin/servicos";
    }

    @GetMapping(value = "/servicos/editar/{id}")
    public ModelAndView editService(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("editarServico");
        try {
            Servico servico = servicoService.findById(id);
            mv.addObject("servico", servico);
        } catch (ServicoNaoEncontradoException ex) {
            mv.addObject("errorMessage", ex.getMessage());
        } catch (Exception ex) {
            mv.addObject("errorMessage", "Erro ao buscar dados do serviço.");
        }
        return mv;
    }

    @PostMapping(value = "/servicos/editar")
    public String updateService(Servico servico, RedirectAttributes attributes) {
        try {
            servicoService.update(servico);
            attributes.addFlashAttribute("successMessage", "Dados do serviço alterados.");
        } catch (ServicoNaoEncontradoException ex) {
            attributes.addFlashAttribute("errorMessage", ex.getMessage());
        } catch (Exception ex) {
            attributes.addFlashAttribute("errorMessage", "Erro ao alterar dados do serviço.");
        }
        return "redirect:/admin/servicos";
    }

    @GetMapping(value = "/usuarios")
    public ModelAndView usuarios() {
        ModelAndView mv = new ModelAndView("usuariosAdmin");
        try {
            List<Usuario> usuarios = usuarioService.findAll();
            mv.addObject("usuarios", usuarios);
        } catch (Exception ex) {
            mv.addObject("errorMessage", "Erro ao buscar dados de usuários.");
        }
        return mv;
    }

    @PostMapping(value = "/usuarios")
    public String createUser(Usuario usuario, RedirectAttributes attributes) {
        try {
            usuarioService.createUser(usuario);
            attributes.addFlashAttribute("successMessage", "Novo usuário cadastrado.");
        } catch (Exception ex) {
            attributes.addFlashAttribute("errorMessage", "Erro ao cadastrar novo usuário.");
        }
        return "redirect:/admin/usuarios";
    }

    @PostMapping(value = "/usuarios/disable")
    public String disableUser(@RequestParam(name = "usuarioId") Long id, RedirectAttributes attributes) {
        try {
            usuarioService.disableUser(id);
        } catch (UsuarioNaoEncontradoException ex) {
            attributes.addFlashAttribute("errorMessage", ex.getMessage());
        } catch (Exception ex) {
            attributes.addFlashAttribute("errorMessage", "Erro ao desabilitar usuário.");
        }
        return "redirect:/admin/usuarios";
    }

    @PostMapping(value = "/usuarios/enable")
    public String enableUser(@RequestParam(name = "usuarioId") Long id, RedirectAttributes attributes) {
        try {
            usuarioService.enableUser(id);
        } catch (UsuarioNaoEncontradoException ex) {
            attributes.addFlashAttribute("errorMessage", ex.getMessage());
        } catch (Exception ex) {
            attributes.addFlashAttribute("errorMessage", "Erro ao habilitar usuário.");
        }
        return "redirect:/admin/usuarios";
    }

    @GetMapping(value = "/dashboard")
    public ModelAndView dashboard() {
        ModelAndView mv = new ModelAndView("dashboard");
        try {
            List<UsuarioLog> logsAuth = usuarioLogService.findAll();
            List<AgendamentoLog> logsAgendamento = agendamentoLogService.findAll();
            mv.addObject("logsAuth", logsAuth);
            mv.addObject("logsAgendamento", logsAgendamento);
        } catch (Exception ex) {
            mv.addObject("errorMessage", "Erro ao buscar dados de log de autenticação.");
        }
        return mv;
    }

    @GetMapping(value = "/dados")
    public ModelAndView dados(Authentication authentication) {
        ModelAndView mv = new ModelAndView("dadosAdmin");
        try {
            Administrador administrador = administradorService.findAuthenticated(authentication);
            mv.addObject("administrador", administrador);
        } catch (UsuarioNaoAutenticadoException | UsuarioNaoEncontradoException ex) {
            mv.addObject("errorMessage", ex.getMessage());
        } catch (Exception ex) {
            mv.addObject("errorMessage", "Erro ao buscar dados do cliente.");
        }
        return mv;
    }

    @PostMapping(value = "/dados")
    public String alterarDados(Administrador administrador, RedirectAttributes attributes) {
        try {
            administradorService.update(administrador);
            attributes.addFlashAttribute("successMessage", "Dados alterados.");
        } catch (UsuarioNaoEncontradoException ex) {
            attributes.addFlashAttribute("errorMessage", ex.getMessage());
        } catch (Exception ex) {
            attributes.addFlashAttribute("errorMessage", "Erro ao alterar dados cadastrais.");
        }
        return "redirect:/admin/dados";
    }

    @PostMapping(value = "/usuarios/busca")
    public ModelAndView buscarUsuario(@RequestParam(name= "buscaUsuario") String usuario) {
        ModelAndView mv = new ModelAndView("usuariosAdmin");
        try {
            List<Usuario>  usuarios = usuarioService.findByName(usuario);
            mv.addObject("usuarios", usuarios);
        }
        catch (Exception ex) {
            mv.addObject("errorMessage", "Usuario não encontrado");
        }
        return mv;
    }
}
