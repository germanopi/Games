/// @description Insert description here
// You can write your code in this editor
//Renderizar os outros players conectados no servidor.

for(var i = 0; i < ds_list_size(clientsX); i++){
	var xx = ds_list_find_value(clientsX,i);
	var yy = ds_list_find_value(clientsY,i);
	var xscale = ds_list_find_value(clientsXSCALE,i);
	draw_sprite_ext(spr_gamedude2,0,xx,yy,xscale,1,0,c_white,1);
}

// Renderizar as bullets no servidor

for(var i = 0; i < ds_list_size(bulletsX); i++){
	var xx = ds_list_find_value(bulletsX,i);
	var yy = ds_list_find_value(bulletsY,i);
	draw_sprite_ext(spr_bullet4,0,xx,yy,1,1,0,c_white,1);
}
