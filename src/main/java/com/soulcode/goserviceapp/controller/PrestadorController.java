package com.soulcode.goserviceapp.controller;

import com.soulcode.goserviceapp.domain.Agendamento;
import com.soulcode.goserviceapp.domain.Mensagem;
import com.soulcode.goserviceapp.domain.Prestador;
import com.soulcode.goserviceapp.domain.Servico;
import com.soulcode.goserviceapp.service.AgendamentoService;
import com.soulcode.goserviceapp.service.MensagemService;
import com.soulcode.goserviceapp.service.PrestadorService;
import com.soulcode.goserviceapp.service.ServicoService;
import com.soulcode.goserviceapp.service.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping(value = "/prestador")
public class PrestadorController {

    @Autowired
    private PrestadorService prestadorService;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private MensagemService mensagemService;

    @GetMapping(value = "/dados")
    public ModelAndView dados(Authentication authentication) {
        ModelAndView mv = new ModelAndView("dadosPrestador");
        try {
            Prestador prestador = prestadorService.findAuthenticated(authentication);
            mv.addObject("prestador", prestador);
            List<Servico> especialidades = servicoService.findByPrestadorEmail(authentication.getName());
            mv.addObject("especialidades", especialidades);
            List<Servico> servicos = servicoService.findAll();
            mv.addObject("servicos", servicos);
        } catch (UsuarioNaoAutenticadoException | UsuarioNaoEncontradoException ex) {
            mv.addObject("errorMessage", ex.getMessage());
        } catch (Exception ex) {
            mv.addObject("errorMessage", "Erro ao carregar dados do prestador.");
        }
        return mv;
    }

    @PostMapping(value = "/dados")
    public String editarDados(Prestador prestador, RedirectAttributes attributes) {
        try {
            prestadorService.update(prestador);
            attributes.addFlashAttribute("successMessage", "Dados alterados.");
        } catch (UsuarioNaoEncontradoException ex) {
            attributes.addFlashAttribute("errorMessage", ex.getMessage());
        } catch (Exception ex) {
            attributes.addFlashAttribute("errorMessage", "Erro ao alterar dados cadastrais.");
        }
        return "redirect:/prestador/dados";
    }

    @PostMapping(value = "/dados/especialidade/remover")
    public String removerEspecialidade(
            @RequestParam(name = "servicoId") Long id,
            Authentication authentication,
            RedirectAttributes attributes) {
        try {
            prestadorService.removeServicoPrestador(authentication, id);
            attributes.addFlashAttribute("successMessage", "Especialidade removida");
        } catch (UsuarioNaoAutenticadoException | UsuarioNaoEncontradoException | ServicoNaoEncontradoException ex) {
            attributes.addFlashAttribute("errorMessage", ex.getMessage());
        } catch (Exception ex) {
            attributes.addFlashAttribute("errorMessage", "Erro ao remover especialidade.");
        }
        return "redirect:/prestador/dados";
    }

    @PostMapping(value = "/dados/especialidade/adicionar")
    public String adicionarEspecialidade(
            @RequestParam(name = "servicoId") Long id,
            Authentication authentication,
            RedirectAttributes attributes) {
        try {
            prestadorService.addServicoPrestador(authentication, id);
            attributes.addFlashAttribute("successMessage", "Especialidade adicionada.");
        } catch (UsuarioNaoAutenticadoException | UsuarioNaoEncontradoException | ServicoNaoEncontradoException ex) {
            attributes.addFlashAttribute("errorMessage", ex.getMessage());
        } catch (Exception ex) {
            attributes.addFlashAttribute("errorMessage", "Erro ao adicionar nova especialidade.");
        }
        return "redirect:/prestador/dados";
    }

    @GetMapping(value = "/agenda")
    public ModelAndView agenda(Authentication authentication) {
        ModelAndView mv = new ModelAndView("agendaPrestador");
        try {
            List<Agendamento> agendamentos = agendamentoService.findByPrestador(authentication);
            mv.addObject("agendamentos", agendamentos);
        } catch (UsuarioNaoAutenticadoException | UsuarioNaoEncontradoException ex) {
            mv.addObject("errorMessage", ex.getMessage());
        } catch (Exception ex) {
            mv.addObject("errorMessage", "Erro ao carregar dados de agendamentos.");
        }
        return mv;
    }

    @PostMapping(value = "/agenda/cancelar")
    public String cancelarAgendamento(
            @RequestParam(name = "agendamentoId") Long agendamentoId,
            Authentication authentication,
            RedirectAttributes attributes) {
        try {
            agendamentoService.cancelAgendaPrestador(authentication, agendamentoId);
            attributes.addFlashAttribute("successMessage", "Agendamento cancelado.");
        } catch (UsuarioNaoAutenticadoException | UsuarioNaoEncontradoException |
                AgendamentoNaoEncontradoException | StatusAgendamentoImutavelException ex) {
            attributes.addFlashAttribute("errorMessage", ex.getMessage());
        } catch (Exception ex) {
            attributes.addFlashAttribute("errorMessage", "Erro ao cancelar agendamento.");
        }
        return "redirect:/prestador/agenda";
    }

    @PostMapping(value = "/agenda/confirmar")
    public String confirmarAgendamento(
            @RequestParam(name = "agendamentoId") Long agendamentoId,
            Authentication authentication,
            RedirectAttributes attributes) {
        try {
            agendamentoService.confirmAgenda(authentication, agendamentoId);
            attributes.addFlashAttribute("successMessage", "Agendamento confirmado.");
        } catch (UsuarioNaoAutenticadoException | UsuarioNaoEncontradoException |
                 AgendamentoNaoEncontradoException | StatusAgendamentoImutavelException ex) {
            attributes.addFlashAttribute("errorMessage", ex.getMessage());
        } catch (Exception ex) {
            attributes.addFlashAttribute("errorMessage", "Erro ao confirmar agendamento.");
        }
        return "redirect:/prestador/agenda";
    }

    @GetMapping(value = "/agenda/chat/{id}")
    public ModelAndView buscarMensagens(@PathVariable Long id)
    {
        ModelAndView mv = new ModelAndView("chatPrestador");
        try {
            List<Mensagem> mensagens = mensagemService.findByAgendamentoId(id);
            mv.addObject("mensagens", mensagens);
            mv.addObject("agendamentoId", id);
        } catch (UsuarioNaoAutenticadoException | UsuarioNaoEncontradoException ex) {
            mv.addObject("errorMessage", ex.getMessage());
        } catch (Exception ex) {
            mv.addObject("errorMessage", "Erro ao carregar mensagens.");
        }
        return mv;
    }

    @PostMapping(value = "/agenda/chat/enviar")
    public String enviarMensagem(
            @RequestParam(name = "agendamentoId") Long agendamentoId,
            @RequestParam(name = "conteudo") String conteudo,
            Authentication authentication,
            RedirectAttributes attributes) {
        try {
            LocalDateTime dataHora = LocalDateTime.now();
            mensagemService.createMensagemByPrestador(authentication, agendamentoId, dataHora, conteudo);
        } catch (UsuarioNaoAutenticadoException | UsuarioNaoEncontradoException |
                 AgendamentoNaoEncontradoException ex) {
            attributes.addFlashAttribute("errorMessage", ex.getMessage());
        } catch (Exception ex) {
            attributes.addFlashAttribute("errorMessage", ex.getMessage());
        }

        return "redirect:/prestador/agenda/chat/" + agendamentoId;
    }
}
