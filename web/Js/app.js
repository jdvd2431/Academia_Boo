/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const ham_menu = document.querySelector(".ham-menu");
const container = document.querySelector(".container");



ham_menu.addEventListener("click", () =>{
    container.classList.toggle("active");
});

