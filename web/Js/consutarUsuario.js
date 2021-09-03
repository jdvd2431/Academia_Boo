/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var btnAbrirRegistro = document.getElementById('abrir-registrar'),
    overlay = document.getElementById('overlay'),
    btnCerrarRegistro = document.getElementById('cerrar-registro');

btnAbrirRegistro.addEventListener('click', function() {
    overlay.classList.add('activado')
});
btnCerrarRegistro.addEventListener('click', function() {
    overlay.classList.remove('activado')
});
