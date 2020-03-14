draw_self(); // Renderização padrão

// Novas renderizações

// Renderiza a arma 
draw_sprite_ext(spr_item01,0,x+(22*image_xscale),y+7,image_xscale,image_yscale,0,c_white,1);

// Renderiza a interface de munição seguindo a camera
draw_set_font(fnt_game_ui);
draw_set_color(c_white);

draw_text(10 + camera_get_view_x(view_camera[0]),10,"Munição: "+string(ammo));

// Renderiza a interface de vida seguindo a camera
var xx = view_wport[0] - 290 + camera_get_view_x(view_camera[0]);
var yy = 10;

var width = xx + ((vida/100) * 270);
var height = yy+25;

draw_set_color(c_red);
draw_rectangle(xx,yy,xx+270,height,0);

draw_set_color(c_green);
draw_rectangle(xx,yy,width,height,0);