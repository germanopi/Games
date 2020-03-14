// Inventario
draw_set_color(c_blue);
draw_rectangle(0,0,room_width,32,0);
// Desenha torre enquanto escolhe o local de colocar
if(towerHolder!=-1){ 
	draw_set_alpha(0.4);
	var xx=floor(mouse_x/32)*32;
	var yy= floor(mouse_y/32)*32;
	draw_sprite(towerHolder.sprite_index,0,xx,yy);
}

draw_set_alpha(1);