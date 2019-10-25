(function() {
    var $body = document.body
    , $menu_trigger = $body.getElementsByClassName('menu-trigger')[0];
    if ( typeof $menu_trigger !== 'undefined' ) {
      if(window.innerWidth>480){
        $menu_trigger.addEventListener('click', function() {
          $body.className = ( $body.className == 'menu-active' )? '' : 'menu-active';
        });
      }else{
        $menu_trigger.addEventListener('click', function() {
          $body.className = ( $body.className == 'menu-active' )? '' : 'menu-active';
        });
      }
    }
}).call(this);