src_PlayerMove();
src_gravity();
src_key();
src_Ice();

if(place_meeting(x,y,obj_stair)){	
	src_stair();
}else if(place_meeting(x,y,obj_rope)){
	src_rope();
}else if(place_meeting(x+4,y,obj_elevator)|| place_meeting(x-4,y,obj_elevator)){
	src_elevator();
}else if (place_meeting(x,y+1,obj_ice)){
	onIce=true;
}

var inst=instance_place(x,y+1,obj_plataform);
if(inst!=noone){
	if(inst.dir==1){
		if(place_free(x+4,y)){
		x+=4;
		}
	}else{
		if(place_free(x-4,y)){
		x-=4;
		}
	}
}