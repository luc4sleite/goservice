(() => {
  'use strict'


  const forms = document.querySelectorAll('.needs-validation')


  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})()

// bloqueando a seleção de uma data anterior ao dia de hoje no formulario de agendar servico.
document.addEventListener("DOMContentLoaded", function (){
    var dataInput = document.getElementById("data");
    var hoje = new Date().toISOString().split("T")[0];
    dataInput.setAttribute("min", hoje);
});

const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))