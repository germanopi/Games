/// @description Insert description here
// You can write your code in this editor
buffer_seek(buff, buffer_seek_start, 0);

buffer_write(buff,buffer_string,"atualizar_posicao");
buffer_write(buff,buffer_s16,obj_player.x);
buffer_write(buff,buffer_s16,obj_player.y);
buffer_write(buff,buffer_s16,obj_player.image_xscale);

network_send_packet(client,buff,buffer_tell(buff));

