if(keyboard_check(ord("J"))){ // Salva o jogo
	game_save("Save.dat");
}
if(keyboard_check(ord("K"))){ // Carrega o jogo
	game_load("Save.dat");
}