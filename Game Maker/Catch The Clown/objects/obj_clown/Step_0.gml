// Step é SEMPRE chamado, é o gameloop

if(!place_meeting(x+(dx*spd),y,obj_box)){ // Permite avançar se não for colidir na horizontal
	x+=dx*spd;	// Avança na horizontal
}else{
	dx*=-1;	// Inverte a direção horizontal
}

if(!place_meeting(x,y+(dy*spd),obj_box)){  // Permite avançar se não for colidir na vertical
	y+=dy*spd;	// Avança na vertical
}else{
	dy*=-1;	// Inverte a direção vertical
}

image_angle = point_direction(xprevious,yprevious,x,y); // Atualiza o angulo da imagem para as novas direções