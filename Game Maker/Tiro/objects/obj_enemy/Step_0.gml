image_angle=point_direction(x,y,obj_player.x,obj_player.y);
direction=image_angle;
if(random(100)<40){	
speed=2;
}else{
	speed=0;
}

if(life<=0){
	instance_destroy();
	instance_create_depth(x,y,0,obj_blood);
}