$(document).ready(function(){
    $('h1').textillate({ 
        in: { 
        effect: 'bounceInDown',
        shuffle: true,
        }
    });

    $('.town').textillate({
        loop: true,
        initialDelay: 1000,
        minDisplayTime: 1000,
        in:{
        effect: 'wobble',
        sync: true,
        },
        
        out:{
        effect: 'wobble',
        sync: true,
        }
    });
    
    $('.message').click(function() {
        $(this).text(function(i, text){
          return text === 'send me a message' ? 'send me a message to vamsikgs@gmail.com' : 'send me a message';
        });
        $(this).toggleClass('message');
    });
    
    $(window).on('resize',function(){
        $('.footer').toggleClass('footer-remove', $(window).width() > 767);
    }).resize();
});