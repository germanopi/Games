if(isInventory){ // Desenha as torres no inventario
	draw_set_color(c_purple);
	draw_rectangle(x,y,x+32,y+32,0);
	draw_set_color(c_black);
	draw_rectangle(x,y,x+32,y+32,1);
}else{ // Desenha o alcance das torres
	 draw_set_color(c_yellow);
	 draw_circle(x+16,y+16,90,1);
}
draw_self();	
