/// @description Insert description here
// You can write your code in this editor
if(instance_number(obj_server) == 0){
	if(keyboard_check(vk_right) && place_free(x+2,y)){
		x+=2;
		image_xscale = 1;
	}else if(keyboard_check(vk_left) && place_free(x-2,y)){
		x-=2;
		image_xscale = -1;
	}
	
	if(keyboard_check(vk_up) && place_free(x,y-2)){
		y-=2;
	}else if(keyboard_check(vk_down) && place_free(x,y+2)){
		y+=2;
	}
	
	if(keyboard_check_pressed(ord("X"))){
		buffer_seek(obj_cliente.buff, buffer_seek_start, 0);
		buffer_write(obj_cliente.buff,buffer_string,"nova_bullet");
		buffer_write(obj_cliente.buff,buffer_s16,x);
		buffer_write(obj_cliente.buff,buffer_s16,y);
		buffer_write(obj_cliente.buff,buffer_s16,image_xscale);
		network_send_packet(obj_cliente.client,buff,buffer_tell(buff));
	}
}