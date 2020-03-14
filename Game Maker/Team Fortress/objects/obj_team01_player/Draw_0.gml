draw_self(); // Renderização padrão

// Novas renderizações

// Renderiza a arma 
draw_sprite_ext(spriteArma,0,x+(22*image_xscale),y+7,image_xscale,image_yscale,0,c_white,1);


// Renderiza a interface de vida 
var xx = x - 60;
var yy = y - 60;

var width = xx + ((vida/100) * 100);
var height = yy+25;

draw_set_color(c_red);
draw_rectangle(xx,yy,xx+100,height,0);

draw_set_color(c_green);
draw_rectangle(xx,yy,width,height,0);