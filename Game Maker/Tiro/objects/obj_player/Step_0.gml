image_angle=point_direction(x,y,mouse_x,mouse_y);

if(keyboard_check(ord("W")) && place_free(x+lengthdir_x(velocidade,image_angle),y+lengthdir_y(velocidade,image_angle))){
	x+=lengthdir_x(velocidade,image_angle);
	y+=lengthdir_y(velocidade,image_angle);
}

if(mouse_check_button_pressed(mb_left)&&!shoot){
	shoot=true;
	alarm[0]=10;
}
if(shoot){
var dx=x+lengthdir_x(100,image_angle);
var dy=y+lengthdir_y(100,image_angle);
var obj=collision_line(x,y,dx,dy,obj_enemy,false,true);
if(obj){
	with(obj){
		life--;
	}
}
}
	
	if(place_meeting(x,y,obj_enemy)){
		if(random(100)<5){
			life--;
		}
	}
	
	if(life<=0){
		room_restart()
	}