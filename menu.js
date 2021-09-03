/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    $('.sidebar .menu li:has(ul)').click(function(e){
        e.preventDefault();
        if($(this).hasClass('activado')){
           $(this).removeClass('activado');
           $(this).children('ul').slideUp();
        }else{
            $('.menu li ul').slideUp();
            $('.menu li').removeClass('actiavdo');
            $(this).addClass('activado');
            $(this).children('ul'),slideDown();
        }
    });
});
