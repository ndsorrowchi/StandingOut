/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





$(document).scroll(function(){
    
    console.log($(window).scrollTop());
    if ($(window).scrollTop() + $(window).height() == $(document).height()) {
        // Reached page bottom. Call the ajax function or any other foo here.
        
    }
});