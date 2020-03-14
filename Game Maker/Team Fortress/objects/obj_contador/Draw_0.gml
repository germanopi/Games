
// Renderiza o contador de pontos de cada time
draw_set_color(c_white); // Cor branca
draw_set_halign(fa_center); // No meio da tela 
draw_set_font(fnt_game_ui2); // Fonte 2
draw_text(view_wport[0]/2 + camera_get_view_x(view_camera[0]),10,"TIME VERMELHO: "+string(time_0)+"/ TIME AZUL: "+string(time_1)); // Renderiza a mensagem
draw_set_halign(fa_left);  // Volta ao normal a centralização