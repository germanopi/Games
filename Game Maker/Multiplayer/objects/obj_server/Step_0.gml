/// @description Insert description here
// You can write your code in this editor
for (var k = ds_map_find_first(clients); !is_undefined(k); k = ds_map_find_next(clients, k)) {
		v = clients[? k];
		
		buffer_seek(buff, buffer_seek_start, 0);
		buffer_write(buff,buffer_string,"players");
		buffer_write(buff,buffer_s16,instance_number(obj_player)-1);
		with(obj_player){
			if(other.v.sock != sock){
				buffer_write(other.buff,buffer_s16,x);
				buffer_write(other.buff,buffer_s16,y);
				buffer_write(other.buff,buffer_s16,image_xscale);
			}
		}
		
		network_send_packet(v.sock, buff, buffer_tell(buff));
		
		buffer_seek(buff, buffer_seek_start, 0);
		buffer_write(buff,buffer_string,"bullets");
		buffer_write(buff,buffer_s16,instance_number(obj_bullet));
		with(obj_bullet){
				buffer_write(other.buff,buffer_s16,x);
				buffer_write(other.buff,buffer_s16,y);
			}
			
		network_send_packet(v.sock, buff, buffer_tell(buff));
}