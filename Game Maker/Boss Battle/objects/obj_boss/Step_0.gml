if(estado_atual==atacar){
	// Perseguir
	mp_potential_step(obj_player.x,obj_player.y,spd,0);
} else if(estado_atual==recuar){
	// Horizontal
	if(x<xstart){
		x+=4;
		if(x>xstart){
			x=xstart;
		}
	}else if(x>xstart){
		x-=4;
		if(x<xstart){
			x=xstart;
		}
	}
	// Vertical
	if(y<ystart){
		y+=4;
		if(y>ystart){
			y=ystart;
		}
	}else if(y>ystart){
		y-=4;
		if(y<ystart){
			y=ystart;
		}
	}
	
}else if (estado_atual==parado){
	// FAZ NADA 
}