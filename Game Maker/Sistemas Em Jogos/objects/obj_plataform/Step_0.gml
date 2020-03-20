if(dir==1){
	if(!place_meeting(x+4,y,obj_wall) && !place_meeting(x+4,y,obj_elevator)){
	x+=4;
	}else{
		dir=-1;
	}
}else{
	if(!place_meeting(x-4,y,obj_wall) && !place_meeting(x-4,y,obj_elevator)){
	x-=4;
	}else{
		dir=1;
	}
}
